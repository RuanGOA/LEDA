package quadrado;

import util.Util;

public class InsertionSortNormal {

	Util util = new Util();
	
	public InsertionSortNormal(int[] vetor) {
		sort(vetor);
	}

	private void sort(int[] vetor) {
		for(int i = 0; i < vetor.length; i++) {
			int j = i - 1;
			int cache = vetor[i];
			while(j >= 0 && vetor[j] > cache) {
				vetor[j+1] = vetor[j];
				j--;
			}
			
			vetor[j+1] = cache;
		}
	}
}
