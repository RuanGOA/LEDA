package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(isValid(array, leftIndex, rightIndex)) {
			
			Integer max = array[leftIndex];
			Integer min = array[leftIndex];
			
			for(int i = leftIndex + 1; i <= rightIndex; i++) {
				if(array[i] > max) max = array[i];
				if(array[i] < min) min = array[i];
			}
			
			Integer[] arrCont = new Integer[max + Math.abs(min) + 2];
			
			for(int i = 0; i < arrCont.length; i++)
				arrCont[i] = 0;
			
			for(int i = leftIndex ; i <= rightIndex; i++) {
				arrCont[array[i] + Math.abs(min)]++;
			}
			
			for(int i = 1; i < arrCont.length; i++) {
				arrCont[i] += arrCont[i - 1];
			}
			
			Integer[] arrRep = new Integer[array.length];
			for(int i = rightIndex; i >= leftIndex; i--) {
				arrRep[--arrCont[array[i] + Math.abs(min)]] = array[i];
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
