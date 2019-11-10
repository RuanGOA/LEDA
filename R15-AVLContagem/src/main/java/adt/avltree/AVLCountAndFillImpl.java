package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		List<T[]> list = new ArrayList<T[]>();
		
		Arrays.sort(array);
		list.add(array);
		
		int i = 0;
		while(i < list.size()) {
			T[] aux = list.get(i);
			
			int mid = aux.length / 2;
			
			//primeira metade do array da vez
			T[] aux1 = Arrays.copyOfRange(aux, 0, mid);
			//segunda metade do array da vez
			T[] aux2 = Arrays.copyOfRange(aux, mid+1, aux.length);
			
			/*se ambos o aux tiver apenas um elemento, aux1 e aux2 tambem terao apenas esse elemento,
			 * logo nao faz sentido adicionar aux1 e aux2 na lista novamente.
			 */
			if(aux.length > 1) {
				list.add(aux1);
				list.add(aux2);
			}
			
			//sempre o elemento da metade do array
			insert(aux[mid]);
			i++;	
		}
	}
	
	@Override
	protected void rebalance(BSTNode<T> node) {
	      int coefficient = this.calculateBalance(node);
	      boolean simple = true;
	      if (coefficient > 1) {
	         int coefficientRight = this.calculateBalance((BSTNode<T>) node.getRight());
	         
	         if (coefficientRight < 0) {
	            this.rightRotation((BSTNode<T>) node.getRight());
	            simple = false;
	         }

	         this.leftRotation(node);
	         
	         if(!simple) {
	        	 this.LRcounter++;
	         } else this.RRcounter++;
	         
	      } else if (coefficient < -1) {
	         int coefficientLeft = this.calculateBalance((BSTNode<T>) node.getLeft());

	         if (coefficientLeft > 0) {
	            this.leftRotation((BSTNode<T>) node.getLeft());
	            simple = false;
	         }

	         this.rightRotation(node);
	         
	         if(!simple) {
	        	 this.RLcounter++;
	         } else this.LLcounter++;
	      }
	}
	
	
	
}
