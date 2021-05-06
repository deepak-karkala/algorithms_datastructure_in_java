package sorting;

import java.util.Arrays;

/*
 * Quick Sort Generic 
 */

public class QuickSort {
	
	public static <T extends Comparable<T>> T[] quickSortGeneric(T[] array) {
		quickSort(array, 0, array.length-1);
		return array;
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			quickSort(array, low, pivotIndex-1);
			quickSort(array, pivotIndex, high);
		}
	}
	
	public static <T extends Comparable<T>> int partition(T[] array, int low, int high) {
		int randomIndex = low + (int) (Math.random() * (high - low + 1));
	    T temp = array[high];
	    array[high] = array[randomIndex];
	    array[randomIndex] = temp;

	    
	    int mid = (low + high) >>> 1;
		
		while (low <= high) {
			while (array[low].compareTo(array[mid]) < 0) {
				++low;
			}
			while (array[mid].compareTo(array[high]) < 0) {
				--high;
			}
			
			// Swap elements at low and high
			if (low <= high) {
				temp = array[low];
				array[low] = array[high];
				array[high] = temp;
				
				++low;
				--high;
			}
		}
		return low;
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {5, 9, 3, 1, 4, 7, 2, 8, 6};
		String[] stringArray = {"v", "d", "d", "j", "i", "o", "t", "a"};
		
		Integer[] result = quickSortGeneric(intArray);
		System.out.println(Arrays.toString(result));
		
	}
}
