package heaps;

import java.util.EmptyStackException;
/**
 * <code>MinHeap</code> implements Minimum Heap data-structure
 * supports following, <code>minHeapify</code>, <code>buildMinHeap</code>,
 * <code>heapSort</code>, <code>insert</code>, <code>maximum</code>,
 * <code>extractMAx</code>, <code>decreaseKey</code>
 * 
 * @author Deepak Karkala
 */


public class MinHeap {
	private int[] heap;
	private int heapSize;
	private int maxSize;
	
	/*
	 * Constructor, creates empty heap
	 */
	public MinHeap(int maxSize) {
		this.maxSize = maxSize;
		heapSize = 0;
		heap = new int[this.maxSize];
	}

	/*
	 * Get parent
	 */
	private int getParent(int pos) {
		return Math.floorDiv(pos, 2);
	}
	
	/*
	 * Get left child
	 */
	private int getLeftChild(int pos) {
		return 2*pos;
	}
	
	/*
	 * Get right child
	 */
	private int getRightChild(int pos) {
		return 2*pos+1;
	}
	
	/*
	 * Swap two elements in heap
	 */
	private void swap(int pos1, int pos2) {
		int temp = heap[pos2];
		heap[pos2] = heap[pos1];
		heap[pos1] = temp;
	}
	
	/*
	 * Check if node is a leaf
	 */
	private boolean isLeaf(int pos) {
		if ((pos >= Math.floorDiv(heapSize, 2)+1) && (pos <= heapSize)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Swaps elements to create min heap at given node
	 */
	private void minHeapify(int pos) {
		int left = getLeftChild(pos);
		int right = getRightChild(pos);
		int smallest = pos;
		
		if ((left < heapSize) && (heap[left] < heap[pos])) {
			smallest = left;
		}
		
		if ((right < heapSize) && (heap[right] < heap[smallest])) {
			smallest = right;
		}
		
		if (smallest != pos) {
			swap(pos, smallest);
			minHeapify(smallest);
		}
	}
	
	/*
	 * Build min heap
	 */
	private void buildMinHeap() {
		int pos = Math.floorDiv(heapSize, 2);
		while (pos >= 0) {
			minHeapify(pos--);
		}
	}
	
	
	/*
	 * Heapsort algorithm
	 */
	private void sortHeap() {
		int temp = heapSize;
		buildMinHeap();
		while(heapSize >= 0) {
			swap(0, heapSize);
			heapSize--;
			minHeapify(0);
		}
		heapSize = temp;
	}
	
	/*
	 * Return minimum
	 */
	private int getMin() {
		return heap[0];
	}
	
	/*
	 * Extract minimum, return and remove minimum from heap
	 */
	private int extractMin() {
		if (heapSize < 1) {
			throw new EmptyStackException();
		}
		int min = getMin();
		swap(0, heapSize-1);
		heapSize--;
		minHeapify(0);
		return min;
	}
	
	/*
	 * Insert new element 
	 */
	private void insert(int key) {
		heapSize++;
		heap[heapSize-1] = key;
		int i = heapSize-1;
		int iParent = getParent(i);
		while ((i>0) && (heap[iParent] > heap[i])) {
			swap(i, iParent);
			i = iParent;
			iParent = getParent(i);
		}
	}
	

	public static void main(String[] args) {
		int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		
	}
	
}