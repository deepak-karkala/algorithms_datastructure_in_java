package heaps;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * Junit class to test Min Heaps 
 *
*/
public class MinHeapTest {
	MinHeap Heap = new MinHeap(10);

	@Before
	public void setup() throws Exception {	
	}
	
	@Test
	public void testHeapSizeOnInit() {
		assertTrue(Heap.heapSize == 0);
	}
	
	@Test
	public void testInsert() {
		Heap.insert(4);
		assertTrue(Heap.heap[0] == 4);
		Heap.insert(1);
		int[] expected = {1,4};
		int[] result = Arrays.copyOfRange(Heap.heap, 0, 2);
		//System.out.println(Arrays.toString(result));
		Assert.assertArrayEquals(expected, result);
	}
	
	@Test
	public void testSortHeap() {
		Heap.heap = new int[] {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		Heap.heapSize = Heap.heap.length;
		//System.out.println(Arrays.toString(Heap.heap));
		Heap.sortHeap();
		//System.out.println(Arrays.toString(Heap.heap));
		int[] expecteds = {16, 14, 10, 9, 8, 7, 4, 3, 2, 1};
		Assert.assertArrayEquals(expecteds, Heap.heap);
	}
}