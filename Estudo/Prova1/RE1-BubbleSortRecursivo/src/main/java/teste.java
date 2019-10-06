import sorting.Sorting;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;

public class teste {

	public static void main(String[] args) {
		Integer[] array = new Integer[] {};
		
		Sorting sort = new RecursiveBubbleSort<>();
		sort.sort(array);
		
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i].intValue() + " ");
		System.out.println();
	}
	
}
