import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import snake.Window;

class WindowTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	/**
	* Purpose: Check if it returns Window object normally.The Window object should return even when no object is assigned as Singleton.
	* Input:
	* Expected:
	*	Return Window Object
	*	
	*/
	
	void getWindowTest() {
		Window window;
		
		window = Window.getWindow();
		assertNotNull(window);
	}
	
	void createAndShowGUITest() {
		Window window;
		
		window = Window.getWindow();
		
	}
	
}
