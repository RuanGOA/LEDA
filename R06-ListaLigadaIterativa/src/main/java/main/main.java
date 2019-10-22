package main;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.LinkedList;
import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class main {
	static LinkedList lista = new SingleLinkedListImpl();
	public static void main(String[] args) {
		
		
		lista.insert(1);
		lista.insert(2);
		lista.insert(3);
		((SingleLinkedListImpl) lista).insertIn(-70, 4);
		
		SingleLinkedListNode node = ((SingleLinkedListImpl) lista).getHead();
		while(!node.isNIL()) {
			System.out.println("NÓ : " + node.getData() + " PROX : " + node.getNext().getData());
			node = node.getNext();
		}
	}
}
