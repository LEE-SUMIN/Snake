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
	
}