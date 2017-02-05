/**
 * 
 */
package edu.csulb.ds.linkedlist;

import java.util.Random;

/**
 * @author Manav
 *
 */
public class TestLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random random = new Random();

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.append(random.nextInt(100));
		ll.append(random.nextInt(100));
		ll.append(random.nextInt(100));
		ll.append(random.nextInt(100));
		ll.append(random.nextInt(100));
		ll.append(random.nextInt(100));
		ll.append(random.nextInt(100));
		ll.append(random.nextInt(100));
		ll.append(random.nextInt(100));

		// Size = 8
		System.out.println("Size of the linked list is : " + ll.size());

		testReverseOperation(ll);

		testRecursiveReverseOperation(ll);

		System.out.println("3rd node from end is : " + ll.getNthNodeFromTheEnd(3).data);

		System.out.println("Middle element of this linked list is : " + ll.getMiddleElement().data);

		// ll.createALoop();
		System.out.println("Does loop exists in this linkedList : " + ll.doesLoopExist());
		
		// Below linked lists are created to test the merging of two sorted linked Lists
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		ll1.append(3);
		ll1.append(9);
		ll1.append(17);
		ll1.append(23);
		ll1.append(47);		
		
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		ll2.append(1);
		ll2.append(15);
		ll2.append(18);
		ll2.append(25);
		ll2.append(43);
		
		System.out.println("Linked List 1");
		ll1.printList();
		
		System.out.println("Linked List 2");
		ll2.printList();
		
		System.out.println("Final sorted list");		
		mergeSortedLists(ll1, ll2).printList();
	}

	private static void testRecursiveReverseOperation(LinkedList<Integer> ll) {
		System.out.println("Current linked list is : ");
		ll.printList();

		// Reverse the list
		ll.recursiveReverse();

		System.out.println("Reversed linked list is : ");
		ll.printList();
	}

	private static void testReverseOperation(LinkedList<Integer> ll) {

		System.out.println("Current linked list is : ");
		ll.printList();

		// Reverse the list
		ll.reverse();

		System.out.println("Reversed linked list is : ");
		ll.printList();
	}
	
	private static LinkedList<Integer> mergeSortedLists(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		LinkedList<Integer> ll3 = null;
		
		Node<Integer> n1, n2, n3;
		
		n1 = ll1.getHead();
		n2 = ll2.getHead();
		
		while (n1 != null && n2 != null) {
			if (n1.data < n2.data) {
				if (ll3 == null) {
					ll3 = new LinkedList<Integer>(n1.data);
				} else {
					ll3.append(n1.data);
				}
				n1 = n1.next;
				
			} else {
				if (ll3 == null) {
					ll3 = new LinkedList<Integer>(n2.data);
				} else {
					ll3.append(n2.data);
				}
				n2 = n2.next;
			}
		}
		
		while (n1 != null) {
			ll3.append(n1.data);
			n1 = n1.next;
		}
		
		while (n2 != null) {
			ll3.append(n2.data);
			n2 = n2.next;
		}
 		
		return ll3;
	}
}
