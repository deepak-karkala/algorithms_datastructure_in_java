package sorting;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

	@Test
	public void basictest() {
		int[] array = {8, 3, 6, 2, 9, 5, 1};
		int[] expecteds = {1, 2, 3, 5, 6, 8, 9};
		int[] actuals = InsertionSort.insertionSortRecursiveTop(array);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void emptyArray() {
		int[] array = {};
		int[] expecteds = {};
		int[] actuals = InsertionSort.insertionSortRecursiveTop(array);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void singleElementArray() {
		int[] array = {3};
		int[] expecteds = {3};
		int[] actuals = InsertionSort.insertionSortRecursiveTop(array);
		Assert.assertArrayEquals(expecteds, actuals);
	}
	
	@Test
	public void repeatedElementArray() {
		int[] array = {8, 3, 6, 2, 9, 5, 1, 3};
		int[] expecteds = {1, 2, 3, 3, 5, 6, 8, 9};
		int[] actuals = InsertionSort.insertionSortRecursiveTop(array);
		Assert.assertArrayEquals(expecteds, actuals);
	}

}
