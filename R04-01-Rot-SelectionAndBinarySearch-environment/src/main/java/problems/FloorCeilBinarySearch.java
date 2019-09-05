package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */
public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int l = 0;
		int r = array.length - 1;
		while(l <= r) {
			int mid = (l + r)/2;
			if(array[mid] >= x) r = mid - 1;
			else if(array[mid] < x) l = mid - 1;
		}
		
		if(array[l] == x) {
			return null;
		} else return array[l];
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		int l = 0;
		int r = array.length - 1;
		while(l <= r) {
			int mid = (l + r)/2;
			if(array[mid] > x) r = mid - 1;
			else if(array[mid] <= x) l = mid + 1;
		}
		
		if(array[l] == x) {
			return null;
		} else return array[l];
	}

	public static void main(String args[]) {
		
		FloorCeilBinarySearch bs = new FloorCeilBinarySearch();
		Integer[] array = new Integer[] {1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9, 10};
		
		System.out.println(bs.ceil(array, 7));
		System.out.println(bs.floor(array, 7));
	}
}
