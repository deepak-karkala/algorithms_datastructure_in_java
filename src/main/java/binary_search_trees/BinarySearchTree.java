package binary_search_trees;

/**
 * 
 * Class to support Binary search tree operations
 * 		Traversals: Inorder, preorder, postorder
 * 		Search, Insertion, Maximum, Minimum,
 * 		Predecessor, Successor
 * @author Deepak Karkala
 */

public class BinarySearchTree {
	/*
	 * Root node of the tree
	 */
	public BstNode root;
	
	BinarySearchTree() {
		root = null;
	}
	
	BinarySearchTree(int[] arr) {
		int len = arr.length;
		root = sortedArrayToBst(arr, 0, len-1);
	}
	
	/*
	 * Builds BST from sorted array
	 * Recursively dividing the array into two parts and
	 * assigning to left and right subtrees
	 */
	public BstNode sortedArrayToBst(int[] arr, int start, int end) {
		
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		BstNode root = new BstNode(arr[mid]);
		
		//System.out.println(start + " " + (mid-1));
		BstNode left = sortedArrayToBst(arr, start, mid-1);
		BstNode right = sortedArrayToBst(arr, mid+1, end);
		
		root.left = left;
		root.right = right;
		
		
		if (left != null) {
			left.parent = root;
		}
		if (right != null) {
			right.parent = root;
		}
		
		
		return root;
	}

	
	
	/*
	 * In order traversal of BST
	 * @param	Node of type BstNode
	 */
	public void inOrderTraversal(BstNode x) {
		if (x != null) {
			inOrderTraversal(x.left);
			System.out.print(x.key + "-");
			inOrderTraversal(x.right);
		}
	}
	
	/*
	 * Pre order traversal of BST
	 * @param	Node of type BstNode
	 */
	public void preOrderTraversal(BstNode x) {
		if (x != null) {
			System.out.print(x.key);
			preOrderTraversal(x.left);
			preOrderTraversal(x.right);
		}
	}
	
	/*
	 * Post order traversal of BST
	 * @param	Node of type BstNode
	 */
	public void postOrderTraversal(BstNode x) {
		if (x != null) {
			postOrderTraversal(x.left);
			postOrderTraversal(x.right);
			System.out.print(x.key);
		}
	}
	
	/*
	 * Search for node with given key
	 * 
	 * @param	integer key
	 * @return	Node of the tree with given key
	 */
	public BstNode search(int key) {
		BstNode x = root;
		
		while (x != null) {
			if (x.key == key) {
				return x;
			}
			
			if (x.key < key) {
				x = x.right;
			} else {
				x = x.left;
			}
		}
		return x;
	}
	
	/*
	 * Find minimum in BST
	 */
	public BstNode minimum(BstNode x) { 
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	/*
	 * Find maximum in BST
	 */
	public BstNode maximum(BstNode x) {
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}
	
	/*
	 * Find successor in BST
	 */
	public BstNode successor(BstNode x) {
		if (x.right != null) {
			return minimum(x.right);
		}
		BstNode y = x.parent;
		while ((y != null) && (x == y.right)) {
			x = y;
			y = y.parent;
		}
		return y;
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 6, 7, 13, 15, 16, 17, 18, 19, 20, 21, 22};
		BinarySearchTree bst = new BinarySearchTree();
		BstNode root = bst.sortedArrayToBst(arr, 0, arr.length-1);
		System.out.println(root.key);
		bst.inOrderTraversal(root);
	}
	
}

