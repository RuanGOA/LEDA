package quadrado;

import util.Util;

public class BubbleSortNormal {

	static Util util = new Util();
	
	public BubbleSortNormal(int[] vet) {
		sort(vet);
	}
	
	public static void sort(int[] vet) {
		
		
		int swap = 1; int i = 0;
		while(swap == 1 && i < vet.length) {
			
			swap = 0;
			
			for(int j = 0; j < vet.length - 1; j++) {
				if(vet[j] > vet[j + 1]) 
					util.swap(vet, j, j+1);
				swap = 1;
			}
			
			i++;
		}
	}
}
