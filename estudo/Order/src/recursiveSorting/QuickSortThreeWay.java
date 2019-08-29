package recursiveSorting;

import util.Util;

public class QuickSortThreeWay {
	
	static Util util = new Util();
	
	public static void main(String args[]) {
		
		int vetor[] = {349, 232, 23, 394, 23, 3487, 2387, 4357, 28, 239, 1, 2, 8378, 29};
		
		quickSortThree(vetor, 0, vetor.length - 1);
		
		util.exibir(vetor);
	}
	
	public static void quickSortThree(int vetor[], int left, int right) {
		if(left < right) {
			int l = left;
			int i = left;
			int r = right;
			int pivot = vetor[left];
			
			while(i <= r) {
				if(vetor[i] < pivot) {
					util.swap(vetor, l++, i++);
				} else if(vetor[i] > pivot) {
					util.swap(vetor, i, r--);
				} else {
					i++;
				}
			}
			
			quickSortThree(vetor, left, l - 1);
			quickSortThree(vetor, r + 1, right);
		}
	}
}
