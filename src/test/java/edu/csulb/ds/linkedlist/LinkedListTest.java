/**
 * 
 */
package edu.csulb.ds.linkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test cases for linked list data structure in Java.
 * 
 * @author Manav
 */
public class LinkedListTest {

	@Test
	public void testNewLinkedList() {
		LinkedList<Integer> ll = new LinkedList<Integer>();

		// ll should be empty
		Assert.assertTrue(ll.isEmpty());
		
		// size of linkedlist should be 0
		Assert.assertEquals(0, ll.size());
		
		ll.append(30);
		
		Assert.assertFalse(ll.isEmpty());
		Assert.assertEquals(1, ll.size());

	}

}
