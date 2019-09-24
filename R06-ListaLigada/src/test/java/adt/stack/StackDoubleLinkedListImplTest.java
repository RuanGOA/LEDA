package adt.stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class StackDoubleLinkedListImplTest {

	private StackDoubleLinkedListImpl<Integer> lista3;

	@Before
	public void setUp() throws Exception {
		this.lista3 = new StackDoubleLinkedListImpl<Integer>(3);
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
	public void ixprudi() throws StackOverflowException {
		this.lista3.push(5);
		assertEquals(new Integer(5), this.lista3.top());
		this.lista3.push(3);
		this.lista3.push(7);
		assertEquals(new Integer(7), this.lista3.top());
		try {
			this.lista3.push(10);
		} catch(StackOverflowException stoe) {
		}
	}
	
	@Test
	public void secar() throws StackUnderflowException, StackOverflowException {
		assertEquals(null, this.lista3.top());
		this.lista3.push(3);
		this.lista3.push(7);
		assertEquals(new Integer(7), this.lista3.pop());
		assertEquals(new Integer(3), this.lista3.pop());	
		try {
			this.lista3.pop();
		} catch(StackUnderflowException qofe) {
		}
	}

}
