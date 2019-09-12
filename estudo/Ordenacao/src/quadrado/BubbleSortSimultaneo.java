package quadrado;

import util.Util;

public class BubbleSortSimultaneo {

	static Util util = new Util();
	
	public BubbleSortSimultaneo(int[] vet) {
		sort(vet, 0, vet.length -1);
	}

	private void sort(int[] vet, int left, int right) {
		int flag = 1;
		int i = left;
		int j = right;
		
		while(flag == 1 && i < j) {
			flag = 0;
			for(int k = i; k < j; k++) {
				if(vet[k] > vet[k + 1]) {
					util.swap(vet, k, k+1);
					flag = 1;
				}
			}
			
			j--;
			
			for(int k = j; k > i; k--) {
				if(vet[k] < vet[k - 1]) {
					util.swap(vet, k, k - 1);
					flag = 1;
				}
			}
			
			i++;
		}	
	}
	
}
