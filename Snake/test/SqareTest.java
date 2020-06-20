package test;

import snake.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class SqareTest {
	private Square square;
	
	/*
	 * Purpose : Create Square with Entity and check its fields.
	 * Expected : All checks will pass true.
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
	 * Expected : All checks will pass true.
	 */
	@Test
	public void testCreateWithoutEntityAndSetEntity() {
		square=new Square(5,5);
		assertEquals(Entity.Empty,square.getEntity());
		square.setEntity(Entity.Food);
		assertEquals(Entity.Food,square.getEntity());
	}
	
	/*
	 * Purpose : Compare the Square's Coordinate with the newly created Coordinate.
	 * Expected : Check will pass true. 
	 */
	@Test
	public void testCompareCoord() {
		square=new Square(5,5);
		Coordinate coord = new Coordinate(5,5);
		assertEquals(coord,square.getCoord());
	}
	
	/*
	 * Purpose : Compare two Squares created using the same parameters. 
	 * Expected : All checks will pass true. 
	 */
	@Test
	public void testCompareSquare() {
		square = new Square(5,5);
		Square diffSquare = new Square(5,5);
		assertEquals(square,diffSquare);
		Coordinate coord = new Coordinate(5,5);
		assertNotEquals(square,coord);
	}
	
	/*
	 * Purpose : Compare String(Square.toString) with correct text.
	 * Expected : Check will pass true. 
	 */
	@Test
	public void testSquareToString() {
		square = new Square(Entity.Snake,10,10);
		assertEquals(square.toString(),"Snake at (10, 10)");
	}
	
	/**********************************************************************/
	/*
	 * Purpose : Boundary value analysis_1
	 * Expected : Check will pass true.
	 */
	@Test
	public void testSquareXYBound_1() {
		square = new Square(0,0);
		Coordinate coord = new Coordinate(0,0);
		assertEquals(square.getCoord(),coord);
	}
}
