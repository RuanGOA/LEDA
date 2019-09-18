package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) throw new QueueOverflowException();
		
		this.tail = (this.tail + 1) % this.array.length;
		
		this.array[this.tail] = element;
		
		this.elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) throw new QueueUnderflowException();
		
		this.head = (this.head + 1) % this.array.length;
		
		T resultado = this.array[this.head];
		
		this.elements--;
		
		return resultado;
	}

	@Override
	public T head() {
		T resultado = null;
		if(!isEmpty()) {
			resultado = this.array[(this.head + 1) % this.array.length];
		}
		
		return resultado;
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == this.array.length;
	}

}
