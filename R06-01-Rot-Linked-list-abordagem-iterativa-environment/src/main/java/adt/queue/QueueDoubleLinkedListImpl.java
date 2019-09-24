package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.SingleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.list.size() < this.size) {
			this.list.insert(element);
		} else throw new QueueOverflowException();
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T resultado = null;
		if(this.list.size() > 0) {
			resultado = ((SingleLinkedListImpl<T>) this.list).getHead().getData();
			this.list.remove(resultado);
		} else throw new QueueUnderflowException();
		
		return resultado;
	}

	@Override
	public T head() {
		T resultado = null;
		if(this.list.size() > 0) {
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
		return this.list.size() == this.size;
	}
}
