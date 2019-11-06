package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.BTNode;
import adt.bt.Util;

/**
 * 
 * Implementacao de uma arvore AVL
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

   @Override
   public void insert(T element) {
      if (element != null) {
         insertNode(this.root, element);
      }
   }

   private void insertNode(BSTNode<T> node, T element) {
      if (node.isEmpty()) {
         node.setData(element);
         node.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());
         node.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());

         rebalanceUp(node);

      } else {
         if (node.getData().compareTo(element) < 0) {
            insertNode((BSTNode<T>) node.getRight(), element);

         } else if (node.getData().compareTo(element) > 0) {
            insertNode((BSTNode<T>) node.getLeft(), element);

         }
      }
   }

   protected int calculateBalance(BSTNode<T> node) {
      if (node == null || node.isEmpty()) {
         return 0;
      }

      return this.height((BSTNode<T>) node.getRight()) - this.height((BSTNode<T>) node.getLeft());
   }

   private int height(BTNode<T> node) {
      int height = -1;
      if (!node.isEmpty()) {
         height = 1 + Math.max(height(node.getLeft()), height(node.getRight()));
      }

      return height;
   }

   protected void rebalance(BSTNode<T> node) {
      int coefficient = this.calculateBalance(node);

      if (coefficient > 1) {
         int coefficientRight = this.calculateBalance((BSTNode<T>) node.getRight());

         if (coefficientRight < 0) {
            this.rightRotation((BSTNode<T>) node.getRight());
         }

         this.leftRotation(node);

      } else if (coefficient < -1) {
         int coefficientLeft = this.calculateBalance((BSTNode<T>) node.getLeft());

         if (coefficientLeft > 0) {
            this.leftRotation((BSTNode<T>) node.getLeft());
         }

         this.rightRotation(node);

      }
   }

   protected void rebalanceUp(BSTNode<T> node) {
      if (node != null) {
         rebalance(node);
         rebalanceUp((BSTNode<T>) node.getParent());
      }
   }

   @Override
   public void remove(T element) {
      BSTNode<T> node = super.search(element);
      super.remove(element);
      this.rebalanceUp(node);
   }

   protected void rightRotation(BSTNode<T> node) {
      BSTNode<T> aux = Util.rightRotation(node);

      if (aux.getParent() == null) {
         this.root = aux;
      }
   }

   protected void leftRotation(BSTNode<T> node) {
      BSTNode<T> aux = Util.leftRotation(node);

      if (aux.getParent() == null) {
         this.root = aux;
      }
   }
}