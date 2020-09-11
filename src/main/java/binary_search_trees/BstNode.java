package binary_search_trees;

/**
 * Class to represent node in binary search tree
 * @author Deepak Karkala
 *
 */

public class BstNode {
	int key;
	BstNode left, right, parent;
	
	BstNode(int key) {
		this.key = key;
		left = null;
		right = null;
		parent = null;
	}
}