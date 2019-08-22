package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		result = somaElementos(array, 0);
		return result;
	}
	
	private int somaElementos(int[] array, int pos) {
		if(pos == array.length - 1) return array[pos];
		else return array[pos] + somaElementos(array, pos + 1);
	}
////////////////////////////////////////////////////////////////////////////////////
	
	public long calcularFatorial(int n) {
		long result = 1;
		
		if(n == 0) return 1;
		result *= calcularFatorial(n-1);
		
		return result;
	}
////////////////////////////////////////////////////////////////////////////////////
	
	public int calcularFibonacci(int n) {
		int result = 1;
		
		if(n == 0 || n == 1) return 1;
		else result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		
		return result;
	}
/////////////////////////////////////////////////////////////////////////////////////
	public int countNotNull(Object[] array) {
		int result = 0;
		
		result = contDifZero(array,0);
		
		return result;
	}
	
	public int contDifZero(Object[] array, int n) {
		int res = 0;
		if(n == array.length - 1) {
			if(array[n] != null) res++;
		} else {
			if(array[n] != null) res += (1 + contDifZero(array, n+1));
			else res += contDifZero(array, n+1);
		}
		return res;
	}
	
//////////////////////////////////////////////////////////////////////////////////////
	public long potenciaDe2(int expoente) {
		int result = 1;
		
		if(expoente != 0) result *= (2 * potenciaDe2(expoente - 1)); 
		
		return result;
	}
///////////////////////////////////////////////////////////////////////////////////////
	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		
		if(n == 0) {
			result = razao;
		} else {
			result = razao + progressaoAritmetica(termoInicial, razao, n-1);
		}
		
		return result;
	}
///////////////////////////////////////////////////////////////////////////////////////
	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		
		if(n == 1) {
			result = termoInicial * razao;
		} else {
			result = progressaoGeometrica(termoInicial*razao, razao, n-1);
		}
		return result;
	}
}
