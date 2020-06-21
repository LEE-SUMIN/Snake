import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import snake.Engine;

class EngineTest {
	/**
	* Purpose: Unlike other classes, the Engine is designed with a slightly unusual Singleton pattern. 
	* 		   Therefore, check whether the engine object creates a static object normally.
	* Input: None
	* Expected:
	*	Return Engine Object
	*   if Engine.getEngine() returns null object, it means initiation failed, assert failure will occur.
	*/
	@Test
	void initializeTest() {
		assertNull(Engine.getEngine());
		
		Engine.initialize();
		assertNotNull(Engine.getEngine());
	}
}
