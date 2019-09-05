package problems;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FloorCeilTest {

	Integer[] array = new Integer[] {4, 6, 8, 10};
	FloorCeilBinarySearch bs = new FloorCeilBinarySearch();
	
	@Test
	public void test() {
		assertEquals((Integer)bs.floor(array, 7), new Integer(8));
	}
	
	@Test
	public void test1() {
		
	}

}
