import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Field;

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
		Engine.initialize();
		assertNotNull(Engine.getEngine());
	}
	
	/**
	* Purpose: The Engine is designed with a singleton pattern, so it should return the same object everywhere.
	* Input: None
	* Expected:
	*    Check if the Engine objects referenced in different places are the same. In other cases, assert failure will occurs
	*/
	@Test
	void getEngineTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Engine.initialize();
		Engine e = Engine.getEngine();
		Field engine = e.getClass().getDeclaredField("engine");
		engine.setAccessible(true);
		
		assertSame(e, (Engine)engine.get(e));
	}
	
}
