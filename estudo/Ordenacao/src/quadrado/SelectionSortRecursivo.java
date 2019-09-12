package quadrado;

import util.Util;

public class SelectionSortRecursivo {

	Util util = new Util();
	
	public SelectionSortRecursivo(int[] vetor) {
		sort(vetor);
	}

	private void sort(int[] vetor) {
		auxSort(vetor, 0);
	}

	private void auxSort(int[] vetor, int pos) {
		if(pos == vetor.length - 1);
		else {
			
			int cache = pos;
			for(int i = pos + 1; i < vetor.length; i++) {
				if(vetor[i] < vetor[cache]) cache = i;
			}
			
			util.swap(vetor, cache, pos);
			
			auxSort(vetor, pos + 1);
		}
	}	
}