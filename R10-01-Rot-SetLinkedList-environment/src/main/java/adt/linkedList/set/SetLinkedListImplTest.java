package adt.linkedList.set;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetLinkedListImplTest {

	SetLinkedList set;
	
	@Before
	public void setUp() throws Exception {
		this.set = new SetLinkedListImpl();
	}

	@Test
	public void insert() {
		this.set.insert(new Integer(3));
		this.set.insert(new Integer(4));
		this.set.insert(new Integer(5));
		this.set.insert(new Integer(6));
		
		Assert.assertArrayEquals(new Integer[] {3, 4, 5, 6}, set.toArray());
	}

	@Test
	public void removeDuplicates() {
		this.set.insert(new Integer(3));
		this.set.insert(new Integer(4));
		this.set.insert(new Integer(5));
		this.set.insert(new Integer(6));
		this.set.insert(new Integer(6));
		
		Assert.assertArrayEquals(new Integer[] {3, 4, 5, 6, 6}, set.toArray());
		set.removeDuplicates();
		Assert.assertArrayEquals(new Integer[] {3, 4, 5, 6}, set.toArray());
		
	}
}
