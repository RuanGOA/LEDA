package alg;

import util.Util;

public class InsertionSort {
	
	static Util util = new Util();
	
	public static void main(String args[]) {
		
		int vetor[] = {349, 232, 23, 394, 23, 3487, 2387, 4357, 28, 239, 1, 2, 8378, 29};
		
		for(int i = 0; i < vetor.length; i++) {
			int selecionado = vetor[i];
			
			int j = i - 1;
			while(j >= 0 && vetor[j] > selecionado) {
				vetor[j + 1] = vetor[j];
				j--;
			}
			
			vetor[j + 1] = selecionado;
		}
		
		util.exibir(vetor);
	}
}