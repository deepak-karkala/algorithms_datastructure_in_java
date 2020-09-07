package heaps;

import java.util.Arrays;
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
	int[] heap;
	int heapSize;
	int maxSize;
	
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
	public void swap(int pos1, int pos2) {
		pos1--;
		pos2--;
		int temp = heap[pos2];
		heap[pos2] = heap[pos1];
		heap[pos1] = temp;
	}
	
	/*
	 * Check if node is a leaf
	 */
	public boolean isLeaf(int pos) {
		if ((pos >= Math.floorDiv(heapSize, 2)+1) && (pos <= heapSize)) {
			return true;
		}
		return false;
	}
	
	/*
	 * Swaps elements to create min heap at given node
	 */
	public void minHeapify(int pos) {
		int left = getLeftChild(pos);
		int right = getRightChild(pos);
		int smallest = pos;
		
		
		//System.out.println(left);
		if ((left <= heapSize) && (heap[left-1] < heap[pos-1])) {
			smallest = left;
		}
		
		if ((right <= heapSize) && (heap[right-1] < heap[smallest-1])) {
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
	public void buildMinHeap() {
		int pos = Math.floorDiv(heapSize, 2);
		while (pos >= 1) {
			minHeapify(pos--);
		}
	}
	
	
	/*
	 * Heapsort algorithm
	 */
	public void sortHeap() {
		int temp = heapSize;
		buildMinHeap();
		while(heapSize >= 2) {
			swap(1, heapSize);
			heapSize--;
			minHeapify(1);
		}
		heapSize = temp;
		
	}
	
	/*
	 * Return minimum
	 */
	public int getMin() {
		return heap[0];
	}
	
	/*
	 * Extract minimum, return and remove minimum from heap
	 */
	public int extractMin() {
		if (heapSize < 1) {
			throw new EmptyStackException();
		}
		int min = getMin();
		swap(1, heapSize);
		heapSize--;
		minHeapify(1);
		return min;
	}
	
	/*
	 * Insert new element 
	 */
	public void insert(int key) {
		heapSize++;
		heap[heapSize-1] = key;
		int i = heapSize;
		int iParent = getParent(i);
		while ((i>1) && (heap[iParent] > heap[i])) {
			swap(i, iParent);
			i = iParent;
			iParent = getParent(i);
		}
	}
	

	public static void main(String[] args) {
		int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
		
	}
	
}