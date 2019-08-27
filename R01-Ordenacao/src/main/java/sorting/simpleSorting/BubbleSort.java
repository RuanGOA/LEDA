package sorting.simpleSorting;

import util.Util;
import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	Util util = new Util();
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {	
		
		boolean swpd = true;
		while(swpd) {
			swpd = false;
			
			for(int j = leftIndex; j < rightIndex; j++) {
				if(array[j].compareTo(array[j+1]) > 0) {
					util.swap(array, j, j+1);
					swpd = true;
				}
			}
		}
	}
}
