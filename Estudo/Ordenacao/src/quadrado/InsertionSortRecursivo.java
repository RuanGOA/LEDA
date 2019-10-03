package quadrado;

public class InsertionSortRecursivo {
	
	public InsertionSortRecursivo(int[] vetor) {
		sort(vetor);
	}
	
	private void sort(int[] vetor) {
		auxSort(vetor, 0);
	}

	private void auxSort(int[] vetor, int pos) {
		if(pos == vetor.length);
		else {
			
			int j = pos - 1;
			int cache = vetor[pos];
			while(j >= 0 && cache < vetor[j]) {
				vetor[j+1] = vetor[j];
				j--;
			}
			
			vetor[j+1] = cache;
			
			auxSort(vetor, pos + 1);
		}	
	}
}
