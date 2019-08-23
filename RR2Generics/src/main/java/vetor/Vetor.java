package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor <T extends Comparable<T>>{

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable[tamanho];
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}
	
	public void inserir(T o) {
		this.arrayInterno[indice++] = o;
	}

	// Remove um objeto do vetor
	public T remover(Object o) {
		T gen = null;
		boolean flag = false;
		int i = 0;
		while (i <= indice && !flag) {
			if (arrayInterno[i].equals(o)) {
				gen = this.arrayInterno[i];
				arrayInterno[i] = arrayInterno[indice];
				arrayInterno[indice] = null;
				indice--;
				flag = true;
			}
			i++;
		}
		
		return gen;
	}

	// Procura um elemento no vetor
	public T procurar(Object o) {
		T gen = null;
		boolean flag = false;
		int i = 0;
		while (i <= indice && !flag) {
			if (arrayInterno[i].equals(o)) {
				gen = arrayInterno[i];
				flag = true;
			}
			i++;
		}
		return gen;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.indice == -1;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.indice >= tamanho;
	}

	public T maximo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMaximo.compare(result, arrayInterno[i]) < 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}

	public T minimo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparadorMinimo.compare(result, arrayInterno[i]) < 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}

}

	class ComparadorMaximo implements Comparator<Aluno> {

		@Override
		public int compare(Aluno o1, Aluno o2) {
			return (int) (o1.getMedia() - o2.getMedia());
		}

	}

	class ComparadorMinimo implements Comparator<Aluno> {

		@Override
		public int compare(Aluno o1, Aluno o2) {
			return (int) (o2.getMedia() - o1.getMedia());
		}
}
