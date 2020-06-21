package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FoodTest {
	
	/**
	*Purpose: to check if food is properly generated.
	*Input:
	*Expected:
	*	Return SUCCESS
	*/
	@Test
	void testSetFoodNull() {
		Food food = new Food();
		assertNotNull(food);
	}

	/**
	*Purpose: to check if the snake does not contain the food.
	*Input:
	*Expected:
	*	Return SUCCESS
	*	if the snake holds food, it has to generate food again.
	*   Therefore, the food generated finally must not be inside the snake.
	*/
	@Test
	void testSetFoodContain() {
		Snake snake = Snake.get_snake();
		Food food = new Food();
		assertFalse(snake.contains(food.get_food()));
	}
}
