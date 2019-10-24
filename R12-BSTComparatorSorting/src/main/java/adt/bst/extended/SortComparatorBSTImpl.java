package adt.bst.extended;

import java.util.Comparator;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	@Override
	public void insert(T element) {
		if(element != null) {
			insertNode(super.root, element);	
		}
	}
	
	private void insertNode(BTNode<T> node, T element) {
		if(node.getData() == null) {
			
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().data(null).right(null).left(null).parent(node).build());
			node.setRight(new BSTNode.Builder<T>().data(null).right(null).left(null).parent(node).build());
			
		} else if(this.comparator.compare(node.getData(), element) > 0) {
			
			insertNode(node.getLeft(), element);
			
		} else {
			
			insertNode(node.getRight(), element);
		}
	}
	
	@Override
	public T[] sort(T[] array) {
		super.root = new BSTNode();
		
		for(T element : array) {
			insert(element);
		}
			
		return order();
	}

	@Override
	public T[] reverseOrder() {
		T[] array = (T[]) new Comparable[this.size()];
		
		reverseOrderAux(this.root, 0, array);
		
		return array;
	}
	
	private int reverseOrderAux(BTNode<T> node, int i, T[] array) {
		
		if(!node.isEmpty()) {
			
			i = reverseOrderAux(node.getRight(), i, array);
			array[i++] = node.getData();
			i = reverseOrderAux(node.getLeft(), i, array);
		
		}
		
		return i;
	}
	
	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> result = new BSTNode<T>();
		
		if(element != null) {
			result = searchNode(this.root, element);		
		}
		
		return result;
	}
	
	private BSTNode<T> searchNode(BSTNode<T> node, T element) {

	      BSTNode<T> aux = new BSTNode<>();

	      if (!node.isEmpty()) {
	         if (node.getData().equals(element))
	            aux = node;

	         else if (comparator.compare(node.getData(), element) > 0)
	            aux = searchNode((BSTNode<T>) node.getLeft(), element);

	         else
	            aux = searchNode((BSTNode<T>) node.getRight(), element);
	      }

	      return aux;
	}
	
	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}

