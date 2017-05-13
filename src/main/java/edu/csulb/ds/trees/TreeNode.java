/**
 * 
 */
package edu.csulb.ds.trees;

/**
 * @author Manav
 *
 */
public class TreeNode<E> {
	
	E value;
	
	TreeNode<E> left;
	TreeNode<E> right;

	/**
	 * 
	 */
	public TreeNode() {
		super();
	}

	public TreeNode(E value) {
		super();
		this.value = value;
	}
	
}
