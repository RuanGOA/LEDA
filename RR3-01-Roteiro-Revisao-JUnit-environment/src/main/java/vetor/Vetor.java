package vetor;

import java.util.Comparator;

import vetor.Aluno;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	private T[] arrayInterno;

	private int tamanho;

	private int indice;

	private Comparator<T> comparador;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
		this.arrayInterno = (T[]) new Comparable[tamanho];
		this.comparador = (Comparator<T>) new Comparador();
	}

	/*public void setComparadorMaximo(Comparator<T> comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator<T> comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}*/

	public void inserir(T o) {
		this.arrayInterno[++indice] = o;
	}

	public T remover(T o) {
		T result = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou) {
			if (arrayInterno[i].equals(o)) {
				result = arrayInterno[i];
				arrayInterno[i] = arrayInterno[indice];
				arrayInterno[indice] = null;
				indice--;
				achou = true;
			}
			i++;
		}
		return result;
	}

	public T procurar(T o) {
		T result = null;
		boolean achou = false;
		int i = 0;
		while (i <= indice && !achou) {
			if (arrayInterno[i].equals(o)) {
				result = arrayInterno[i];
				achou = true;
			}
			i++;
		}
		return result;
	}

	public boolean isVazio() {
		return this.indice == -1;
	}

	public boolean isCheio() {
		return this.indice == this.tamanho - 1;
	}

	public T maximo() {
		T result = null;
		if (!isVazio()) {
			result = arrayInterno[0];
			for (int i = 0; i <= indice; i++) {
				if (comparador.compare(result, arrayInterno[i]) < 0) {
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
				if (comparador.compare(result, arrayInterno[i]) > 0) {
					result = arrayInterno[i];
				}
			}
		}
		return result;
	}

}

class Comparador implements Comparator<Aluno> {
	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o1.getMedia() - o2.getMedia());
	}
}