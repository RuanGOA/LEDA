package adt.linkedList;

import java.util.ArrayList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
		
	}

	@Override
	public int size() {
		int result = 0;
		if(this.data == null) {
			result = 0;
		} else {
			result += (1 + this.next.size());
		}
		
		return result;
	}

	@Override
	public T search(T element) {
		T result;
		if(this.data == null) {
			result = null;
		} else if(this.data.equals(element)) {
			result = this.data;
		} else result = this.next.search(element);
		
		return result;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			if(this.data == null) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<>();
			} else this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(this.data == null);
		else if(this.data.equals(element)) {
			this.data = this.next.data;
			this.next = this.next.next;
		} else this.next.remove(element);
	}

	@Override
	public T[] toArray() {
		ArrayList<T> array = new ArrayList<T>();
		toArrayAux(array);
		
		return (T[]) array.toArray();
	}
	
	private void toArrayAux(ArrayList array) {
		if(!isEmpty()) {
			array.add(this.data);
			this.next.toArrayAux(array);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
