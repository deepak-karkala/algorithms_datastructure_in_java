package sorting;

import java.util.Arrays;

/*
 * Bubble Sort generic
 */

public class BubbleSort {
	
	public static <T extends Comparable<T>> T[] bubbleSort(T[] array) {
		int len = array.length;
		
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - 1 - i; j++) {
				if (array[j].compareTo(array[j+1]) > 0) {
					T temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		//Integer[] array = {8, 3, 7, 1, 4, 9, 5};
		//Integer[] result = bubbleSort(array);
		
		String[] array = {"d", "z", "t", "f", "a", "g", "m"};
		String[] result = bubbleSort(array);

		System.out.println(Arrays.toString(result));
		
	}
	
}