package util;

public class Util {
	
	
	public Util() {};
	
	public void swap(int v[], int p1, int p2) {
		int cache = v[p1];
		v[p1] = v[p2];
		v[p2] = cache;
	}	
	
	public void exibir(int v[]) {
		for(int i = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
	}
}
