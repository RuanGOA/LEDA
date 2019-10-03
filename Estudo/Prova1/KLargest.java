package teste;

import java.util.Arrays;

public class KLargest {

	public static void main(String[] args) {
		int[] array = new int[] {};
		
		int k = 0; //O programa pede para que seja retornado um array, com os k maiores.
				   //in-place, sem restricao de tempo.
		
		int[] aux = kLargest(array, k);
		
		try {
			for(int i = 0; i < aux.length; i++)
				System.out.print(aux[i] + " ");
		} catch(NullPointerException e) {
			System.out.println("K maior do que o tamanho do array!");
		};
	}

	private static int[] kLargest(int[] array, int k) {
		int[] resultado;
		if(k > array.length) resultado = null;
		else resultado = kLargestAux(array, k);
		
		return resultado;
	}
	
	private static int[] kLargestAux(int[] array, int k) {
		
		int aux; 
		for(int i = array.length - 1; i > array.length - k - 1; i--) {
			aux = i;
			for(int j = 0; j < i; j++) {
				if(array[j] > array[aux]) aux = j;
			}
			
			swap(array, aux, i);			
		}
		
		return Arrays.copyOfRange(array, array.length - k, array.length);
	}
	
	private static void swap(int[] arr, int pos1, int pos2) {
		int cache = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = cache;
	}	
}