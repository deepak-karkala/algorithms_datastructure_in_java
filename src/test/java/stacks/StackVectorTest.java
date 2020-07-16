package stacks;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 *  JUnit class to test Stack Class
 */
public class StackVectorTest {
	
	private StackVector<Integer> stack;

	@Before
	public void setUp() throws Exception {
		stack = new StackVector<Integer>();
	}

	@Test
	public void testEmptyOnInit() {
		assertTrue(stack.empty());
	}
	
}
