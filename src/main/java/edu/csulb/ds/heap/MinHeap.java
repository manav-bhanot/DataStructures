/**
 * 
 */
package edu.csulb.ds.heap;

/**
 * @author Manav
 *
 */
public class MinHeap<T> {

	private int size;
	private int[] elements;

	/**
	 * Default Constructor
	 */
	public MinHeap() {
	}

	/**
	 * Accepts as input the list of elements out of which a min heap is created
	 * The elements are nothing but instance of the HeapNodes
	 * 
	 * @param heapNodes
	 * @param size
	 */
	public MinHeap(HeapNode<T>[] heapNodes, int size) {
		this.size = size;
	}

	public MinHeap(int[] elements, int size) {

		this.size = size;
		this.elements = elements;

		int index = (size - 1) / 2;

		while (index >= 0) {
			MinHeapify(index);
			index--;
		}
	}

	/**
	 * Heapify the elements of an heap of integers
	 * 
	 * @param arr
	 * @param i
	 */
	private void MinHeapify(int i) {

		int l = 2 * i + 1;
		int r = 2 * i + 2;

		// Set the smallest value to the index of the root element
		int smallest = i;

		if (l < this.size && elements[smallest] > elements[l]) {
			smallest = l;
		}
		if (r < this.size && elements[smallest] > elements[r]) {
			smallest = r;
		}

		if (smallest != i) {
			// Swap the smallest element with the root element
			elements[i] = elements[i] ^ elements[smallest];
			elements[smallest] = elements[i] ^ elements[smallest];
			elements[i] = elements[i] ^ elements[smallest];

			// Again heapify the elements below smallest index now
			MinHeapify(smallest);

		}
	}

	/**
	 * Returns the minimum element of the heap
	 * 
	 * @return
	 */
	public int getMin() {
		return this.elements[0];
	}

	/**
	 * Removes the top element from the heap and heapify the rest of the
	 * elements
	 * 
	 * @return
	 */
	public int extractMin() {

		// Stores the root element in the minElement variable
		int minElement = this.elements[0];

		// Decreases the size of the heap by 1
		this.size--;
		
		int[] tempArray = new int[this.size];		
		System.arraycopy(this.elements, 1, tempArray, 0, this.size);		
		this.elements = tempArray;		
		
		//System.arraycopy(this.elements, 1, this.elements, 0, this.size);

		int index = (this.size - 1) / 2;

		while (index >= 0) {
			MinHeapify(index);
			index--;
		}

		return minElement;
	}
	

	public void insert(int element) {
		
		int[] tempArray = new int[this.size + 1];		
		System.arraycopy(this.elements, 0, tempArray, 0, this.size);		
		this.elements = tempArray;
		
		this.size++;
		
		this.elements[this.size - 1] = element;
		
		int index = (this.size - 1) / 2;

		while (index >= 0) {
			MinHeapify(index);
			index--;
		}
	}
	
	public void printHeap() {
		
		for (int e : elements) {
			System.out.print(" " + e);
		}
		
		System.out.println();
	}
}
