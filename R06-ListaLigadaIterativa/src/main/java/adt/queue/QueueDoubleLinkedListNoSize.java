package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class QueueDoubleLinkedListNoSize<T> implements Queue<T> {
	
	private DoubleLinkedList<T> list;
	private int elements;
	
	public QueueDoubleLinkedListNoSize() {
		this.elements = 0;
		this.list = new DoubleLinkedListImpl<T>();
	}
	
	@Override
	public void enqueue(T element){
		this.list.insert(element);
		this.elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resultado = null;
		
		if(!this.list.isEmpty()) {
			resultado = ((SingleLinkedListImpl<T>) this.list).getHead().getData();
			this.list.removeFirst();
			this.elements--;
		} else throw new QueueUnderflowException();
		
		return resultado;
	}

	@Override
	public T head() {
		T resultado = null;
		if(!this.list.isEmpty()) {
			resultado = ((SingleLinkedListImpl<T>) this.list).getHead().getData();
		}
		
		return resultado;
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
	public int size() {
		return this.elements;
	}
}
