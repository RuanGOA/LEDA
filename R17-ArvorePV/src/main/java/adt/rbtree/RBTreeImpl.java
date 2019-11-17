package adt.rbtree;

import java.util.ArrayList;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;
import adt.rbtree.RBNode.Colour;

public class RBTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements RBTree<T> {

	public RBTreeImpl() {
		this.root = new RBNode<T>();
	}
	
	public RBNode<T> getRBRoot() {
		return (RBNode<T>) this.root;
	}
	
	private RBNode<T> getRBRight(BSTNode<T> node) {
		return (RBNode<T>) node.getRight();
	}
	
	private RBNode<T> getRBLeft(BSTNode<T> node) {
		return (RBNode<T>) node.getLeft();
	}
	
	private RBNode<T> getNodeParent(BSTNode<T> node) {
		return (RBNode<T>) node.getParent();
	}
	
	private boolean verifyNodesColour() {
		return true;
	}
	
	private boolean verifyRootColour() {
		return ((RBNode<T>) root).getColour() == Colour.BLACK;
	}
	
	private boolean verifyNILNodeColour() {
		return true;
	}

	private RBNode<T> getNodeGrand(BSTNode<T> node) {
		
		RBNode<T> grand = null;
		
		if(node.getParent() != null) {
			
			if(node.getParent().getParent() != null) {
				grand = (RBNode<T>) node.getParent().getParent();
			}
		}
		
		return grand;
	}
	
	private int nodeSide(RBNode<T> node) {
		
		int side = 0;
		
		if(node.getParent() != null) {
			
			if(node.getData().compareTo(node.getParent().getData()) < 0) {
				side--;
			} else {
				side++;
			}
		}
		
		return side;
	}
	
	private RBNode<T> getNodeUncle(BSTNode<T> node) {
		
		RBNode<T> uncle = null;
		RBNode<T> grand = this.getNodeGrand(node);
		
		if(grand != null) {
			if(this.nodeSide(this.getNodeParent(node)) == -1) {
				
				uncle = this.getRBRight(grand);
			} else {
				
				uncle = this.getRBLeft(grand);
			}
		}
		
		return uncle;
	}
	
	protected int blackHeight() {
		
		return this.blackHeight(this.getRBRoot());
	}
	
	private int blackHeight(RBNode<T> node) {
		
		int result = 0;
		
		if(node != null && !node.isEmpty()) {
			
			if(node.getColour() == Colour.BLACK) {
				
				result++;
			}
			
			result += Math.max(this.blackHeight(this.getRBLeft(node)), 
						this.blackHeight(this.getRBRight(node)));
		}
		
		return result;
	}
	
	protected boolean verifyProperties() {
		
		boolean resp = verifyNodesColour() &&
					   verifyNILNodeColour() &&
					   verifyRootColour() &&
					   verifyChildrenOfRedNodes() &&
					   verifyBlackHeight();
		
		return resp;
	}
	
	private boolean verifyChildrenOfRedNodes() {
		return this.verifyChildrenOfRedNodes(this.getRBRoot());
	}

	private boolean verifyChildrenOfRedNodes(RBNode<T> node) {
		
		boolean verified = true;
		
		if(node != null && !node.isEmpty() && node.getColour() == Colour.RED) {
			
			verified = this.getRBLeft(node).getColour() == Colour.BLACK
					&& this.getRBRight(node).getColour() == Colour.BLACK;			
		}
		
		if(!node.isEmpty() && (node.getColour() == Colour.BLACK || verified)) {
			
			verified = this.verifyChildrenOfRedNodes(this.getRBLeft(node))
					&& this.verifyChildrenOfRedNodes(this.getRBRight(node));
		}
		
		return verified;
	}
	
	private boolean verifyBlackHeight() {
		return this.verifyBlackHeight(this.getRBRoot());
	}
	
	private boolean verifyBlackHeight(RBNode<T> node) {
		
		boolean verified = node.isEmpty() ||
				(this.blackHeight(this.getRBLeft(node)) == 
				 this.blackHeight(this.getRBRight(node)));
		
		if(!node.isEmpty() && verified) {
			
			verified = this.verifyBlackHeight(this.getRBLeft(node)) &&
					this.verifyBlackHeight(this.getRBRight(node));
		}
		
		return verified;
	}
	
	@Override
	public void insert(T value) {
		
		RBNode<T> node = this.insert(value, this.getRBRoot());
		this.fixUpCase1(node);
	}
	
	private RBNode<T> insert(T value, RBNode<T> node) {
		
		RBNode<T> result = null;
		
		if(node.isEmpty()) {
			
			node.setData(value);
			node.setColour(Colour.RED);
			
			node.setLeft(new RBNode<>());
			node.getLeft().setParent(node);
			
			node.setRight(new RBNode<>());
			node.getRight().setParent(node);
			
			result = node;
		} else {
			
			if(node.getData().compareTo(value) > 0) {
				
				result = this.insert(value, this.getRBLeft(node));			
			} else {
				
				result = this.insert(value, this.getRBRight(node));
			}
		}
		
		return result;
	}
	
	@Override
	public RBNode<T>[] rbPreOrder() {
		
		ArrayList<RBNode<T>> array = new ArrayList<>();
		
		if(!this.isEmpty()) {
			
			this.rbPreOrder(this.getRBRoot(), array);
		}
		
		
		return array.toArray(new RBNode[this.size()]);
	}
	
	private void rbPreOrder(RBNode<T> node, ArrayList<RBNode<T>> array) {
		
		if(!node.isEmpty()) {
			
			array.add(node);
			
			this.rbPreOrder(this.getRBLeft(node), array);
			this.rbPreOrder(this.getRBRight(node), array);
		}
	}
	
	protected void fixUpCase1(RBNode<T> node) {
		
		if(node.equals(this.getRBRoot())) {
			
			node.setColour(Colour.BLACK);
		} else {
			
			this.fixUpCase2(node);
		}
	}
	
	protected void fixUpCase2(RBNode<T> node) {
		
		if(this.getNodeParent(node).getColour() != Colour.BLACK) {
			
			this.fixUpCase3(node);
		}
	}
	
	protected void fixUpCase3(RBNode<T> node) {
		
		RBNode<T> grand = this.getNodeGrand(node);
		RBNode<T> uncle = this.getNodeUncle(node);
		
		if(uncle.getColour() == Colour.RED) {
			
			grand.setColour(Colour.RED);
			uncle.setColour(Colour.BLACK);
			this.getNodeParent(node).setColour(Colour.BLACK);
			
			this.fixUpCase1(grand);
		} else {
			
			this.fixUpCase4(node);
		}
	}

	private void fixUpCase4(RBNode<T> node) {
		
		RBNode<T> next = node;
		RBNode<T> parent = this.getNodeParent(node);
		
		if(this.nodeSide(node) > 0 && this.nodeSide(parent) < 0) {
			
			this.leftRotation(parent);
			
			next = this.getRBLeft(node);
		} else if(this.nodeSide(node) < 0 && this.nodeSide(parent) > 0) {
			
			this.rightRotation(parent);
			
			next = this.getRBRight(node);
		}
		
		this.fixUpCase5(next);
	}

	private void fixUpCase5(RBNode<T> node) {
		
		RBNode<T> parent = this.getNodeParent(node);
		RBNode<T> grand = this.getNodeGrand(node);
		
		parent.setColour(Colour.BLACK);
		grand.setColour(Colour.RED);
		
		if(this.nodeSide(node) == -1) {
			
			this.rightRotation(grand);
		} else {
			
			this.leftRotation(grand);
		}
	}

	protected void leftRotation(BSTNode<T> node) {
		
		BSTNode<T> newNode = Util.leftRotation(node);
		if(newNode.getParent() == null) {
			this.root = newNode;
		}
	}
	
	protected void rightRotation(BSTNode<T> node) {
		
		BSTNode<T> newNode = Util.rightRotation(node);
		if(newNode.getParent() == null) {
			this.root = newNode;
		}
	}
}