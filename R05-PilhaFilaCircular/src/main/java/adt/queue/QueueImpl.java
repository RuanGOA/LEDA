package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		T resultado = null;
		if(tail > -1) {
			resultado = this.array[0];
		}
		
		return resultado;
	}

	@Override
	public boolean isEmpty() {
		boolean resultado = tail == -1;
		
		return resultado;
	}

	@Override
	public boolean isFull() {
		boolean resultado = tail == this.array.length - 1;
		
		return resultado;
	}

	private void shiftLeft() {
		for(int i = 0; i < this.tail; i++) {
			this.array[i] = this.array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()) {
			this.array[++this.tail] = element;
		} else throw new QueueOverflowException();
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if(tail > -1) {
			result = this.array[0];
			shiftLeft();
			tail--;
		} else throw new QueueUnderflowException();
		
		return result;
	}

}
