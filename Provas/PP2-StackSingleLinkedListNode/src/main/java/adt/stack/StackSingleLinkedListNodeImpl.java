package adt.stack;

import adt.linkedList.SingleLinkedListNode;

/**
 * Classe que representa uma pilha implementada usando-se um noh de uma lista
 * simplesmente ligada, como estrutura sobrejacente. 
 * 
 * Restricoes:
 * - voce DEVE obedecer a politica de acesso e complexidade dos metodos de pilha, ou seja, todos em O(1).
 * - voce NÃO pode usar memoria extra (estrutura auxiliar)
 * - qualquer metodo auxiliar que voce necessite DEVE ser implementado nesta classe
 * - voce NÃO pode modificar a classe SingleLinkedListNode
 * 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class StackSingleLinkedListNodeImpl<T> implements Stack<T> {
	
	private SingleLinkedListNode<T> top;
	private int elements; //QUANTIDADE DE ELEMENTOS ATUALMENTE NA PILHA
	private int maxSize; //TAMANHO MAXIMO DA PILHA

	/**
	 * A pilha para ser criada precisa ter um tamanho maximo
	 * @param tamanhoMaximo
	 */
	public StackSingleLinkedListNodeImpl(int tamanhoMaximo) {
		this.top = new SingleLinkedListNode<T>();
		this.maxSize = tamanhoMaximo;
		this.elements = 0;
	}

	@Override
	public void push(T element) throws StackOverflowException { //OK OK OK
		if(element != null) {
			if(!this.isFull()) {
				SingleLinkedListNode<T> node = new SingleLinkedListNode<T>(element, this.top);
				this.top = node;
				this.elements++;
				
			} else throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException { //OK OK OK
		T result = null;
		
		if(!this.isEmpty()) {
			
			result = this.top.getData();
			this.top = this.top.getNext();
			this.elements--;
			
		} else throw new StackUnderflowException();
		
		return result;
	}

	@Override
	public T top() { //OK
		T result = null;
		
		if(!this.isEmpty()) {
			result = this.top.getData();
		} 
		
		return result;
	}

	@Override
	public boolean isEmpty() { //OK OK
		return this.elements == 0;
	}

	@Override
	public boolean isFull() { //OK OK
		return this.elements == this.maxSize;
	}
}
