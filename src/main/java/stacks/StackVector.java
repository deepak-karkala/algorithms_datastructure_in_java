package stacks;

import java.util.EmptyStackException;
import java.util.Vector;

/**
 * <code>Stack</code> class represents LIFO operation.
 * Supports <tt>push</tt>, <tt>pop</tt>, <tt>empty</tt>,
 * <tt>empty</tt>, <tt>search</tt> operations.
 * 
 * @author	Deepak Karkala
 */


public class StackVector<E> extends Vector<E> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Constructor, creates an empty stack
	 */
	public StackVector() {
	}
	
	/*
	 * Pushes an element to top of the stack
	 * and returns the element
	 * 
	 * @param	item the item to be pushed on to stack
	 * @return	<code>item</code>
	 */
	public E push(E item) {
		addElement(item);

		return item;
	}
	
	/*
	 * Returns element at top of stack without removing it
	 * 
	 * @return element at top of stack
	 * @throws EmptyStackException if stack is empty
	 */
	public E peek() {
		int len = size();
		if (len == 0)
			throw new EmptyStackException();
		return elementAt(len - 1);
	}
	
	/*
	 * Removes and returns element at top of stack
	 * 
	 * @return element at top of stack
	 * @throws EmptyStackOperation if stack is empty
	 */
	public E pop() {
		int len = size();
		E	obj;
		
		obj = peek();
		removeElementAt(len - 1);
		return obj;
	}
	
	/*
	 * Tests if stack is empty
	 * 
	 * @return	<code>true</code> if and only if stack
	 * 			has no items
	 */
	public boolean empty() {
		return size() == 0;
	}
	
	/*
	 * Search for an element in the stack and return its index
	 * 
	 * @param	o	element to be searched
	 * @return	the 1-based position of the element from the
	 * 			top of stack. If not present, returns <code>-1</code>
	 */
	public int search(Object o) {
		int i = lastIndexOf(o);
		
		if (i >= 0) {
			return size() - i;
		}
		return -1;
	
	}
}
