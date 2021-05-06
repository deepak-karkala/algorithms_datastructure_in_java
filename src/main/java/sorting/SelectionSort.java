package sorting;

import java.util.Arrays;

/*
 * Selection Sort
*/


public class SelectionSort {
	public static <T extends Comparable<T>> T[] selectionSort(T[] array) {
		int len = array.length;

		for (int i = 0; i < len; i++) {
			int minIdx = i;
			
			for (int j = i + 1; j < len; j++) {
				if (array[j].compareTo(array[minIdx]) < 0) {
					minIdx = j;
				}
			}
			
			swap(array, i, minIdx);
		}
		
		return array;
	}
	
	public static void swap(Object[] a, int i, int j) {
		Object o = a[i];
		a[i] = a[j];
		a[j] = o;
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {5, 9, 3, 1, 4, 7, 2, 8, 6};
		String[] stringArray = {"v", "d", "d", "j", "i", "o", "t", "a"};
		
		String[] result = selectionSort(stringArray);
		System.out.println(Arrays.toString(result));
		
	}
}