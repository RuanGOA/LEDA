package main;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.LinkedList;
import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class main {
	static LinkedList lista = new DoubleLinkedListImpl();
	public static void main(String[] args) {
		
		
		lista.insert(1);
		lista.insert(2);
		lista.insert(3);
		lista.insert(4);
		
		((DoubleLinkedListImpl) lista).revert();
		
		DoubleLinkedListNode node = (DoubleLinkedListNode) ((DoubleLinkedListImpl) lista).getHead();
		while(!node.isNIL()) {
			System.out.println("NÓ : " + node.getData() + " PRED : " + node.getPrevious().getData() + " PROX : " + node.getNext().getData());
			node = (DoubleLinkedListNode) node.getNext();
		}
	}
}
