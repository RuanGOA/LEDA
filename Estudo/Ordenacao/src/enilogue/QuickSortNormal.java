package enilogue;

import util.Util;

public class QuickSortNormal {

	Util util = new Util();
	
	public QuickSortNormal(int[] vetor) {
		sort(vetor);
	}

	private void sort(int[] vetor) {
		quickSort(vetor, 0, vetor.length -1);
		
	}

	private void quickSort(int[] vetor, int l, int r) {
		if(l < r) {
			int pivot = separa(vetor, l, r);
			quickSort(vetor, l, pivot - 1);
			quickSort(vetor,  pivot + 1, r);
		}
		
	}

	private int separa(int[] vetor, int l, int r) {
		int i = l;
		int j = r;
		
		int pivot = vetor[l];
		
		while(i <= j) {
			if(vetor[i] <= pivot) i++;
			else if(vetor[j] > pivot) j--;
			else if(i <= j) util.swap(vetor, i++, j--);
		}
		
		util.swap(vetor, l, j);
		
		return j;
	}	
}