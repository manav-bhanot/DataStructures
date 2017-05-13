/**
 * 
 */
package edu.csulb.ds.trees;

/**
 * @author Manav
 *
 */
public class BinaryTree<E> {
	
	TreeNode<E> root;

	/**
	 * 
	 */
	public BinaryTree() {
		super();
	}

	/**
	 * 
	 * @param data
	 */
	public BinaryTree(E data) {
		root = new TreeNode<E>(data);
	}
	
	

}
