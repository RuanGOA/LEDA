package util;

public class Util {

	public static void swap(int[] vet, int pos1, int pos2) {
		int cache = vet[pos1];
		vet[pos1] = vet[pos2];
		vet[pos2] = cache;
	}
}