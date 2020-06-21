package snake;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

public class SnakeTest {
	@Test
	public void testStartedSnake() {
		Snake snake = new Snake();
	 	assertTrue(snake.getSize()==1);
	}
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
	
	@Test
	public void testGetTail() {
		Snake snake = new Snake();
		assertNull(snake.getTail());
	}
	@Test
	public void testToString() {
		Snake snake = new Snake();
		assertNotNull(snake.toString());
	}
	@Test
	public void testGetSnake() {
		Snake snake = null;
		snake = snake.get_snake();
		assertNotNull(snake);
	}
	/*
	@Test
	public void testSnakeContainFood() {
		Snake snake = new Snake();
		Square pos = snake.getHead();
		assertTrue(contain(pos));
	}*/
}
