package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(array.length > 0) {
			bubbleSort(array, leftIndex, rightIndex, leftIndex, leftIndex);			
		}
	}
	
	private void bubbleSort(T[] array, int leftIndex, int rightIndex, int i, int j) {
		if(i == rightIndex) return;
		else if(j == rightIndex) bubbleSort(array, leftIndex, rightIndex, i + 1, leftIndex);
		else {
			if(array[j].compareTo(array[j + 1]) > 0) swap(array, j, j + 1);
			bubbleSort(array, leftIndex, rightIndex, i, j + 1);
		}
	}
	
	private void swap(T[] array, int pos1, int pos2) {
		T el = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = el;
	}
}