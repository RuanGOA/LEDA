package adt.queue;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.linkedList.DoubleLinkedList;

public class QueueDoubleLinkedListImplTest {
	
	private QueueDoubleLinkedListImpl<Integer> lista3;

	@Before
	public void setUp() throws Exception {
		this.lista3 = new QueueDoubleLinkedListImpl<Integer>(3);
	}
	
	@Test
	public void testIsFull() {
		assertEquals(false, this.lista3.isFull());
	}
	
	@Test
	public void testIsEmpty() {
		assertEquals(true, this.lista3.isEmpty());
	}
	
	@Test
	public void ixprudi() throws QueueOverflowException {
		this.lista3.enqueue(5);
		assertEquals(new Integer(5), this.lista3.head());
		this.lista3.enqueue(3);
		this.lista3.enqueue(7);
		try {
			this.lista3.enqueue(10);
		} catch(QueueOverflowException qofe) {
			System.out.println("Deu bom clã");
		}
	}
	
	@Test
	public void secar() throws QueueUnderflowException {
		assertEquals(null, this.lista3.head());
		try {
			this.lista3.dequeue();
		} catch(QueueUnderflowException qofe) {
			System.out.println("Deu bom clã");
		}
	}

}
