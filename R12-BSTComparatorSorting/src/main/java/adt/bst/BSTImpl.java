package adt.bst;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

   protected BSTNode<T> root;

   public BSTImpl() {
      root = new BSTNode<T>();
   }

   public BSTNode<T> getRoot() {
      return this.root;
   }

   @Override
   public boolean isEmpty() {
      return root.isEmpty();
   }

   @Override
   public int height() {
      return heightNode(this.root);
   }

   private int heightNode(BTNode<T> node) {
      int height = -1;
      if (!node.isEmpty()) {
         height = 1 + Math.max(heightNode(node.getLeft()), heightNode(node.getRight()));
      }

      return height;
   }

   @Override
   public BSTNode<T> search(T element) {

      BSTNode<T> result = new BSTNode<>();

      if (element != null) {

         if (!this.isEmpty())
            result = searchNode(this.root, element);

      }

      return result;
   }

   private BSTNode<T> searchNode(BSTNode<T> node, T element) {

      BSTNode<T> aux = new BSTNode<>();

      if (!node.isEmpty()) {
         if (node.getData().equals(element))
            aux = node;

         else if (node.getData().compareTo(element) > 0)
            aux = searchNode((BSTNode<T>) node.getLeft(), element);

         else
            aux = searchNode((BSTNode<T>) node.getRight(), element);
      }

      return aux;
   }

   @Override
   public void insert(T element) {

      if (element != null) {

         insertNode(this.root, element);

      }

   }

   private void insertNode(BTNode<T> node, T element) {

      if (node.getData() == null) {

         node.setData(element);
         node.setLeft(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());//TENTAR ACHAR ALTERNATIVA
         node.setRight(new BSTNode.Builder<T>().data(null).left(null).right(null).parent(node).build());

      } else if (node.getData().compareTo(element) > 0) {

         insertNode(node.getLeft(), element);

      } else {

         insertNode(node.getRight(), element);

      }

   }

   @Override
   public BSTNode<T> maximum() {
      BSTNode<T> max;

      if (this.isEmpty()) {
         max = null;

      } else {
         max = maximum(this.root);

      }

      return max;
   }

   private BSTNode<T> maximum(BSTNode<T> node) {
      BSTNode<T> max = node;

      if (!node.getRight().isEmpty()) {
         max = maximum((BSTNode<T>) node.getRight());
      }

      return max;
   }

   @Override
   public BSTNode<T> minimum() {
      BSTNode<T> min;

      if (this.isEmpty()) {
         min = null;

      } else {
         min = minimum(this.root);

      }

      return min;
   }

   private BSTNode<T> minimum(BSTNode<T> node) {
      BSTNode<T> min = node;

      if (!node.getLeft().isEmpty()) {
         min = minimum((BSTNode<T>) node.getLeft());
      }

      return min;
   }

   @Override
   public BSTNode<T> sucessor(T element) {
      BSTNode<T> node = this.search(element);

      if (element != null && !this.root.isEmpty() && !node.isEmpty()) {

         if (!node.getRight().isEmpty()) {
            node = minimum((BSTNode<T>) node.getRight());

         } else {
            node = sucessor(node);

         }
      } else {
         node = null;

      }

      return node;
   }

   private BSTNode<T> sucessor(BSTNode<T> node) {
      BSTNode<T> sucessor = (BSTNode<T>) node.getParent();

      if (node.getParent() != null) {

         if (!sucessor.isEmpty() && sucessor.getRight().equals(node)) {
            sucessor = sucessor((BSTNode<T>) node.getParent());
         }
      }

      return sucessor;
   }

   @Override
   public BSTNode<T> predecessor(T element) {
      BSTNode<T> node = this.search(element);

      if (element != null && !this.root.isEmpty() && !node.isEmpty()) {

         if (!node.getLeft().isEmpty()) {
            node = maximum((BSTNode<T>) node.getLeft());

         } else {
            node = predecessor(node);

         }

      } else {
         node = null;

      }

      return node;
   }

   private BSTNode<T> predecessor(BSTNode<T> node) {
      BSTNode<T> predecessor = (BSTNode<T>) node.getParent();

      if (node.getParent() != null) {

         if (!predecessor.isEmpty() && predecessor.getLeft().equals(node)) {
            predecessor = predecessor((BSTNode<T>) node.getParent());

         }
      }

      return predecessor;
   }

   @Override
   public void remove(T element) {
      BSTNode<T> node = search(element);

      //TESTE DE ELEMENT NULL(+-)
      if (!node.isEmpty()) {
         //SE O NO ACHADO FOR UMA FOLHA, EASY GAME
         if (node.isLeaf()) {
            node.setData(null);
            node.setRight(null);
            node.setLeft(null);

            //SE NAO HOUVER ALGUM DOS FILHOS, ENTAO UM VAI SUBIR DE CERTEZA
         } else if (node.getRight().isEmpty() || node.getLeft().isEmpty()) {
            BSTNode<T> parent = (BSTNode<T>) node.getParent();
            //SE OUVER PAI, E UM DOS FILHOS ESTIVER VAZIO, O QUE NAO ESTA VAI SUBIR
            if (parent != null) {
               //SE NODE NAO FOR UM FILHO DA ESQUERDA
               if (!parent.getLeft().equals(node)) {
                  //SE O NO VAZIO NAO FOR O DA ESQUERDA, O DA ESQUERDA SOBE
                  if (!node.getLeft().isEmpty()) {
                     parent.setRight(node.getLeft());
                     node.getLeft().setParent(parent);
                     //SE O NO VAZIO FOR O DA ESQUERDA, O DA DIREITA SOBE
                  } else {
                     parent.setRight(node.getRight());
                     node.getRight().setParent(parent);
                  }
                  //ENTAO O NODE E O FILHO DA ESQUERDA
               } else {
                  //SE O NO VAZIO NAO FOR O DA ESQUERDA, O DA ESQUERDA SOBE
                  if (!node.getLeft().isEmpty()) {
                     parent.setLeft(node.getLeft());
                     node.getLeft().setParent(parent);
                     //SE O NO VAZIO FOR O DA ESQUERDA, O DA DIREITA SOBE
                  } else {
                     parent.setLeft(node.getRight());
                     node.getRight().setParent(parent);
                  }
               }
               //SE NAO HOUVER PAI, ENTAO EASY GAME AGAIN
            } else {
               //SE O DA ESQUERDA FOR O VAZIO, O DA DIREITA SOBE
               if (node.getLeft().isEmpty()) {
                  this.root = (BSTNode<T>) node.getRight();
                  //SE O DA DIREITA FOR VAZIO, O DA ESQUERDA SOBE
               } else {
                  this.root = (BSTNode<T>) node.getLeft();
               }

               //O PAI DO NOVO NO VAI COMPRAR CIGARRO AO VIVO
               this.root.setParent(null);
            }
            //SE TIVER OS DOIS FILHOS, O ELEMENTO DO SUCESSOR DEVE SER ACHADO	
         } else {
            T sucessor = sucessor(node.getData()).getData();//BUSCANDO O SUCESSOR DO DATA DO NODE
            remove(sucessor);//RETIRAR ELE(VAI SER UM NO FOLHA DE CERTEZA
            node.setData(sucessor);//E O SUCESSOR, VIRA O NODE
         }
      }
   } //EVERYBODY HATES CHRIS, OoooooOOHHHH YYEEAAHH

   @Override
   public T[] preOrder() {
      T[] array = (T[]) new Comparable[this.size()];

      preOrder(this.root, 0, array);

      return array;
   }

   private void preOrder(BSTNode<T> node, int i, T[] array) {
      if (!node.isEmpty()) {

         array[i] = node.getData();

         preOrder((BSTNode<T>) node.getLeft(), i + 1, array);

         int sizeLeft = size((BSTNode<T>) node.getLeft());

         preOrder((BSTNode<T>) node.getRight(), i + 1 + sizeLeft, array);

      }
   }

   @Override
   public T[] order() {
      T[] array = (T[]) new Comparable[this.size()];

      order(this.root, 0, array);

      return array;
   }

   private int order(BSTNode<T> node, int i, T[] array) {

      if (!node.isEmpty()) {

         i = order((BSTNode<T>) node.getLeft(), i, array);

         array[i++] = node.getData();

         i = order((BSTNode<T>) node.getRight(), i, array);

      }

      return i;
   }

   @Override
   public T[] postOrder() {
      T[] array = (T[]) new Comparable[this.size()];

      postOrder(this.root, 0, array);

      return array;
   }

   private int postOrder(BSTNode<T> node, int i, T[] array) {
      if (!node.isEmpty()) {
         i = postOrder((BSTNode<T>) node.getLeft(), i, array);
         i = postOrder((BSTNode<T>) node.getRight(), i, array);
         array[i++] = node.getData();
      }

      return i;
   }

   /**
    * This method is already implemented using recursion. You must understand
    * how it work and use similar idea with the other methods.
    */
   @Override
   public int size() {
      return size(root);
   }

   private int size(BSTNode<T> node) {
      int result = 0;
      // base case means doing nothing (return 0)
      if (!node.isEmpty()) { // indusctive case
         result = 1 + size((BSTNode<T>) node.getLeft()) + size((BSTNode<T>) node.getRight());
      }
      return result;
   }
}