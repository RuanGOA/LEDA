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
		Integer result = null;
		
		if(array.length > 0) {
			if(x > array[array.length - 1]) {
				result = array[array.length - 1];
			} else result = auxFloor(x, array, 0, array.length - 1); 	
		}
		
		return result;
	}
	
	private Integer auxFloor(Integer x, Integer[] vet, int l, int r) {
		Integer result = null;
		if(l <= r) {
			int mid = (l + r)/2;
			if(x.equals(vet[mid])) {
				result = x;
			} else if(x < vet[mid]) {
				if(mid - 1 >= 0 && vet[mid - 1] < x) {
					result = vet[mid - 1];
				} else result = auxFloor(x, vet, l, mid - 1);
			} else {
				result = auxFloor(x, vet, mid + 1, r);
			}
		}
			
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		Integer result = null;
		if(array.length > 0) {
			if(x < array[0]) {
				result = array[0];
			} else if(x > array[array.length - 1]) {
			} else result = auxCeil(x, array, 0, array.length - 1);
		}
		
		return result;
	}
	
	private Integer auxCeil(Integer x, Integer[] vet, int l, int r) {
		Integer result = null;
		if(l <= r) {
			int mid = (l + r)/2;
			if(x.equals(vet[mid])) {
				result = x;
			} else if(x > vet[mid]) {
				if(mid + 1 <= vet.length - 1 && vet[mid + 1] > x) result = vet[mid + 1];
				else result = auxCeil(x, vet, mid + 1 , r);
			} else {
				result = auxCeil(x, vet, l, mid - 1);				
			}
		}
		
		return result;
	}
}