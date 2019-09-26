package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.data = element;
			this.next = new RecursiveDoubleLinkedListImpl<>();
			this.previous = new RecursiveDoubleLinkedListImpl<>();
		} else this.next.insert(element);
	}
	
	@Override
	public void insertFirst(T element) {
		if(isEmpty()) {
			insert(element);
			this.previous = new RecursiveDoubleLinkedListImpl<>();
		} else {
			this.previous.data = element;
			this.previous.previous = new RecursiveDoubleLinkedListImpl<>();
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()) {
			this.data = this.next.data;
			this.next = this.next.next;
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()) {
			
		}
		
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
