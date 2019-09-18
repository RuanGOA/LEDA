package teste;

public class OrdenaVetorTresDistintos {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {3, 1, 2, 1, 3, 1, 2, 2, 1, 3, 2};
		
		sort(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		
	}
	
	private static void sort(int[] arr) {
		
		int min = 100000; int max = -1;
		for(int i = 0; i < arr.length; i++) { //acha min e maximo
			if(arr[i] > max) max = arr[i];
			if(arr[i] < min) min = arr[i];
		}
		
		int i = 0; int m = 1; int j = arr.length - 1; //i inicio, m pivot, j final
		while(m < j && i < j) { // quando o ponteiro m alcancar o j, ou o i alcancar o j, o array estara ordenado
			if(arr[i] == min) i++; //se o i ja for o min, avance
			if(arr[j] == max) j--; //se o j ja for o max, regrida
			
			if(arr[m] == min) swap(arr, i++, m); //se o pivot for igual ao min, troque com o i, e o avance
			else if(arr[m] == max) swap(arr, j--, m); //se o pivot for igual ao max, troque com o j, e o regrida
			else m++; //se nem for o min, nem o max, avance o pivot
		}
	}
	
	private static void swap(int[] arr, int pos1, int pos2) {
		int cache = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = cache;
	}
}