package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
		
   @Override
   public void sort(T[] array, int leftIndex, int rightIndex) {
      mergeSort(array, new Comparable[array.lenght], leftIndex, rightIndex);
   }
    
   private void mergeSort(T[] v, Comparable[] vs, int leftIndex, int rightIndex) { //vs -> vetor secundario
      if(leftIndex < rightIndex) { //enquanto o indice da esquerda for menor que o da direita, faca(assim garantimos que l vai se igualar a r)
         int mid = (leftIndex + rightIndex)/2; //calcular o mid 

            mergeSort(v, vs, leftIndex, mid); //chamada recursiva do lado esquerdo
            mergeSort(v, vs, mid + 1, rightIndex);//chamada recursiva do lado direito
            merge(v, vs, leftIndex, mid, rightIndex); // aqui o merge junta os 2 vetores separados
      }
   }
    
   private void merge(T[] v, Comparable[] vs, int left, int mid, int right) {
      for(int i = left; i <= right; i++) vs[i] = (Comparable) v[i]; //copiar os objetos do array principal pro secundario
    
         int i = left; //iterador do array esquerdo
         int j = mid + 1; // iterador do array direito
         for(int k = left; k <= right; k++) { //esse for vai passar em todas as posicoes solicitadas no metodo (left ate right(inclusive))
            if(i > mid) v[k] = (T) vs[j++]; //se o indice da esquerda ja estourou(passou do mid), so adicionamos os indices da direita
            else if(j > right) v[k] = (T) vs[i++]; //se o indice da direita ja estourou, so adicionamos os indices da esquerda
            else if(vs[i].compareTo(vs[j]) < 0) v[k] = (T) vs[i++]; //se nenhum estourou, e o valor do vetor esquerdo for menor que o do direito, botamos na posicao k o valor esquerdo
            else v[k] = (T) vs[j++]; //se nao, o valor direito vai.
         }    
   }	
}
