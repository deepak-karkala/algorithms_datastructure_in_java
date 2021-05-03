package searching;

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

	public static void main(String[] args) {
		int[] sortedArray = {2, 5, 7, 8, 9, 12, 17};
		int key = 8;
		System.out.println(binarySearchIterative(sortedArray, key));
		System.out.println(binarySearchRecursiveTop(sortedArray, key));
	}
}