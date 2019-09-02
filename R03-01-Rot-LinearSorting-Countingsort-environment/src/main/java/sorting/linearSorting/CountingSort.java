package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex > -1 && rightIndex < array.length && leftIndex < rightIndex) {
			
			int max = array[leftIndex];
			
			for(int i = leftIndex + 1; i <= rightIndex; i++) {
				if(array[i] > max) max = array[i];
			}
			
			int[] arrAux = new int[max + 1];
			
			for(int i = leftIndex ; i <= rightIndex; i++) {
				arrAux[array[i]]++;
			}
			
			for(int i = leftIndex + 1; i < max; i++) {
				arrAux[i] += arrAux[i - 1];
			}
			
			int[] arrRep = new int[array.length];
			for(int i = array.length - 1; i > -1; i--) {
				arrRep[arrAux[array[i]]--] = array[i];
			}
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrRep[i];
			}
		}
	}
}