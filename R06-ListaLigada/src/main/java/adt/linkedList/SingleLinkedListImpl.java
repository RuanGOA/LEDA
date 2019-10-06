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
		int size = 0;
		if(!isEmpty()) {
			SingleLinkedListNode<T> node = this.head;
			
			while(!node.isNIL()) {
				size++;
				node = node.next;
			}	
		}
		
		return size;
	}

	@Override
	public T search(T element) {
		T result = null;
		if(!isEmpty() && element != null) {
			SingleLinkedListNode<T> node = this.head;
			
			boolean found = false;
			while(!node.isNIL() && !found) {
				if(node.data.equals(element)) {
					result = node.data;
					found = true;
				} else node = node.next;
			}
		}
		
		return result;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.head.data = element;
			this.head.next = new SingleLinkedListNode<>();
		} else {
			SingleLinkedListNode<T> node = this.head;
			while(!node.isNIL()) {
				node = node.next;
			}
			node.next = new SingleLinkedListNode<>();
			node.data = element;
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty() && element != null) {
			SingleLinkedListNode<T> node = this.head;
			
			boolean found = false;
			while(!node.isNIL() && !found) {
				if(node.data.equals(element)) {
					node.next = node.next.next;
					node.data = node.next.data;
					found = true;
				} else node = node.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		ArrayList<T> array = new ArrayList<T>();
		
		if(!isEmpty()) {
			SingleLinkedListNode<T> node = this.head;
			
			while(!node.isNIL()) {
				array.add(node.data);
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
