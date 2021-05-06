package sorting;

import java.util.Arrays;

/*
 * Radix sort 
 */

public class RadixSort {
	
	public static int[] radixSort(int[] array) {
		//Find maximum element
		//Number of significant bits (number of times counting sort should be invoked)
		int maxElem = array[0];
		int len = array.length;
		for(int i = 0; i < len; i++) {
			if (array[i] > maxElem)
				maxElem = array[i];
		}
		
		//Call counting sort for each significant digit (from LSB to MSB)
		for (int exp = 1; maxElem/exp > 0; exp*=10) {
			countingSort(array, exp);
		}
		
		return array;
	}
	
	
	public static void countingSort(int[] array, int exp) {
		int n = array.length;
		int[] sortedArray = new int[n];
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		// Count number of occurrences at particular bit (exp)
		for(int i = 0; i < n; i++) count[ (array[i]/exp) % 10 ]++;
		
		// Get cumulative count at each position
		for(int i = 1; i < 10; i++) count[i] += count[i-1];
		
		// Assign elements to correct position
		for(int i = n-1; i >= 0; i--) {
			sortedArray[ count[ (array[i]/exp)%10 ] - 1 ] = array[i];
			count[ (array[i]/exp)%10 ]--;
		}
		
		System.arraycopy(sortedArray, 0, array, 0, n);
	
	}
	
	
	public static void main(String[] args) {
		int[] intArray = {5, 9, 3, 1, 5, 4, 7, 2, 8, 6};
		int[] sortedArray = radixSort(intArray);
		System.out.println(Arrays.toString(sortedArray));
	}
}