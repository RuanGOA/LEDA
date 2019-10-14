package adt.linkedList.set;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetLinkedListImplTest {

   SetLinkedList set1;
   SetLinkedList set2;
   SetLinkedList set3;

   @Before
   public void setUp() throws Exception {
      this.set1 = new SetLinkedListImpl();
      this.set2 = new SetLinkedListImpl();
      this.set3 = new SetLinkedListImpl();
   }

   @Test
   public void insert() {
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(4));
      this.set1.insert(new Integer(5));
      this.set1.insert(new Integer(6));
      this.set1.insert(new Integer(6));

      Assert.assertArrayEquals(new Integer[] { 3, 4, 5, 6, 6 }, set1.toArray());
   }

   @Test
   public void removeDuplicates() {
      //varios elementos
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(1));
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(2));
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(2));
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(4));
      this.set1.insert(new Integer(1));
      this.set1.insert(new Integer(2));
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(4));

      Assert.assertArrayEquals(new Integer[] { 3, 1, 3, 2, 3, 2, 3, 4, 1, 2, 3, 4 }, set1.toArray());
      set1.removeDuplicates();
      Assert.assertArrayEquals(new Integer[] { 3, 1, 2, 4 }, set1.toArray());

      //um tipo de elemento
      this.set2.insert(new Integer(3));
      this.set2.insert(new Integer(3));
      this.set2.insert(new Integer(3));
      this.set2.insert(new Integer(3));
      Assert.assertArrayEquals(new Integer[] { 3, 3, 3, 3 }, set2.toArray());
      set2.removeDuplicates();
      Assert.assertArrayEquals(new Integer[] { 3 }, set2.toArray());

      //nenhum elemento
      Assert.assertArrayEquals(new Integer[] {}, set3.toArray());
      set3.removeDuplicates();
      Assert.assertArrayEquals(new Integer[] {}, set3.toArray());
   }

   @Test
   public void union() {
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(1));
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(2));
      this.set1.insert(new Integer(4));

      this.set2.insert(new Integer(4));
      this.set2.insert(new Integer(5));
      Assert.assertArrayEquals(new Integer[] { 3, 1, 2, 4, 5 }, set1.union(set2).toArray());

      this.set3.insert(new Integer(3));
      this.set3.insert(new Integer(3));
      Assert.assertArrayEquals(new Integer[] { 3, 1, 2, 4 }, set1.union(set3).toArray());

      Assert.assertArrayEquals(new Integer[] { 4, 5, 3 }, set2.union(set3).toArray());

      Assert.assertArrayEquals(new Integer[] { 3, 1, 2, 4 }, set1.union(new SetLinkedListImpl()).toArray());
   }

   @Test
   public void intersection() {
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(1));
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(2));
      this.set1.insert(new Integer(4));

      this.set2.insert(new Integer(4));
      this.set2.insert(new Integer(5));
      Assert.assertArrayEquals(new Integer[] { 4 }, set1.intersection(set2).toArray());

      this.set3.insert(new Integer(3));
      this.set3.insert(new Integer(3));
      Assert.assertArrayEquals(new Integer[] { 3 }, set1.intersection(set3).toArray());

      Assert.assertArrayEquals(new Integer[] {}, set2.intersection(set3).toArray());

      Assert.assertArrayEquals(new Integer[] {}, set1.intersection(new SetLinkedListImpl()).toArray());
   }

   @Test
   public void contatenate() {
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(1));
      this.set1.insert(new Integer(3));
      this.set1.insert(new Integer(2));
      this.set1.insert(new Integer(4));

      this.set2.insert(new Integer(4));
      this.set2.insert(new Integer(5));

      set1.concatenate(set2);
      Assert.assertArrayEquals(new Integer[] { 3, 1, 2, 4, 5 }, set1.toArray());

      this.set3.insert(new Integer(3));
      this.set3.insert(new Integer(3));
      set1.concatenate(set3);
      Assert.assertArrayEquals(new Integer[] {3, 1, 2, 4, 5}, set1.toArray());

      SetLinkedList set = new SetLinkedListImpl();
      set1.concatenate(set);
      Assert.assertArrayEquals(new Integer[] {3, 1, 2, 4, 5}, set1.toArray());
   }
}
