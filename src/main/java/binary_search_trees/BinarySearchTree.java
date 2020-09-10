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
	private BstNode root;
	
	BinarySearchTree(int[] arr) {
		root = sortedArrayToBst(arr);
	}
	
	/*
	 * Builds BST from sorted array
	 * Recursively dividing the array into two parts and
	 * assigning to left and right subtrees
	 */
	private BstNode sortedArrayToBst(int[] arr) {
		
	}

	
	/*
	 * In order traversal of BST
	 * @param	Node of type BstNode
	 */
	public void inOrderTraversal(BstNode x) {
		while (x != null) {
			inOrderTraversal(x.left);
			System.out.print(x.key);
			inOrderTraversal(x.right);
		}
	}
	
	/*
	 * Pre order traversal of BST
	 * @param	Node of type BstNode
	 */
	public void preOrderTraversal(BstNode x) {
		while (x != null) {
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
		while (x != null) {
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
	public BstNode minimum() {
		BstNode x = root;
		while (x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	/*
	 * Find maximum in BST
	 */
	public BstNode maximum() {
		BstNode x = root;
		while (x.right != null) {
			x = x.right;
		}
		return x;
	}
	
	/*
	 * Find successor in BST
	 */
	public BstNode successor() {
		
	}
	
	/*
	 * Find predecessor in BST
	 */
	public BstNode predecessor() {
		
	}
	
}

