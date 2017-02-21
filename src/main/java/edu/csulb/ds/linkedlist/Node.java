/**
 * 
 */
package edu.csulb.ds.linkedlist;

/**
 * @author Manav
 *
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

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
	 */
	public Node(T data) {
		this.data = data;
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

	@Override
	public int compareTo(Node<T> o) {
		// TODO Auto-generated method stub
		return this.data.compareTo(o.data);
	}
}
