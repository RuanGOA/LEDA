package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		
		SingleLinkedListNode node = this.head;
		SingleLinkedListNode nodeAux;
		while(!node.isNIL()) {
			nodeAux = node.getNext();
			while(!nodeAux.isNIL()) {
				
			}
			
			
			node = node.getNext();
			
		}
	}
	

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		SetLinkedList<T> result = new SetLinkedListImpl();
		
		for(T element : super.toArray()) result.insert(element);
		
		for(T element : otherSet.toArray()) result.insert(element);
		
		result.removeDuplicates();
		
		return result;
	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		SetLinkedList<T> result = new SetLinkedListImpl();
		
		for(T element : super.toArray()) {
			if(otherSet.search(element) != null) {
				result.insert(element);
			}
		}
		
		return result;
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		for(T element : otherSet.toArray()) super.insert(element);
	}

}
