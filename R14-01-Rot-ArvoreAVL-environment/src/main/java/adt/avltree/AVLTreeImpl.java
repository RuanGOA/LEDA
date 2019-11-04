package adt.avltree;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;

/**
 * 
 * Implementacao de uma arvore AVL
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements
		AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		int r = 0;
		if(!node.getRight().isEmpty()) {
			r = heightNode(node.getRight());  
		}
		
		
		int l = 0;
	}
	
	private int heightNode(BTNode<T> node) {
	      int height = -1;
	      if (!node.isEmpty()) {
	         height = 1 + Math.max(heightNode(node.getLeft()), heightNode(node.getRight()));
	      }

	      return height;
	   }

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}
}
