package searching;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinarySearch {
	
	public static int binarySearchIterative(int[] sortedArray, int key) {
		int low = 0, high = sortedArray.length-1;
		
		while (low <= high) {
			int mid = low + (high-low)/2;

			if (sortedArray[mid] == key) {
				return mid;
			} else if (key > sortedArray[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static int binarySearchRecursiveTop(int[] sortedArray, int key) {
		int low = 0, high = sortedArray.length-1;
		return binarySearchRecursive(sortedArray, key, low, high);
	}
	
	public static int binarySearchRecursive(int[] sortedArray, int key, int low, int high) {
		int mid = low + (high-low)/2;
		
		if (low > high) {
			return -1;
		}
		
		if (sortedArray[mid] == key) {
			return mid;
		} else if (key > sortedArray[mid]) {
			return binarySearchRecursive(sortedArray, key, mid+1, high);
		} else {
			return binarySearchRecursive(sortedArray, key, low, mid-1);
		}
	}

	
	public static <T extends Comparable<T>> int binarySearchGeneric(T[] sortedArray, T key) {
		int low = 0, high = sortedArray.length-1;
		
		
		while (low <= high) {
			int mid = (low + high) >>> 1;
			
			int comp = key.compareTo(sortedArray[mid]);
			if (comp == 0) {
				return mid;
			} else if (comp < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] sortedArray = {2, 5, 7, 8, 9, 12, 17};
		int key = 8;
		System.out.println(binarySearchIterative(sortedArray, key));
		System.out.println(binarySearchRecursiveTop(sortedArray, key));
		
		String[] sortedGenericArray = {"a", "b", "e", "g", "t", "w"};
		String toSearch = "d";
		System.out.println(binarySearchGeneric(sortedGenericArray, toSearch));
		
		List<Integer> range = IntStream.rangeClosed(0, 10)
			    .boxed().collect(Collectors.toList());
		
		// Generate random data
		Random r = ThreadLocalRandom.current();
		int size = 1000;
		int maxElement = 10^6;
		Integer[] integers = IntStream.generate(() -> r.nextInt(maxElement))
									.limit(size)
									.sorted()
									.boxed()
									.toArray(Integer[]::new);
		System.out.println(integers[1]);
	}
}