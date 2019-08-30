package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		quickSort(array, leftIndex, rightIndex);
		
	}

	private void quickSort(T[] v, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			
			int mid = part(v, leftIndex, rightIndex);
			
			quickSort(v, leftIndex, mid - 1);
			quickSort(v, mid + 1, rightIndex);
			
		}
	}

	private int part(T[] v, int leftIndex, int rightIndex) {
		
		T pivot = v[leftIndex];
		int i = leftIndex;
		int j = rightIndex;
		while(i <= j) {
			if(v[i].compareTo(pivot) <= 0) i++;
			else if(v[j].compareTo(pivot) > 0) j--;
			else if(i <= j) {
				Util.swap(v, i++, j--);
			}
		}
		
		Util.swap(v, leftIndex, j);
		
		return j;
	}

}
