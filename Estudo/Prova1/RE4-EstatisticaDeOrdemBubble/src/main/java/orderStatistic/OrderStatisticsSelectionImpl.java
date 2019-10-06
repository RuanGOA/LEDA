package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		T resultado = null;
		if(k <= array.length) {
			T min = array[0];
			T max = array[0];
			for(int i = 0; i < array.length; i++) {
				if(array[i].compareTo(max) > 0) max = array[i];
				if(array[i].compareTo(min) < 0) min = array[i];
			}
			
			resultado = min;
			for(int i = 1; i < k; i++) {
				min = max;
				for(int j = 0; j < array.length; j++) {
					if(array[j].compareTo(min) < 0 && array[j].compareTo(resultado) > 0) {
						min = array[j];
					}		
				}
				resultado = min;
			}	
		}
		
		return resultado;
	}
}
