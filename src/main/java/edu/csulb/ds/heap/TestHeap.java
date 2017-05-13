/**
 * 
 */
package edu.csulb.ds.heap;

/**
 * @author Manav
 *
 */
public class TestHeap {
	
	MinHeap minHeap;
	
	int[] arr;
	
	public static void main(String[] args) {
		
		TestHeap obj = new TestHeap();
		
		obj.arr = new int[] {13, 6, 11, 9, 10, 3, 1, 15, 8, 2};
		
		obj.buildMinHeap();	
	}

	private void buildMinHeap() {
		minHeap = new MinHeap(arr, arr.length);
		
		minHeap.printHeap();
		
		minHeap.insert(4);
		minHeap.insert(5);
		minHeap.insert(7);
		
		minHeap.printHeap();
		
		System.out.println(minHeap.extractMin());
		
		minHeap.printHeap();
	}
	
	

}
