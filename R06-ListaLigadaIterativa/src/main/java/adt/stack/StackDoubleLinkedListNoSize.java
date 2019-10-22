package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.LinkedList;

public class StackDoubleLinkedListNoSize<T> implements Stack<T> {

	private DoubleLinkedList<T> list;
	private int elements;
	
	public StackDoubleLinkedListNoSize() {
		this.list = new DoubleLinkedListImpl<T>();
		this.elements = 0;
	}
	
	@Override
	public void push(T element) {
		this.list.insert(element);
		this.elements++;
	}

	@Override
	public T pop() throws StackUnderflowException {
		T result = null;
		if(this.size() > 0) {
			result = ((DoubleLinkedListImpl<T>) this.list).getLast().getData();
			this.list.removeLast();
			this.elements--;
		} else throw new StackUnderflowException();
		
		return result;
	}

	@Override
	public T top() {
		T result = null;
		if(this.size() > 0) {
			result = ((DoubleLinkedListImpl<T>) this.list).getLast().getData();
		}
		
		return result;
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return false;
	}
	
	public int size() {
		return this.elements;
	}
}