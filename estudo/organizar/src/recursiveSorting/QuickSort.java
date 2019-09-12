package recursiveSorting;

import util.Util;

public class QuickSort {
	
	static Util util = new Util();
	
	public static void main(String args[]) {
		
		int vetor[] = {349, 232, 23, 394, 23, 3487, 2387, 4357, 28, 239, 1, 2, 8378, 29};
		
		quickSort(vetor, 0, vetor.length - 1);
		
		util.exibir(vetor);
	}
	
	public static void quickSort(int vetor[], int left, int right) {
		if(left < right) {
			
			int m = part(vetor, left, right);
			
			quickSort(vetor, left, m - 1);
			quickSort(vetor, m + 1, right);
		}
	}
	
	public static int part(int vetor[], int left, int right) {
		
		int pivot = vetor[left]; //primeiro elemento
		
		int i = left;
		
		for(int j = left + 1; j <= right; j++) {
			if(vetor[j] < pivot) {
				util.swap(vetor, j, ++i);
			}
		}
		
		util.swap(vetor, left, i);
		
		return i;
	}
}