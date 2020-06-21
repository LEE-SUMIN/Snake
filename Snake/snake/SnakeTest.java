package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SnakeTest {

	/**
	*Purpose: to check if it is same with existing object.
	*Input: NONE
	*Expected:
	*	Return SUCCESS
	*	snake = snake2
	*/
	@Test
	void testGetBoard() {
		Snake snake = Snake.get_snake();
		Snake snake2 = Snake.get_snake();
		assertSame(snake, snake2);
	}
}
