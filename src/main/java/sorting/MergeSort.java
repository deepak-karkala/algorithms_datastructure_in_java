package sorting;

import java.util.Arrays;

/*
 * Merge Sort
*/

public class MergeSort {
	
	public static <T extends Comparable<T>> T[] mergeSortGeneric(T[] array) {
		mergeSort(array, 0, array.length-1);
		return array;
	}
	
	public static <T extends Comparable<T>> void mergeSort(T[] array, int low, int high) {
		
		int mid = low + (high - low) / 2;
		if (low < high) {
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			merge(array, low, mid, high);
		}
		
	}
	
	public static <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high) {
		int len = high - low + 1;
		T[] temp = (T[]) new Comparable[len];
		
		int i = low;
		int j = mid + 1;
		int k = 0;
		
		while( (i <= mid) && (j <= high) ) {
			if (array[i].compareTo(array[j]) >= 0) {
				temp[k++] = array[j++];
			} else {
				temp[k++] = array[i++];
			}
		}
		
		while (i <= mid) {
			temp[k++] = array[i++];
		}
		
		while (j <= high) {
			temp[k++] = array[j++];
		}
		
		System.arraycopy(temp, 0, array, low, len);
		return;
		
	}
	
	public static void main(String[] args) {
		String[] array = {"d", "z", "t", "f", "a", "g", "m"};
		String[] result = mergeSortGeneric(array);
		System.out.println(Arrays.toString(result));
	}
	
	
}
