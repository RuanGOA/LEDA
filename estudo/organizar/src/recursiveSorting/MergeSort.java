package recursiveSorting;

import util.Util;

public class MergeSort {
	
	static Util util = new Util();
	
	public static void mergeSort(int[] vetor, int[] vetorSec, int ini, int end) {
		if(ini < end) {
			int mid = (ini + end)/2;
			mergeSort(vetor, vetorSec, ini, mid);
			mergeSort(vetor, vetorSec, mid+1, end);
			merge(vetor, vetorSec, ini, mid, end);
		}		
	}
	
	private static void merge(int[] vetor, int[] vetorSec, int ini, int mid, int end) {
		for(int k = ini; k <= end; k++) vetorSec[k] = vetor[k];
		
		int i = ini;
		int j = mid + 1;
		
		for(int k = ini; k <= end; k++) {
			if(i > mid) vetor[k] = vetorSec[j++];
			else if(j > end) vetor[k] = vetorSec[i++];
			else if(vetorSec[i] < vetorSec[j]) vetor[k] = vetorSec[i++];
			else vetor[k] = vetorSec[j++];
		}
	}
	
	public static void main(String args[]) {
		int vetor[] = {39, 32, 23, 64, 23, 37, 28, 47, 28, 93, 1, 83, 2, 29};
		
		int vetorSec[] = new int[vetor.length];
		
		mergeSort(vetor, vetorSec, 0, vetor.length - 1);
		
		util.exibir(vetor);
	}
}
