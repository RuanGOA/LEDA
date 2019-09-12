package main;

import enilogue.MergeSortNormal;
import enilogue.QuickSortNormal;
import enilogue.QuickSortThreeWay;
import enilogue.kike;
import quadrado.BubbleSortNormal;
import quadrado.BubbleSortRecursivo;
import quadrado.InsertionSortRecursivo;
import quadrado.SelectionSortNormal;
import quadrado.SelectionSortRecursivo;

public class main {
	public static void main(String args[]) {
		int[] vetor = new int[] {3, 1, 5, 2, 2, 6, 3, 8, 232, 9, 4, 32, 27, 81, 42, 56, 3, 3};
		
		new NOMEDOALGORITMO(vetor); //INSERIR
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i] + " ");
		}
	}
}
