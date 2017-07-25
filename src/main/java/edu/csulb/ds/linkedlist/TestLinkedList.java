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
		System.out.println("\nSize of the linked list is : " + ll.size());

		testReverseOperation(ll);

		System.out.println("TESTING RECURSIVE REVERSE OPERATION :: START");
		testRecursiveReverseOperation(ll);
		System.out.println("TESTING RECURSIVE REVERSE OPERATION :: END");

		// testMoveLastToFirstOperation(ll);

		testPairwiseSwap(ll);

		System.out.println("\n3rd node from end is : " + ll.getNthNodeFromTheEnd(3).data);

		System.out.println("\nMiddle element of this linked list is : " + ll.getMiddleElement().data);

		// ll.createALoop();
		System.out.println("\nDoes loop exists in this linkedList : " + ll.doesLoopExist());

		// Below linked lists are created to test the merging of two sorted
		// linked Lists
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

		System.out.println("\nLinked List 1");
		ll1.printList();

		System.out.println("\nLinked List 2");
		ll2.printList();

		System.out.println("\nFinal sorted list");
		mergeSortedLists(ll1, ll2).printList();

		LinkedList<Character> palindromicLL = new LinkedList<Character>();
		palindromicLL.append('c');
		palindromicLL.append('a');
		// palindromicLL.append('d');
		palindromicLL.append('a');
		palindromicLL.append('c');
		
		System.out.println("\nLinked List to be checked for palindrome is : ");
		palindromicLL.printList();

		System.out.println("\nIs LinkedList Palindrome ? " + isPalindrome(palindromicLL));
		
		LinkedList<Integer> ll3 = new LinkedList<Integer>();
		ll3.append(56);
		ll3.append(34);
		ll3.append(40);
		ll3.append(17);
		ll3.append(5);
		
		System.out.println("\nOriginal Linked List");
		ll3.printList();		
		
		System.out.println("\nSorted List after Merge Sort is below");
		ll3.mergeSort();
		ll3.printList();
		
		LinkedList<Integer> ll4 = new LinkedList<Integer>();
		ll4.append(10);
		ll4.append(4);
		ll4.append(15);
		ll4.append(65);
		ll4.append(98);
		
		System.out.println();
		ll4.printList();
		System.out.println("Nth node from the end is : ");
		System.out.println(ll4.getNthNodeFromTheEnd(3).data);
	}
	
	private static LinkedList<Integer> mergeSortedLists(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		return ll1.mergeSortedLists(ll1, ll2);
	}

	private static void testPairwiseSwap(LinkedList<Integer> ll) {
		System.out.println("\nCurrent linked list is : ");
		ll.printList();

		// Reverse the list
		ll.pairwiseSwap();

		System.out.println("\nLinkedList after pairwise swapping of elements : ");
		ll.printList();
	}

	private static void testMoveLastToFirstOperation(LinkedList<Integer> ll) {

		System.out.println("\nCurrent linked list is : ");
		ll.printList();

		// Reverse the list
		ll.moveLastToFirst();

		System.out.println("\nAfter moving last element to first : ");
		ll.printList();
	}

	private static void testRecursiveReverseOperation(LinkedList<Integer> ll) {
		System.out.println("\nCurrent linked list is : ");
		ll.printList();

		// Reverse the list
		ll.recursiveReverse();

		System.out.println("\nReversed linked list is : ");
		ll.printList();
	}

	private static void testReverseOperation(LinkedList<Integer> ll) {

		System.out.println("\nCurrent linked list is : ");
		ll.printList();

		// Reverse the list
		ll.reverse();

		System.out.println("\nReversed linked list is : ");
		ll.printList();
	}

	/**
	 * 
	 * @param ll1
	 * @param ll2
	 * @return
	 */
	/*private static LinkedList<Integer> mergeSortedLists(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {
		LinkedList<Integer> ll3 = null;

		Node<Integer> n1, n2;

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
	}*/

	/**
	 * Check if a singly linkedlist is palindrome
	 * 
	 * 2 approaches :
	 * 
	 * 1. Use a stack
	 * 
	 * 2. Find the mid of the linkedlist and then reverse the linked list from
	 * the mid and now check both the halves
	 * 
	 * @return
	 */
	public static boolean isPalindrome(LinkedList<Character> ll) {

		int size = ll.size();
		Node<Character> mid = ll.getMiddleElement();

		LinkedList<Character> ll2 = new LinkedList<Character>(mid.next);

		// Reverse the second half of the linkedlist
		ll2.recursiveReverse();

		// Now traverse both the list
		Node<Character> n1 = ll.getHead();
		Node<Character> n2 = ll2.getHead();

		// If ll is of even size, then the middle element is the last element of
		// the first half.
		// which means the node next to the middle is the head of the second
		// half

		// if ll is of odd size, then the middle element is the center of the
		// palindrome
		// which means that the previous node of the middle is the last element
		// of first half
		// and next node from middle is the head of the second half
		while (n2 != null) {
			if (n1.data != n2.data)
				return false;
			n1 = n1.next;
			n2 = n2.next;
		}

		return true;
	}

	/**
	 * function to get the intersection point of two Linked Lists. There are two
	 * singly linked lists in a system. By some programming error the end node
	 * of one of the linked list got linked into the second list, forming a
	 * inverted Y shaped list. Write a program to get the point where two linked
	 * list merge.
	 * 
	 * @param ll1
	 * @param ll2
	 * @return
	 */
	public static Node<Integer> findIntersectionNode(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {

		int sizeOfList1 = ll1.size();

		int sizeOfList2 = ll2.size();

		int diff = Math.abs(sizeOfList1 - sizeOfList2);

		Node<Integer> n1 = ll1.getHead();
		Node<Integer> n2 = ll2.getHead();

		if (sizeOfList1 > sizeOfList2) {
			for (int i = 0; i < diff; i++) {
				n1 = n1.next;
			}
		}

		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}

		return n1;
	}

	/**
	 * Given two lists sorted in increasing order, create and return a new list
	 * representing the intersection of the two lists. The new list should be
	 * made with its own memory — the original lists should not be changed.
	 * 
	 * For example, let the first linked list be 1->2->3->4->6 and second linked
	 * list be 2->4->6->8, then your function should create and return a third
	 * list as 2->4->6.
	 * 
	 * NOTE : TRY TO DO IT RECURSIVELY
	 * 
	 * @param ll1
	 * @param ll2
	 */
	public static void findIntersectionOfTwoSortedLinkedLists(LinkedList<Integer> ll1, LinkedList<Integer> ll2) {

	}
}
