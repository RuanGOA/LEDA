package simpleSorting;

import util.Util;

public class SelectionSort {
	
	static Util util = new Util();
	
	public static void main(String args[]) {		
		int vetor[] = {349, 232, 23, 394, 23, 3487, 2387, 4357, 28, 239, 1, 2, 8378, 29};
		
		for(int i = 0; i < vetor.length; i++) {
			int min = i;
			
			for(int j = min + 1; j < vetor.length; j++) {
				if(vetor[j] < vetor[min]) min = j;
			}
			
			util.swap(vetor, i, min);
		}
		
		util.exibir(vetor);
	}
	
}
