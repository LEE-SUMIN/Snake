package snake;

import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class DirectionControllerTest {
	/**
	*Purpose: set the movement where we will turn and move
	*Input: directionLeft
	*Expected:
	*	Return True
	*	new movement = LEFT
	* Do this testing on UP,RIGHT,DOWN
	*/

	@Test
	public void testSet_behavior() {
		GameBoard gameboard = new GameBoard();
		gameboard.directionLeft();
		assertTrue(gameboard.get_movement()==Direction.LEFT);
	
		gameboard.directionUp();
		assertTrue(gameboard.get_movement()==Direction.UP);
		
		gameboard.directionRight();
		assertTrue(gameboard.get_movement()==Direction.RIGHT);
		
		gameboard.directionDown();
		assertTrue(gameboard.get_movement()==Direction.DOWN);
	}
		/*
	@Test
	public void testSizeOne() {
		GameBoard gameboard = new GameBoard();
		assertTrue(gameboard.getSnakeSize()==1);
		Snake snake = Snake.get_snake();
		snake.grow();
		assertFalse(gameboard.getSnakeSize()==1);
		gameboard.directionLeft();
		
	}*/
}