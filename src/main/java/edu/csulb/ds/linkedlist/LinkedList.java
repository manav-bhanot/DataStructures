/**
 * 
 */
package edu.csulb.ds.linkedlist;

/**
 * @author Manav
 *
 */
public class LinkedList<T extends Comparable<? super T>> {

	// head node of the linked list which is the first node of the list
	private Node<T> head;

	// Subsequent nodes of the linked list
	private Node<T> node;

	/**
	 * 
	 */
	public LinkedList() {
		super();
	}

	/**
	 * creates a new linked list having only the head node
	 * 
	 * @param data
	 */
	public LinkedList(T data) {
		head = new Node<T>();
		head.data = data;
	}	

	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}

	/**
	 * Returns the last element of this linkedlist. Iterates through all the
	 * elements.
	 * 
	 * Runtime complexity : O(n)
	 * 
	 * @return
	 */
	private Node<T> tail() {
		this.node = this.head;

		// While loop terminates at the last node
		// Thus by the time the loop reaches the last node, it is pointing to
		// null
		// Thus this.node will contain the pointer to the last node.
		while (this.node.next != null) {
			this.node = this.node.next;
		}

		return this.node;
	}

	/**
	 * Adds a new node with the data specified at the end of the linked list If
	 * it is a newly created linkedlist, then inserts the data in the head node
	 * Otherwise goes to the end of the list and inserts the data at the end
	 * 
	 * Time Complexity : O(n)
	 * 
	 * @param data
	 */
	public void append(T data) {
		if (data == null) {
			System.out.println("Cannot insert null value into the node");
		} else if (this.head == null) {
			this.head = new Node<T>(data);
		} else {
			Node<T> n = new Node<T>(data, null);
			tail().next = n;
		}
	}

	/**
	 * Adds a new node with the data specified at the beginning of the
	 * LinkedList Time Complexity : O(1)
	 * 
	 * @param data
	 */
	public void push(T data) {
		if (data == null) {
			System.out.println("Cannot insert null value into the node");
		} else {
			node = new Node<T>(data, null);
			node.next = head.next;
			head = node;
		}
	}

	/**
	 * 
	 * @param data
	 * @param n
	 */
	private void insertAfter(T data, Node<T> n) {

	}

	/**
	 * Prints the data elements of the list Time Complexity : O(n)
	 */
	public void printList() {
		if (head == null) {
			System.out.println("The list is empty");
		} else {
			node = head;
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}
		System.out.println();
	}

	/**
	 * Deletes the node of the linked list with the given data Takes O(n) times
	 * as the whole list might have to be traversed
	 * 
	 * Runtime complexity : O(n)
	 * 
	 * @param key
	 */
	public void deleteNode(T key) {

	}

	/**
	 * Deletes the node of the linked list. Accepts the pointer to the node
	 * object that must be deleted
	 * 
	 * Runtime complexity : O(n)
	 * 
	 * @param node
	 */
	public void deleteNode(Node<T> node) {
		if (node == null) {
			System.out.println("Cannot delete null nodes");
			return;
		}

		// Checks if this is the head node
		if (head.data.equals(node.data) || head == node) {
			head = head.next;
			return;
		}

		this.node = head;
		Node<T> prevNode = null;
		while (this.node != null && this.node != node && !(this.node.data.equals(node.data))) {
			prevNode = this.node;
			this.node = this.node.next;
		}

		if (this.node == null) {
			System.out.println("The node is not present in the linked list");
			return;
		}

		// Deletes the node
		prevNode.next = this.node.next;
	}

	/**
	 * Deletes the node of a linked list at the given position pos
	 * 
	 * @param pos
	 */
	public void deleteNode(int pos) {

	}

	/**
	 * A recursive implementation of finding the size/length of the linkedlist
	 * 
	 * @return
	 */
	public int size() {
		return size(this.head);
	}

	/**
	 * Recursive implementation to find the size of the node
	 * 
	 * @param node
	 * @return
	 */
	private int size(Node<T> node) {
		if (node == null)
			return 0;
		return 1 + size(node.next);
	}

	/**
	 * Returns false if there are no elements inserted into the linked list
	 * otherwise returns true
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	/**
	 * A recursive implementation of finding a particular element in the linked
	 * list Returns true if the particular element is found.
	 * 
	 * @param element
	 * @return
	 */
	public boolean contains(T element) {
		return contains(element, head);
	}

	/**
	 * A helper method that is used by the contains method to check the presence
	 * of an element in the linked list
	 * 
	 * @param element
	 * @param node
	 * @return
	 */
	private boolean contains(T element, Node<T> node) {
		if (node == null)
			return false;
		if (node.data.equals(element))
			return true;
		return contains(element, node.next);
	}

	/**
	 * Iterates through the LinkedList and finds the node
	 * 
	 * @param element
	 * @return
	 */
	private Node<T> findNode(T element) {
		if (node == null)
			return null;
		if (node.data.equals(element))
			return node;
		node = node.next;
		return findNode(element);
	}

	/**
	 * Use case : Given two data elements. Swap their positions in the linked
	 * list Basically checks if both of them exists in the linkedlist If yes,
	 * swap the two nodes with these data items
	 * 
	 * It will check for the first occurrence of both x and y
	 * 
	 * Examples :
	 * 
	 * Input: 10->15->12->13->20->14, x = 12, y = 20
	 * 
	 * Output: 10->15->20->13->12->14
	 * 
	 * Input: 10->15->12->13->20->14, x = 10, y = 20
	 * 
	 * Output: 20->15->12->13->10->14
	 * 
	 * Input: 10->15->12->13->20->14, x = 12, y = 13
	 * 
	 * Output: 10->15->13->12->20->14
	 * 
	 * Runtime Complexity : O(n)
	 * 
	 * @param element1
	 * @param element2
	 */
	public void swap(T x, T y) {

		Node<T> n1 = null, n2 = null, prevN1 = null, prevN2 = null, n = head;
		prevN1 = n;
		prevN2 = n;

		// Check if both x and y are equal. Then no need to swap
		if (x.equals(y))
			return;

		while ((n1 == null || n2 == null) && n != null) {
			if (n1 == null && n.data.equals(x)) {
				n1 = n;
			} else if (n2 == null && n.data.equals(y)) {
				n2 = n;
			}
			if (n1 == null)
				prevN1 = n;
			if (n2 == null)
				prevN2 = n;
			n = n.next;
		}

		// No need to swap if we are unable to find even of the given data items
		if (n1 == null || n2 == null)
			return;

		// Now we have got the nodes. We need to swap them
		// Swap n1 and n2
		prevN2.next = n1;
		prevN1.next = n2;

		n = n1.next;
		n1.next = n2.next;
		n2.next = n;

		// Modifying the head if any of the x and y are equal to head.data
		if (head.data.equals(x))
			head = n2;
		if (head.data.equals(y))
			head = n1;
	}

	/**
	 * Returns the object saved at the nth node of the linked list Provide the
	 * 0-based index of the node
	 * 
	 * If n exceeds the length of the linked list, it returns null
	 * 
	 * Time Complexity : O(n)
	 * 
	 * @param n
	 * @return
	 */
	public Node<T> getNthNode(int n) {
		int count = 0;

		Node<T> node = head;

		while (node != null && count < n) {
			node = node.next;
			count++;
		}

		return node != null ? node : null;
	}

	/**
	 * Given a singly linked list, find middle of the linked list. For example,
	 * if given linked list is 1->2->3->4->5 then output should be 3.
	 * 
	 * If there are even nodes, then there would be two middle nodes, we need to
	 * print second middle element. For example, if given linked list is
	 * 1->2->3->4->5->6 then output should be 4.
	 * 
	 * Approach used : Initialize mid element as head and initialize a counter
	 * as 0. Traverse the list from head, while traversing increment the counter
	 * and change mid to mid->next whenever the counter is odd. So the mid will
	 * move only half of the total length of the list.
	 * 
	 * Time Complexity : O(n)
	 * 
	 * @return
	 */
	public Node<T> getMiddleElement() {
		int counter = 0;
		Node<T> mid = head, n = head;

		while (n != null) {
			if (counter % 2 != 0)
				mid = mid.next;
			n = n.next;
			counter++;
		}
		return mid;
	}

	/**
	 * Returns the nth node object from the end of the linked list. Used the
	 * 2-pointers approach
	 * 
	 * Intuitive insight : nth node from the end is the len/size - n + 1 node
	 * from the beginning.
	 * 
	 * eg. 10 -> 4 -> 15 -> 65 -> 98. Then 2nd node from the end is 65 which is
	 * actually 4th node from the beginning len/size = 5. This 5 - 2 + 1 = 4
	 * 
	 * Runtime complexity : O(n)
	 * 
	 * @param n
	 * @return
	 */
	public Node<T> getNthNodeFromTheEnd(int n) {
		Node<T> n1 = this.head;
		Node<T> n2 = this.head;

		int count = 1;

		while (n1 != null) {
			if (count > n) {
				n2 = n2.next;
			}
			count++;
			n1 = n1.next;
		}

		return n2;
	}

	/**
	 * Deletes the linked list and frees up the memory. Basically in Java, GC
	 * will collect all the null objects from the heap and the user need not to
	 * worry about freeing up the memory space
	 */
	public void delete() {
		this.head = null;
	}

	/**
	 * Reverses the linked list iteratively Basically makes the last element as
	 * the head of the linked list and the first element as the tail of the
	 * linked list.
	 * 
	 * Runtime complexity : O(n)
	 */
	public void reverse() {
		Node<T> currentNode, nextNode, previousNode;

		previousNode = null;
		currentNode = this.head;
		nextNode = null;

		while (currentNode != null) {

			nextNode = currentNode.next;

			currentNode.next = previousNode;

			previousNode = currentNode;
			currentNode = nextNode;
		}

		// Since by this point of time the currentNode is pointing to null
		// (currentNode = nextNode and nextNode = null for last node)
		// And previousNode must be pointing to the lastNode of the original
		// linkedlist.
		// So change the head pointer to point to the previousNode.
		this.head = previousNode;
	}

	public void recursiveReverse() {
		// reverseListRecursively(this.head);
		reverseUtil(this.head, null);
	}

	/**
	 * A simple and tail recursive method (courtesy : GeeksForGeeks)
	 * 
	 * @param currentNode
	 * @param previousNode
	 */
	private void reverseUtil(Node<T> currentNode, Node<T> previousNode) {

		if (currentNode.next == null) {
			this.head = currentNode;
			this.head.next = previousNode;
			return;
		}

		Node<T> nextNode = currentNode.next;
		currentNode.next = previousNode;

		reverseUtil(nextNode, currentNode);
	}

	/**
	 * A recursive approach to reverse the linked list Below is the algorithm
	 * 
	 * 1. Divide the list into two parts - first node and the rest of the list
	 * 
	 * 2. Call reverse for the rest of the list
	 * 
	 * 3. Link rest to first
	 * 
	 * 4. Fix the head pointer
	 */
	private void reverseListRecursively(Node<T> head) {
		// Because the head is null. So just return
		if (this.head == null) {
			return;
		}

		Node<T> firstNode = null;
		Node<T> restOfLL = null;

		firstNode = head;
		restOfLL = head.next;

		if (restOfLL == null) {
			return;
		}

		reverseListRecursively(restOfLL);

		firstNode.next.next = firstNode;
		firstNode.next = null;
		// this.head = restOfLL;

		if (restOfLL.next == null) {
			this.head = restOfLL;
		}
		restOfLL.next = firstNode;
	}

	/**
	 * Returns true if there is a loop present in the linkedlist.
	 * 
	 * This is an implementation of Floyd's Cycle Finding Algorithm which is
	 * stated as below. It is the fastest method
	 * 
	 * Traverse linked list using two pointers. Move one pointer by one and
	 * other pointer by two. If these pointers meet at some node then there is a
	 * loop. If pointers do not meet then linked list doesn�t have loop.
	 * 
	 * Runtime complexity : O(n)
	 * 
	 * Space complexity : <No space complexity>
	 * 
	 * @return
	 */
	public boolean doesLoopExist() {

		Node<T> slowPointer = this.head;
		Node<T> fastPointer = this.head;

		while (slowPointer != null && fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;

			if (slowPointer.equals(fastPointer)) {
				return true;
			}
		}
		return false;
	}

	public void createALoop() {
		tail().next = this.head;
	}
	
	private static void mergeTwoSortedLinkedLists(LinkedList ll1, LinkedList ll2) {
	}

}
