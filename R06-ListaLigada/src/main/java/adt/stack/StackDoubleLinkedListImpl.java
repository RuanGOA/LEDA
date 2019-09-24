package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(this.top.size() < this.size) {
			this.top.insert(element);
		} else throw new StackOverflowException();
	}

	@Override
	public T pop() throws StackUnderflowException {
		T resultado;
		if(this.top.size() > 0) {
			resultado = ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
			this.top.remove(resultado);
		} else throw new StackUnderflowException();
		
		return resultado;
	}

	@Override
	public T top() {
		T resultado = null;
		if(this.top.size() > 0) {
			resultado = ((DoubleLinkedListImpl<T>) this.top).getLast().getData();
		} 
		
		return resultado;
	}

	@Override
	public boolean isEmpty() {
		return this.top.size() == 0;
	}

	@Override
	public boolean isFull() {
		return this.top.size() == this.size;
	}

}
