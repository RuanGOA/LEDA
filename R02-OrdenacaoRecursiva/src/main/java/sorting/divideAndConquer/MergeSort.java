package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		Comparable[] arrAux = new Comparable[array.length];
		mergeSor(array, arrAux, leftIndex, rightIndex);
	}
	
	/*private void mergeSort(T[] v, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex) {
			int mid = (leftIndex + rightIndex)/2;
		
			mergeSort(v, leftIndex, mid);
			mergeSort(v, mid + 1, rightIndex);
			merge(v, leftIndex, mid, rightIndex);
		}
	}
	
	private void merge(T[] v, int left, int mid, int right) {
		for(int i = left; i <= right; i++) this.vS[i] = (Comparable) v[i];
		
		int i = left;
		int j = mid + 1;
		for(int k = left; k <= right; k++) {
			if(i > mid) v[k] = (T) this.vS[j++];
			else if(j > right) v[k] = (T) this.vS[i++];
			else if(this.vS[i].compareTo(this.vS[j]) < 0) v[k] = (T) this.vS[i++];
			else v[k] = (T) this.vS[j++];
		}		
	}*/
	
	public void mergeSor(T[] arr, Comparable[] arrAux, int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;
			
			mergeSor(arr, arrAux, left, mid);
			mergeSor(arr, arrAux, mid + 1, right);
			
			merge(arr, arrAux, left, mid, right);			
		}
	}

	private void merge(T[] arr, Comparable[] arrAux, int left, int mid, int right) {
		for(int i = left; i <= right; i++) arrAux[i] = arr[i];
		
		int i = left;
		int j = mid + 1;
		for(int k = left; k <= right; k++) {
			if(i > mid) arr[k] = (T) arrAux[j++];
			else if(j > right) arr[k] = (T) arrAux[i++];
			else if(arrAux[i].compareTo(arrAux[j]) <= 0) arr[k] = (T) arrAux[i++];
			else arr[k] = (T) arrAux[j++];
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}