package linked_lists;

public class SinglyLinkedList {
	/*
	 * Class to implement Singly linked list
	 */
	// Head of the list
	Node head;
	
	// Node class
	static class Node {
		int data;
		Node next;
		
		Node(int d) {
			data = d;
			next = null;
		}
	}
	
	// Method to display list
	public static void printList(SinglyLinkedList list)
	{
		Node currentNode = list.head;
		
		while (currentNode != null) {
			System.out.print(currentNode.data + "->");
			currentNode = currentNode.next;
		}
	}
	
	// Method to insert node at last
	public static SinglyLinkedList insert(SinglyLinkedList list, int data)
	{
		
		Node newNode = new Node(data);
		
		if (list.head == null) {
			list.head = newNode;
		} else {
			Node currentNode = list.head;
			
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			
			currentNode.next = newNode;
			
		}
		
		return list;
	}
	
	//Method to delete node by key
	public static SinglyLinkedList deleteByKey(SinglyLinkedList list, int key)
	{
		Node currentNode = list.head;
		Node prevNode = null;
		
		// If the node to be deleted is head itself
		if (currentNode != null && currentNode.data == key) {
			list.head = currentNode.next;
			return list;
		}
		return list;
	}
	
	// Driver code
	public static void main(String[] args) {
		SinglyLinkedList slist = new SinglyLinkedList();
		insert(slist, 3);
		insert(slist, 2);
		insert(slist, 7);
		
		printList(slist);
	}
	
}

