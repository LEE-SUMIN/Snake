package snake;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class SnakeTest {
	/**
	*Purpose: check the size of initial Snake
	*Input: 
	*Expected:
	*	Return True
	*	size of snake = 1
	*/
	@Test
	public void testStartedSnake() {
		Snake snake = new Snake();
	 	assertTrue(snake.getSize()==1);
	}
	/**
	*Purpose: check when user press the moveKey(LEFT,RIGHT,UP,DOWN), really snake move that direction.
	*Input: LEFT
	*Expected:
	*	Return True
	*	X = old X -1
	*	Y = old Y
	*
	*Input: RIGHT
	*Expected:
	*	Return True
	*	X = old X +1
	*	Y = old Y
	*
	**Input: UP
	*Expected:
	*	Return True
	*	X = old X
	*	Y = old Y-1
	*
	**Input: DOWN
	*Expected:
	*	Return True
	*	X = old X
	*	Y = old Y+1
	*
	*/
	@Test
	public void testTurnSnake() {
		Snake snake = new Snake();
		Square pos = snake.getHead();
		snake.moveLeft();
		assertTrue(snake.getHead().getX()==pos.getX()-1);
		assertTrue(snake.getHead().getY()==pos.getY());
		
		pos = snake.getHead();
		snake.moveRight();
		assertTrue(snake.getHead().getX()==pos.getX()+1);
		assertTrue(snake.getHead().getY()==pos.getY());
		
		pos = snake.getHead();
		snake.moveUp();
		assertTrue(snake.getHead().getX()==pos.getX());
		assertTrue(snake.getHead().getY()==pos.getY()-1);
		
		pos = snake.getHead();
		snake.moveDown();
		assertTrue(snake.getHead().getX()==pos.getX());
		assertTrue(snake.getHead().getY()==pos.getY()+1);
	}
	
	/**
	*Purpose: check snake grow the size
	*Input: 
	*Expected:
	*	Return True
	*	size of snake = old size of snake + 1
	*/
	@Test
	public void testGrow() {
		Snake snake = new Snake();
		int currentSize = 1;
		snake.grow();
		assertTrue(snake.getSize()==currentSize+1);
		currentSize = snake.getSize();
		int k = 3;
		snake.grow(k);
		assertTrue(snake.getSize()==currentSize+k);
	}
	/**
	*Purpose: check get Tail
	*Input: 
	*Expected:
	*	Return Null
	*
	*/
	@Test
	public void testGetTail() {
		Snake snake = new Snake();
		assertNull(snake.getTail());
	}
	
}