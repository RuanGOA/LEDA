package enilogue;

import util.Util;

public class QuickSortThreeWay {

	static Util util = new Util();
	
	public QuickSortThreeWay(int[] vetor) {
		quickSortThree(vetor, 0, vetor.length - 1);
	}
	
	private void quickSortThree(int[] vet, int left, int right) {
		if(left < right) {
			int l = left;
			int i = left + 1;
			int r = right;
			int pivot = vet[l];
			
			while(i <= r) {
				
				if(vet[i] < pivot) util.swap(vet, i++, l++);
				else if(vet[i] > pivot) util.swap(vet, i, r--);
				else i++;
			}
			
			quickSortThree(vet, left, l - 1);
			quickSortThree(vet, l + 1, right);
		}
										
	}
}