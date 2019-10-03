package util;

public class ContagemLog {
	public static int cont(int[] vetor, int x) {
		int resultado = 0;
		if(vetor.length > 0) {
			if(x < vetor[0] || x > vetor[vetor.length - 1]) resultado = 0;
			else {
				System.out.println(upperBound(vetor, x));
				System.out.println(lowerBound(vetor, x));
				
				resultado = 1;
				resultado += upperBound(vetor, x);
				resultado -= lowerBound(vetor, x);
			}
		}
		
		return resultado;
	}
	
	private static int lowerBound(int[] vetor, int x) {
		int i = 0, j = vetor.length - 1, lower = -1, mid;
		while(i <= j) {
			mid = (i + j)/2;
			if(vetor[mid] == x) {
				lower = mid;
				j = mid - 1;
			} else if(vetor[mid] > x) j = mid - 1;
			else i = mid + 1;
		}
		
		return lower;
	}
	
	private static int upperBound(int[] vetor, int x) {
		int i = 0, j = vetor.length - 1, upper = -1, mid;
		while(i <= j) {
			mid = (i + j)/2;
			if(vetor[mid] == x) {
				upper = mid;
				i = mid + 1;
			} else if(vetor[mid] < x) i = mid + 1;
			else j = mid - 1;
		}
		
		return upper;
	}
}
