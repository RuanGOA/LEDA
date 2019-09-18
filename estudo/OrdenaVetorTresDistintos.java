package teste;

public class OrdenaVetorTresDistintos {
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1, 2, 3, 3, 1, 2, 3, 1, 1, 2, 3, 1, 3, 1, 1, 2, 3, 1, 2, 3, 2, 3, 1 , 2, 3, 3};
		
		sort(arr);
		
		for(int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
		
	}
	
	private static void sort(int[] arr) {
		
		int min = 100000; int max = -1;
		for(int i = 0; i < arr.length; i++) { 
			if(arr[i] > max) max = arr[i];
			if(arr[i] < min) min = arr[i];
		}
		
		
		int i = 0; int m = 1; int j = arr.length - 1; 
		while(m < j) { 
			if(arr[i] == min) { //para evitar o i = m, se o i for igual a min, ou i > m, sempre que o i == m -> m = i + 1
				i++;
				if(i == m) m++;
			} else if(arr[j] == max) j--; //se o j for igual a max, regrida um
			else if(arr[i] == max || arr[j] == min) swap(arr, i, j); //se o i ou j for igual a max ou min respectivamente, troque
			else if(arr[m] == min) swap(arr, i, m); //se o m for min, troque com i
			else if(arr[m] == max) swap(arr, j, m); //se o m for max, troque com j
			else m++; //se n for nem min, nem j, eh o valor intermediario, entao aumente 1
		}
	}
	
	private static void swap(int[] arr, int pos1, int pos2) {
		int cache = arr[pos1];
		arr[pos1] = arr[pos2];
		arr[pos2] = cache;
	}
}