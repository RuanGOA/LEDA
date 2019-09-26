package main;

import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class main {
   public static void main(String[] args) {
      RecursiveDoubleLinkedListImpl<Integer> lista = new RecursiveDoubleLinkedListImpl<>();

      lista.insert(9);
      System.out.println(lista.size() == 1);
      lista.insert(10);
      System.out.println(lista.size() == 2);

   }

}
