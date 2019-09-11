public class Contagem {

	public static void main(String[] args) {
		int[] vetor = new int[] {-1, -1, 1, 4, 5, 6, 7, 7, 7, 8, 8, 9, 10, 10};
		
		int cont = cont(vetor, 7);

		
		System.out.println(cont);
		
	}
	
	public static int cont(int[] vetor, int x) {
		int resultado = 0;
		
		if(vetor.length > 0) {
			if(x < vetor[0] || x > vetor[vetor.length - 1]) resultado = 0;
			else {
				int low = lowerBound(vetor, x);
				int upp = upperBound(vetor, x);
				resultado = upp - low + 1;
			}
		}
		
		return resultado;		
	}
	
	private static int upperBound(int[] vet, int x) {
		int resultado = 0;
		
		if(vet.length > 0) {
			if(vet[vet.length - 1] == x) resultado = vet.length - 1;
			else resultado = upperBoundAux(vet, x, 0, vet.length - 2);
		}
		
		return resultado;
	}
	
	private static int upperBoundAux(int[] vet, int x, int l, int r) {
		int i = l, j = r, mid, biger = 0;
		
		while(i <= j) {
			mid = (i + j)/2;
			
			if(vet[mid] == x) {
				biger = mid;
				i = mid + 1;
			} else if(vet[mid] > x) j = mid - 1;
			  else i = mid + 1;
		}
		
		return biger;
	}
	
	private static int lowerBound(int[] vet, int x) {
		int resultado = 0;
		
		if(vet.length > 0) {
			if(vet[0] == x) resultado = 0;
			else resultado = lowerBoundAux(vet, x, 1, vet.length - 1);
		}
		
		return resultado;
	}

	private static int lowerBoundAux(int[] vet, int x, int l, int r) {
		int i = l, j = r, mid, lower = 1;
		
		while(i <= j) {
			mid = (i + j)/2;
			
			if(vet[mid] == x) {
				j = mid - 1;
				lower = mid;
			} else if(vet[mid] < x) i = mid + 1;
			  else j = mid - 1;		
		}
		
		return lower;
	}
}
