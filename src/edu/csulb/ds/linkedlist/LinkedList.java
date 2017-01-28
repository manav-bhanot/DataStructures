/**
 * 
 */
package edu.csulb.ds.linkedlist;

/**
 * @author Manav
 *
 */
public class LinkedList<T> {

	// head node of the linked list which is the first node of the list
	private Node<T> head;

	// Subsequent nodes of the linked list
	private Node<T> node;

	/**
	 * 
	 */
	public LinkedList() {
		super();
		head = new Node<T>();
	}

	/**
	 * creates a new linked list having only the head node
	 * 
	 * @param data
	 */
	public LinkedList(T data) {
		this();
		head.data = data;
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
		} else if (head.data == null) {
			head.data = data;
		} else if (head.next == null) {
			node = new Node<T>(data, null);
			head.next = node;
		} else {
			Node<T> n = new Node<T>(data, null);
			node = head;
			while (node.next != null)
				node = node.next;
			node.next = n;
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
	public void insertAfter(T data, Node<T> n) {

	}

	/**
	 * Prints the data elements of the list Time Complexity : O(n)
	 */
	public void printList() {
		if (head == null) {
			System.out.println("The list is empty");
		} else {
			node = head;
			while (node.next != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}
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
		return size(head);
	}

	private int size(Node<T> node) {
		if (node == null)
			return 0;
		return 1 + size(node.next);
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
	 * Use case : Given two data elements. Swap their positions in the linked
	 * list Basically checks if both of them exists in the linkedlist If yes,
	 * swap the two nodes with these data items
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

	}

}
