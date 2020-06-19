package test;

import snake.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class SqareTest {
	private Square square;
	
	/*
	 * Purpose : Create Square with Entity and check its fields
	 * Expected : All checks will pass true
	 */
	@Test
	public void testCreateWithEntity() {
		square=new Square(Entity.Empty,5,5);
		assertEquals(Entity.Empty,square.getEntity());
		assertEquals(5,square.getX());
		assertEquals(5,square.getY());
	}
	
	/*
	 * Purpose : Create Square without Entity ,and Set and check Entity.
	 * Expected : All checks will pass true
	 */
	@Test
	public void testCreateWithoutEntityAndSetEntity() {
		square=new Square(5,5);
		assertEquals(Entity.Empty,square.getEntity());
		square.setEntity(Entity.Food);
		assertEquals(Entity.Food,square.getEntity());
	}
	
}
