package test;

import snake.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class SqareTest {
	private Square square;
	
	/*
	 * Purpose : Create Square with parameters and check its fields
	 * Expected : All checks will pass true
	 */
	@Test
	public void testCreate() {
		square=new Square(Entity.Empty,5,5);
		assertEquals(Entity.Empty,square.getEntity());
		assertEquals(5,square.getX());
		assertEquals(5,square.getY());
	}
	
}
