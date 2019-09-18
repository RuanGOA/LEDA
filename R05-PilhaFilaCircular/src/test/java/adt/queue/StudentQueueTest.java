package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueImpl<Integer>(4);
		queue2 = new QueueImpl<Integer>(2);
		queue3 = new QueueImpl<Integer>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
		}
	}

	@Test
	public void testEnqueueComErro() {
		try {
			queue1.enqueue(5); 		

		} catch(QueueOverflowException e) {}
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {}
	}

	@Test
	public void testDequeueComErro() throws QueueUnderflowException {
		try {
			assertEquals(new Integer(1), queue1.dequeue()); // vai depender do						
		} catch(QueueUnderflowException e) {}
	}
	
	@Test
	public void testGenericoRandom() throws QueueUnderflowException, QueueOverflowException {
		assertEquals(new Integer(1), queue1.dequeue());
		assertEquals(new Integer(2), queue1.dequeue());
		assertEquals(new Integer(3), queue1.dequeue());
		
		try {
			assertEquals(new Integer(0), queue1.dequeue());
		} catch(QueueUnderflowException e) {}
		
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);
		assertEquals(new Integer(1), queue1.dequeue());
		queue1.enqueue(1);
		queue1.enqueue(4);
		assertEquals(new Integer(2), queue1.dequeue());
		assertEquals(new Integer(3), queue1.head());
		assertEquals(new Integer(3), queue1.dequeue());
		assertEquals(new Integer(1), queue1.dequeue());
		assertEquals(new Integer(4), queue1.dequeue());
	}
}