package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		T resultado = null;
		
		if(!isEmpty()) {
			resultado = this.array[top];
		}
		
		return resultado;
	}

	@Override
	public boolean isEmpty() {
		boolean resultado = this.top == -1;
		
		return resultado;
	}

	@Override
	public boolean isFull() {
		boolean resultado = top == this.array.length - 1;
		
		return resultado;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!(this.top >= this.array.length)) {
			this.array[++top] = element;
		} else throw new StackOverflowException();
	}

	@Override
	public T pop() throws StackUnderflowException {
		T resultado;
		if(this.top != -1) {
			resultado = this.array[top--];
		} else throw new StackUnderflowException();
		
		return resultado;
	}
}
