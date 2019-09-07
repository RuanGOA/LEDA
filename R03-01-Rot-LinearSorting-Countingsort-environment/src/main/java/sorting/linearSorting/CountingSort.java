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
		if(isValid(array, leftIndex, rightIndex)) {
			
			Integer max = array[leftIndex];
			
			for(int i = leftIndex + 1; i <= rightIndex; i++) {
				if(array[i] > max) max = array[i];
			}
			
			Integer[] arrCont = new Integer[max + 2];
			
			for(int i = 0; i < arrCont.length; i++)
				arrCont[i] = 0;
			
			for(int i = leftIndex ; i <= rightIndex; i++) {
				arrCont[array[i]]++;
			}
			
			for(int i = 1; i < arrCont.length; i++) {
				arrCont[i] += arrCont[i - 1];
			}
			
			Integer[] arrRep = new Integer[array.length];
			for(int i = rightIndex; i >= leftIndex; i--) {
				arrRep[--arrCont[array[i]]] = array[i];
			}
			
			for(int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrRep[i];
			}
		}
	}
	
	private boolean isValid(Integer[] array, int leftIndex, int rightIndex) {
		boolean valid = true;
		
		if(array == null || array.length == 0) {
			valid = false;
		} else if((leftIndex < 0) || (leftIndex >= rightIndex) || (rightIndex <= 0)) {
			valid = false;
		} else if((leftIndex >= array.length) || (rightIndex > array.length - 1)) {
			valid = false;
		}
		
		return valid;
	}
}