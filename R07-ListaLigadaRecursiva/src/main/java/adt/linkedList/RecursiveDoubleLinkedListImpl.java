package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (!this.isEmpty()) {
				this.getNext().insert(element);
			} else {
				this.setData(element);
				this.setNext(new RecursiveDoubleLinkedListImpl<>());
				((RecursiveDoubleLinkedListImpl<T>) this.getNext()).setPrevious(this);
			}
		}
	}
	
	@Override
	public void insertFirst(T element) {
		if(element != null) {
			if(isEmpty()) {
				insert(element);
				this.previous = new RecursiveDoubleLinkedListImpl<>();
			} else {
				RecursiveDoubleLinkedListImpl node = new RecursiveDoubleLinkedListImpl<>();
				node.data = this.data;
				node.next = this.next;
				node.previous = this;
				
				this.data = element;
				this.next = node;
				this.previous = new RecursiveDoubleLinkedListImpl<>();
			}
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
	public void remove(T element) {
		if(!isEmpty()) {
			if(this.data.equals(element)) {
				this.next = this.next.next;
				this.data = this.next.data;
			} else this.next.remove(element);
		}
	}
	
	@Override
	public void removeLast() {
		if(!isEmpty()) {
			if(this.next.getData() == null) {
				this.next = null;
				this.data = null;
			} else ((RecursiveDoubleLinkedListImpl<T>) this.getNext()).removeLast();
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
