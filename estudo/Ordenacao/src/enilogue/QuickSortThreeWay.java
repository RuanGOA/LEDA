package enilogue;

import util.Util;

public class QuickSortThreeWay {

	static Util util = new Util();
	
	public QuickSortThreeWay(int[] vetor) {
		sort(vetor, 0, vetor.length - 1);
	}
	
	private void sort(int[] vet, int left, int right) {
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
			
			sort(vet, left, l - 1);
			sort(vet, l + 1, right);
		}
										
	}
}