package quadrado;

import util.Util;

public class SelectionSortNormal {

	Util util = new Util();
	
	public SelectionSortNormal(int[] vetor) {
		sort(vetor);
	}
	
	public void sort(int[] vet) {
		
		for(int i = 0; i < vet.length; i++) {
			int pos = i;
			
			for(int j = i + 1; j < vet.length; j++) {
				if(vet[j] < vet[pos]) pos = j;
			}
			
			util.swap(vet, pos, i);
		}
	
	}
	
	
}
