package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends AbstractHashtableOpenAddress<T> {

   public HashtableOpenAddressLinearProbingImpl(int size, HashFunctionClosedAddressMethod method) {
      super(size);
      hashFunction = new HashFunctionLinearProbing<T>(size, method);
      this.initiateInternalTable(size);
   }

   private int getHash(T element, int probe) {
      return Math.abs(((HashFunctionLinearProbing<T>) super.hashFunction).hash(element, probe));
   }

   @Override
   public void insert(T element) {
      if (element != null && search(element) == null) {

         if (super.isFull())
            throw new HashtableOverflowException();

         int hash;
         int i = 0;
         boolean inserted = false;
         while (!inserted) {
            hash = getHash(element, i++);
            if (super.table[hash] == null || super.table[hash].equals(deletedElement)) {
               super.table[hash] = element;
               inserted = true;
               super.elements++;
            } else {
               super.COLLISIONS++;
            }
         }
      }
   }

   @Override
   public void remove(T element) {
      if (element != null && !isEmpty()) {
         int hash = indexOf(element);
         
         if(hash > -1) {
        	 super.table[hash] = deletedElement;
        	 super.elements--;
         }
      }
   }

   @Override
   public T search(T element) {
      T result = null;

      if (element != null && !isEmpty()) {
         int hash = indexOf(element);

         if (hash > -1) {
            result = (T) super.table[hash];
         }
      }

      return result;
   }

   @Override
   public int indexOf(T element) {
      int result = -1;

      if (element != null && !isEmpty()) {
         int hash;
         int i = 0;
         boolean found = false;
         while (!found && i < size()) {
            hash = getHash(element, i++);

            if (super.table[hash] == null) {
               found = true;
            } else if (super.table[hash].equals(element)) {
               result = hash;
               found = true;
            }
         }
      }

      return result;
   }
}
