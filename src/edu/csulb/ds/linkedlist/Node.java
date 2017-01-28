/**
 * 
 */
package edu.csulb.ds.linkedlist;

/**
 * @author Manav
 *
 */
public class Node<T> {

	T data;
	Node<T> next;

	/**
	 * 
	 */
	public Node() {
		super();
	}

	/**
	 * 
	 * @param data
	 * @param nxtNode
	 */
	public Node(T data, Node<T> nxtNode) {
		super();
		this.data = data;
		this.next = nxtNode;
	}
}