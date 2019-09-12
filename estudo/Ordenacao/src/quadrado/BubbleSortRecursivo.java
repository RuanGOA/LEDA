package quadrado;

import util.Util;

public class BubbleSortRecursivo {

	Util util = new Util();

	public BubbleSortRecursivo(int[] vetor) {
		sort(vetor);
	}
	
	public void sort(int[] vet) {
		auxSort(vet, 0);
	}
	
	private void auxSort(int[] vet, int pos) {
		if(pos == vet.length - 1) {
			return;
		}
		
		for(int i = 0; i < vet.length - 1; i++) {
			if(vet[i] > vet[i + 1]) {
				util.swap(vet, i, i + 1);
			}
		}
		
		auxSort(vet, pos + 1);
	}
}
