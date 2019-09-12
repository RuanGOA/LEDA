package enilogue;

public class MergeSortNormal {

	public MergeSortNormal(int[] vetor) {
		sort(vetor);
	}

	private void sort(int[] vetor) {
		int[] vetorAuxiliar = new int[vetor.length];
		mergeSort(vetor, vetorAuxiliar, 0, vetor.length - 1);
	}
	
	private void mergeSort(int[] vetor, int[] vetorAuxiliar, int l, int r) {
		if(l < r) {
			int mid = (l + r)/2;
			mergeSort(vetor, vetorAuxiliar, l, mid);
			mergeSort(vetor, vetorAuxiliar, mid + 1, r);
			merge(vetor, vetorAuxiliar, l, mid, r);
		}
	}

	private void merge(int[] vetor, int[] vetorAuxiliar, int l, int mid, int r) {
		for(int i = l; i <= r; i++) vetorAuxiliar[i] = vetor[i];
		
		int i = l;
		int j = mid + 1;
		for(int k = l; k <= r; k++) {
			if(i > mid) vetor[k] = vetorAuxiliar[j++];
			else if(j > r) vetor[k] = vetorAuxiliar[i++];
			else if(vetorAuxiliar[i] <= vetorAuxiliar[j]) 
				vetor[k] = vetorAuxiliar[i++];
			else vetor[k] = vetorAuxiliar[j++];
		}	
	}
}
