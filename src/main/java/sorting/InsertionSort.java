package sorting;

import java.util.Arrays;

/*
 * Insertion Sort 
 */


public class InsertionSort {
	
	/*
	 * Insertion Sort iterative implementation
	 * 
	 * @param Array
	 * @returns Sorted Array
	 */
	public static int[] insertionSortIterative(int [] array) {
		int len = array.length;
		
		for (int i = 1; i < len; i++) {
			int key = array[i];
			int j = i - 1;
			
			while ((j>=0) && (array[j] > key) ) {
				array[j+1] = array[j];
				j -= 1;
			}
			array[j+1] = key;
		}
		
		return array;
	}
	
	
	/*
	 * Insertion Sort recursive implementation
	 * 
	 * @param Array
	 * @returns Sorted Array
	 */
	public static int[] insertionSortRecursiveTop(int [] array) {
		int len = array.length;
		return insertionSortRecursive(array, len-1);
	}
	
	
	public static int[] insertionSortRecursive(int[] array, int len) {
		if (len <= 0) {
			return array;
		}
		
		// Get sorted array till len-1
		array = insertionSortRecursive(array, len-1);
		// Insert element at len into correct position
		int key = array[len];
		int idx = len - 1;
		while ((idx >= 0) && (key < array[idx])) {
			array[idx + 1] = array[idx];
			idx -= 1;
		}
		array[idx + 1] = key;
		
		return array;
	}

	
	/*
	 * Insertion Sort generic
	 * 
	 * @param Array
	 * @returns Sorted Array
	 */
	public static <T extends Comparable<T>> T[] insertionSortGeneric(T[] array) {
		
		int len = array.length;
		for (int i = 1; i < len; i++) {
			T key = array[i];
			int j = i - 1;
			int comp = key.compareTo(array[j]);

			while ((j >= 0) && (comp < 0)) {
				array[j+1] = array[j];
				j -= 1;
				
				if (j >= 0) 
					comp = key.compareTo(array[j]);
			}
			
			array[j+1] = key;
		}
		
		return array;
	}	
		
	public static void main(String[] args) {
		//int[] array = {8, 3, 7, 1, 4, 9, 5};
		//int[] result = insertionSortRecursiveTop(array);
		
		String[] array = {"d", "z", "t", "f", "a", "g", "m"};
		String[] result = insertionSortGeneric(array);

		System.out.println(Arrays.toString(result));
		
	}
}