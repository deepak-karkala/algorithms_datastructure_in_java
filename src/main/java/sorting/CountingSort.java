package sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

/*
 * Counting sort 
 */

public class CountingSort {
	
	public static <T extends Comparable<T>> List<T> countingSort(List<T> list) {
		List<T> sortedArray = new ArrayList<>(list.size());
		
		// Tree map to hold number of occurrences of each element
		Map<T, Integer> numOccurrences = new TreeMap<>();
		
		// Count number of occurrences
		list.forEach(v -> numOccurrences.put(v, numOccurrences.getOrDefault(v,0)+1));
		
		// Insert each element number of occurrences time
		for(Map.Entry<T, Integer> element : numOccurrences.entrySet()) {
			for(int i=0; i < element.getValue(); i++) {
				sortedArray.add(element.getKey());
			}
		}
		
		return sortedArray;
	}
	
	
	public static void main(String[] args) {
		List<Integer> intList = Stream.of(-5, 9, 3, 1, 4, 7, 2, 8, 6).collect(toList());
		
		List<String> charList = Stream.of("v", "d", "d", "j", "i", "o", "t", "a").collect(toList());
		List<String> sortedList = countingSort(charList);
		System.out.println(Arrays.toString(sortedList.toArray()));
	}
}
