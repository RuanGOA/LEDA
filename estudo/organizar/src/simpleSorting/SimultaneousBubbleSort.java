package simpleSorting;

import util.Util;

public class SimultaneousBubbleSort {

	static Util util = new Util();
	
	public static void main(String args[]) {
		int vetor[] = {349, 232, 23, 394, 23, 3487, 2387, 4357, 28, 239, 1, 2, 8378, 29};
		
		boolean troca = true;
		int l = 0, r = vetor.length - 1;
		while(troca) {
			troca = false;
			
			for(int i = l; i < r - 1; i++) {
				if(vetor[i] > vetor[i + 1]) {
					troca = true;
					util.swap(vetor, i, i+1);
				}
			}
			
			r--;
			
			for(int j = r + 1; j > l; j--) {
				if(vetor[j] < vetor[j - 1]) {
					troca = true;
					util.swap(vetor, j, j-1);
				}
			}
			
			l++;
		}
		
		util.exibir(vetor);
	}
}
