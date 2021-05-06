package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Bucket Sort 
 */

public class BucketSort {
	
	public static <T extends Comparable<T>> T[] bucketSort(T[] array) {
		
		T maxElem = getMax(array);
		T minElem = getMin(array);
		int numBuckets = (Integer)maxElem - (Integer)minElem + 1;
		
		// Initialize buckets
		List<List<T>> buckets = new ArrayList<>(numBuckets);
		for(int i = 0; i < numBuckets; i++) {
			buckets.add(new ArrayList<>());
		}
		
		// Insert elements into buckets based on hash values
		for(T elem: array) {
			int hashValue = getHash(elem, minElem, numBuckets);
			buckets.get(hashValue).add(elem);
		}
		
		// Sort each bucket
		for(List<T> bucket: buckets) {
			Collections.sort(bucket);
		}
		
		// Concatenate all sorted buckets
		int idx = 0;
		for(List<T> bucket: buckets) {
			for(T elem: bucket) {
				array[idx++] = elem;
			}
		}
		
		return array;
	}
	
	public static <T extends Comparable<T>> int getHash(T elem, T minElem, int numBuckets) {
		return ((Integer)elem - (Integer)minElem) / numBuckets;
	}
	
	public static <T extends Comparable<T>> T getMax(T[] array) {
		T maxElem = array[0];
		for(T elem: array) {
			if (elem.compareTo(maxElem) > 0)
				maxElem = elem;
		}
		return maxElem;
	}
	
	public static <T extends Comparable<T>> T getMin(T[] array) {
		T minElem = array[0];
		for(T elem: array) {
			if (elem.compareTo(minElem) < 0)
				minElem = elem;
		}
		return minElem;
	}
	
	public static void main(String[] args) {
		Integer[] intArray = {5, 9, 3, 1, 5, 4, 7, 2, 8, 6};
		Integer[] sortedArray = bucketSort(intArray);
		System.out.println(Arrays.toString(sortedArray));
	}
}
