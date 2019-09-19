package main;

import sorting.Sorting;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class teste {

	public static void main(String[] args) {
		Integer[] array = new Integer[] {2, 3, 1, 4, 2, 5 ,7 ,2 ,7, 2, 6, 5, 0};
		
		Sorting sort = new RecursiveSelectionSort();
		sort.sort(array);
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i].intValue() + " ");
		
		System.out.println();
	}
}
