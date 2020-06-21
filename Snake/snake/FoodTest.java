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


}
