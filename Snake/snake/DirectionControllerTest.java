package snake;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.awt.event.KeyEvent;
/*
public final static int LEFT = KeyEvent.VK_LEFT;
public final static int RIGHT = KeyEvent.VK_RIGHT;
public final static int UP =  KeyEvent.VK_UP;
public final static int DOWN = KeyEvent.VK_DOWN;
*/

public class DirectionControllerTest {
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
