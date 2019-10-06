package problems;
/**
 * Dado dois arrays ordenados em ordem crescente, encontrar a k-esima estatistica de ordem 
 * da uniao ordenada deles. 
 * 
 * Restricoes:
 * - os arrays nao possuem elementos em comum e nem repetidos
 * - k eh um numero compreendido entre 1 e array1.length + array2.length
 * - caso o k-esima estatistica de ordem nao exista, o metodo deve retornar null
 * - voce nao pode usar memoria extra
 * - seu algoritmo deve ter complexidade O(array1.length + array2.length). 
 * - voce nao pode usar nenhum metodo pronto de manipulacao de arrays, exceto length.
 * 
 * @author adalbertocajueiro
 *
 */
public class OrderStatisticsSortedUnion<T extends Comparable<T>> {
	
	public T statisticsOrder(T[] array1, T[] array2, int k) {
		
		T resultado;
		//contando com os dois arrays estarem ordenados, k >= 1, e k <= len(arr1) + len(arr2)
		if(k > array1.length + array2.length || k < 1) resultado = null;
		else {
			int ap1 = 0; //apontador array 1
			int ap2 = 0; //apontador array 2
			
			T cache = null; //cache para estatistica de ordem
			for(int i = 0; i < k; i++) { 
				if(ap1 > array1.length - 1) //se o ap1 ja tiver passado do array, a estatistica de ordem so pode estar no array 2
					cache = array2[ap2++];
				else if(ap2 > array2.length - 1) //se o ap2 ja tiver passado do array, " " " " " " " " " 1
					cache = array1[ap1++];
				else if(array1[ap1].compareTo(array2[ap2]) <= 0) //se nao, compare os 2 elementos, com os apontadores atuais, se o ap1, for menor..
					cache = array1[ap1++];
				else //se nao.. 
					cache = array2[ap2++];
			}
			
			resultado = cache;	//att de resultado					
		}
		
		return resultado;
	}
}
