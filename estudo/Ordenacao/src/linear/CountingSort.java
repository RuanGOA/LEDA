package linear;

public class CountingSort {

	public CountingSort(int[] vetor, int left, int right) {
		sort(vetor, left, right);
	}
	
	public void sort(int[] vetor, int left, int right) {
		countingSort(vetor, left, right);
	}
	
	private void countingSort(int[] vetor, int left, int right) {
		int max = -1;
		for(int i = left; i <= right; i++) 
			if(vetor[i] > max) max = vetor[i];
		
		int[] vetorContagem = new int[max + 1];
		for(int i = 0; i < max + 1; i++) vetorContagem[i] = 0;
		
		for(int i = left; i <= right; i++)
			vetorContagem[vetor[i]]++;
		
		for(int i = 1; i < vetorContagem.length; i++)
			vetorContagem[i] += vetorContagem[i - 1];
		
		int[] vetorAuxiliar = new int[vetor.length];
		for(int i = left; i <= right; i++)
			vetorAuxiliar[--vetorContagem[vetor[i]]] = vetor[i];
		
		for(int i = left; i <= right; i++)
			vetor[i] = vetorAuxiliar[i];
	}
	
	
}
