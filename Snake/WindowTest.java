import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

import snake.Properties;
import snake.Window;

class WindowTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	/**
	* Purpose: Check if it returns Window object normally.The Window object should return even when no object is assigned as Singleton.
	* Input: None
	* Expected:
	*	Return Window Object
	*	
	*/
	
	void getWindowTest() {
		Window window;
		
		window = Window.getWindow();
		assertNotNull(window);
	}
	
	
	/**
	* Purpose: When Window handle is created, check if Width and Height are set normally.
	* Input: None
	* Expected:
	*	Properties are designed with Singleton pattern, so it should return the same Square Size wherever it is called. 
	*   Therefore, if a Square Size different from that declared in the Window object is returned, it will cause an Assert fault.	
	*/
	void setGUISizeTest() {
		Window window;
		
		window = Window.getWindow();
		window.createAndShowGUI();
		Properties p = Properties.Instance();
		
		try {
			Field w = window.getClass().getDeclaredField("canvasWidth");
			Field h = window.getClass().getDeclaredField("canvasHeight");
			w.setAccessible(true);
			h.setAccessible(true);
			
			assertEquals(w, p.getSquareSize() * p.getBoardColumns());
			assertEquals(h, p.getSquareSize() * p.getBoardRows());
			
		}catch(NoSuchFieldException e) {
			e.printStackTrace();
		}
	}
	
}
