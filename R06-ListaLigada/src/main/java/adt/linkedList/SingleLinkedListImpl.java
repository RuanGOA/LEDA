package adt.linkedList;

import java.util.ArrayList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int cont = 0;
		if(!isEmpty()) {
			SingleLinkedListNode node = this.head;
			while(!node.isNIL()) {
				cont++;
				node = node.next;
			}
		}
		return cont;
	}

	@Override
	public T search(T element) {
		T resultado = null;
		if(!isEmpty()) {
			SingleLinkedListNode node = this.head;
			while(!node.isNIL()) {
				if(node.data.equals(element)) {
					resultado = (T) node.data;
					break;
				} else node = node.next;
			}
		}
		
		return resultado;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.head.setData(element);
			this.head.setNext(new SingleLinkedListNode<T>());
		} else {
			SingleLinkedListNode node = this.head;
			while(!node.isNIL()) {
				node = node.next;
			}
			node.setData(element);
			node.setNext(new SingleLinkedListNode<T>());
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			if(this.head.data.equals(element)) {
				this.head = this.head.next;
			} else {
				SingleLinkedListNode node = this.head;
				while(!node.next.isNIL()) {
					if(node.next.data.equals(element)) {
						node.setNext(node.next.next);
						node.setData(node.next.data);
					} else node = node.next;
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		ArrayList<T> array = new ArrayList<T>();
		if(!isEmpty()) {
			SingleLinkedListNode node = this.head;
			while(!node.isNIL()) {
				array.add((T) node.data);
				node = node.next;
			}
		}
		
		return (T[]) array.toArray();
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
