package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.length > 0) {
			selectionSort(array, leftIndex, rightIndex, leftIndex, leftIndex, leftIndex);			
		}
	}

	private void selectionSort(T[] array, int leftIndex, int rightIndex, int i, int j, int min) {
		if(i > rightIndex) return;
		else if(j > rightIndex) {
			swap(array, i, min);
			selectionSort(array, leftIndex, rightIndex, i + 1, i + 1, i + 1);
		} else {
			if(array[j].compareTo(array[min]) < 0) min = j;
			selectionSort(array, leftIndex, rightIndex, i, j + 1, min);
		}
	}

	private void swap(T[] array, int i, int min) {
		T el = array[i];
		array[i] = array[min];
		array[min] = el;
	}

}
