package adt.avltree;

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
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
