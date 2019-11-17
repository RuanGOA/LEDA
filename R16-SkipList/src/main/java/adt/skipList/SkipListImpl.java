package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	
	@Override
	public void insert(int key, T newValue, int height) {
		
		SkipListNode<T>[] update = new SkipListNode[this.maxHeight];
		SkipListNode<T> aux = this.root;
		
		for(int i = this.maxHeight - 1; i > -1; i--) {
			
			while(aux.getForward(i).getKey() < key) {
				
				aux = aux.getForward(i);
			}
			
			update[i] = aux;
		}
		
		aux = aux.getForward(0);
		
		if(aux.getKey() == key) {
			
			aux.setValue(newValue);
			
		} else {
			
			aux = new SkipListNode<T>(key, height, newValue);
			
			for(int i = 0; i < height; i++) {
				aux.forward[i] = update[i].forward[i];
				update[i].forward[i] = aux;
			}
		}
	}

	@Override
	public void remove(int key) {
		SkipListNode<T>[] update = new SkipListNode[this.maxHeight];
		SkipListNode<T> aux = this.root;
		
		for(int i = this.maxHeight - 1; i > -1; i--) {
			
			while(aux.getForward(i).getKey() < key) {
				aux = aux.getForward(i);
			}
			
			update[i] = aux;
		}
		
		aux = aux.getForward(0);
		
		if(aux.getKey() == key) {
			
			int i = 0;
			while(i < this.height()) {
				
				if(!update[i].forward[i].equals(aux)) {
					break;
				}
				
				update[i].forward[i] = aux.forward[i++];
			}
		}
	}

	@Override
	public int height() {
		
		SkipListNode<T> aux = this.root.getForward(0);
		int height = 0;
		
		while(!aux.equals(NIL)) {
			
			height = Math.max(height, aux.height());
			aux = aux.getForward(0);
		}
		
		return height;
	}

	@Override
	public SkipListNode<T> search(int key) {
		
		SkipListNode<T> aux = this.root;
		SkipListNode<T> result = null;
		
		for(int i = this.maxHeight - 1; i > -1; i--) {
			
			while(aux.getForward(i).getKey() < key) {
				
				aux = aux.getForward(i);
			}
		}
		
		aux = aux.getForward(0);

		if(aux.getKey() == key) {
			
			result = aux;
		}
		
		return result;
	}

	@Override
	public int size() {
		
		SkipListNode<T> aux = this.root;
		
		int size = 0;
		while(!aux.getForward(0).equals(NIL)) {
			
			size++;
			aux = aux.getForward(0);
		}
		
		return size;
	}

	@Override
	public SkipListNode<T>[] toArray() {
		
		SkipListNode<T> aux = this.root;
		SkipListNode<T>[] array = new SkipListNode[this.size() + 2];
		
		for(int i = 0; i < array.length; i++) {
			
			array[i] = aux;
			aux = aux.getForward(0);
		}
		
		return array;
	}
}