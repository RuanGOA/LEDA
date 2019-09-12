package simpleSorting;

import util.Util;

public class BubbleSort {
	
	static Util util = new Util();
	
	public static void main(String args[]) {
		
		int vetor[] = {349, 232, 23, 394, 23, 3487, 2387, 4357, 28, 239, 1, 2, 8378, 29};
		
		boolean troca = true;
		int i = 0;
		while(troca) {
			troca = false;
			
			for(int j = i; j < vetor.length-1; j++) {
				if(vetor[j] > vetor[j + 1]) {
					troca = true;
					util.swap(vetor, j, j+1);
				}
			}
		}
		
		util.exibir(vetor);
	}	
}