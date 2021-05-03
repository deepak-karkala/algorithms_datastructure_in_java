package searching;

import org.junit.Assert;
import org.junit.Test;
 

public class BinarySearchTest {

	
	@Test
	public void leftBoundNotFound() {
		int[] sortedArray = {2, 5, 7, 8, 12, 17};
		int key = 9;
		Assert.assertEquals(-1, BinarySearch.binarySearchIterative(sortedArray, key));
	}
	
	@Test
	public void RightBoundNotFound() {
		int[] sortedArray = {2, 5, 7, 8, 12, 17};
		int key = 19;
		Assert.assertEquals(-1, BinarySearch.binarySearchIterative(sortedArray, key));
	}
	
	@Test
	public void foundinLeftHalf() {
		int[] sortedArray = {2, 5, 7, 8, 12, 17};
		int key = 7;
		Assert.assertEquals(2, BinarySearch.binarySearchIterative(sortedArray, key));
	}
	
	@Test
	public void foundinRightHalf() {
		int[] sortedArray = {2, 5, 7, 8, 12, 17};
		int key = 12;
		Assert.assertEquals(4, BinarySearch.binarySearchIterative(sortedArray, key));
	}
	
	@Test
	public void foundinMiddle() {
		int[] sortedArray = {2, 5, 7, 8, 9, 12, 17};
		int key = 8;
		Assert.assertEquals(3, BinarySearch.binarySearchIterative(sortedArray, key));
	}
	
	@Test
	public void foundinMiddlerecursive() {
		int[] sortedArray = {2, 5, 7, 8, 9, 12, 17};
		int key = 8;
		Assert.assertEquals(3, BinarySearch.binarySearchRecursiveTop(sortedArray, key));
	}

}
