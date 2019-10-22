package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode();
		this.last = ((DoubleLinkedListNode) this.head);
	}
	
	@Override
	public void insert(T element) {
        if (element != null) {
           DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode(element, new DoubleLinkedListNode(), this.last);
           this.last.next = newLast;
           if(this.last.isNIL()) {
        	   this.head = newLast;
           }
           this.last = newLast;
        }
	}
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode(element, (DoubleLinkedListNode)this.head, this.last);
		((DoubleLinkedListNode)this.head).previous = newHead;
		if(this.head.isNIL()) {
			this.last = newHead;
		}
		this.head = newHead;
	}

	@Override
    public void removeFirst() {
       if (!isEmpty()) {
          this.head = (this.head.getNext());
          if (this.head.isNIL()) {
              this.last = (DoubleLinkedListNode<T>) this.head;
          }
           ((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
       }
    }


	@Override
	public void removeLast() {
		if(!isEmpty()) {
			this.last = this.last.previous;
			if(this.last.isNIL()) {
				this.last = (DoubleLinkedListNode) this.head;
			}
			
			this.last.next = new DoubleLinkedListNode();
		}
	}
	
	@Override
	public void revert() {
		DoubleLinkedListNode tail = this.last;
		DoubleLinkedListNode aux = new DoubleLinkedListNode();
		DoubleLinkedListNode ped = new DoubleLinkedListNode();
		while(!tail.isNIL()) {
			aux = tail.previous;
			tail.previous = ped;
			tail.next = aux;
			ped = tail;
			tail = aux;			
		}
		
		aux = this.last;
		this.last = (DoubleLinkedListNode<T>) this.head;
		this.head = aux;
	}
	
	public void insertIn(int k, T element) {
		if(element != null) {
			DoubleLinkedListNode aux = (DoubleLinkedListNode) this.head;
			int i = 0;
			while(i <= k && aux.data != null) {
				aux = (DoubleLinkedListNode) aux.next;
				System.out.println(i++);
			}
			
			System.out.println("Prev " + aux.getPrevious().getData());
		
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}