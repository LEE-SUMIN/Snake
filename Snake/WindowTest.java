import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import snake.Engine;
import snake.Painter;
import snake.Properties;
import snake.Window;
import snake.GameBoard;


/* Window Code Coverage : 23/24, 96% */

class WindowTest {
	/**
	* Purpose: Check if it returns Window object normally.The Window object should return even when no object is assigned as Singleton.
	* Input: None
	* Expected:
	*	Return Window Object
	*	
	*/
	@Test
	void getWindowTest() {
		Window window;
		
		window = Window.getWindow();
		assertNotNull(window);
		assertSame(window, Window.getWindow());
	}
	
	
	/**
	* Purpose: When Window handle is created, check if Width and Height are set normally.
	* Input: None
	* Expected:
	*	Properties are designed with Singleton pattern, so it should return the same Square Size wherever it is called. 
	*   Therefore, if a Square Size different from that declared in the Window object is returned, it will cause an Assert fault.	
	*/
	@Test
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
			
			
			assertEquals((int)w.get(window), p.getSquareSize() * p.getBoardColumns());
			assertEquals((int)h.get(window), p.getSquareSize() * p.getBoardRows());
			
		}catch(NoSuchFieldException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	/**
	* Purpose: Make sure createEngine method working properly.
	* Input: None
	* Expected:
	*     1) Since the engine is designed in a singleton pattern, all objects have the same object. Therefore, if it is not the same engine object, assert failure will occur.
	*	  2) Since Painter is also designed with Singleton pattern, getPreferredSize should return Dimension objects such as canvasWidth and canvasHeight. If not, Assert failure will occur.
    *     3) If KeyListener is successfully registered, an object must be returned. If not, Assert failure will occur.
    *     4) Check if the Painter is properly registered in the JFame Container object and the Painter object declared in Window is correct. If not, Assert failure will occur.
	*/
	@Test
	void getCreateEngineTest() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException {
		Window window = Window.getWindow();
		
		Method m = window.getClass().getDeclaredMethod("createEngine");
		
		Field engine = window.getClass().getDeclaredField("engine");
		Field w = window.getClass().getDeclaredField("canvasWidth");
		Field h = window.getClass().getDeclaredField("canvasHeight");
		
		m.setAccessible(true);
		w.setAccessible(true);
		h.setAccessible(true);
		engine.setAccessible(true);
		
		// Engine object test
		m.invoke(window);
		Engine e = Engine.getEngine();
		assertSame(e, (Engine)engine.get(window));
		
		// Painter setPreferredSize test
		Painter p = Painter.getPainter();
		Dimension d = p.getPreferredSize();
		assertEquals(d.width, (int)w.get(window));
		assertEquals(d.height, (int)h.get(window));

		//addKeyListenerTest
		assertNotNull(window.getKeyListeners());
		
		//Container add painter Test
		Container cp = window.getContentPane();
		Component c[] = cp.getComponents();
		Painter p_tmp = null;
		for(Component com : c) {
			if( (Painter)com == p) p_tmp = (Painter)com;
		}
		assertNotNull(p_tmp);
	}
	
	/**
	* Purpose: Verify that the setWindowProperties method works properly.
	* Input: None
	* Expected:
	*   1) setDefaultCloseOperation is a constant called EXIT_ON_CLOSE, which decides under what conditions. If the getDefaultCloseOperation method is not EXIT_ON_CLOSE, assert failure occurs because it is not the case.
	*   2) Print the Default score with setTitle. Therefore, assert failure occurs when getTitle is not the default score.
	*   3) This project does not make the window resizable. If the isResizable method returns true, assert failure occurs because it was not working properly.
	*   4) Window is visible through setVisible method. So, if the isVisible method returns false, the statement is not executed properly, so it returns assert failure.
	*/
	@Test
	void setWindowPropertiesTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Window window = Window.getWindow();
		Method m = window.getClass().getDeclaredMethod("setWindowProperties");
		m.setAccessible(true);
		m.invoke(window);
		
		// setDefualtCloseOperation Test
		assertEquals(window.getDefaultCloseOperation(), window.EXIT_ON_CLOSE);
		
		// setTitle Test
		assertTrue(window.getTitle().equals("Snake - Score: 0"));
		
		// setResizable Test
		assertFalse(window.isResizable());
		
		//  setVisible Test
		assertTrue(window.isVisible());
	}
	
	/**
	* Purpose: Make sure the update method updates the score properly.
	* Input: None
	* Expected: 
	*     The update method updates the score each time it is called. 
	*     Therefore, change the score of the GameBoard object and check if it is reflected normally when the update method is called. 
	*     In this case, if the set score and the score displayed in the title are different, assert failure occurs.
	*/
	@Test
	void windowUpdateTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Window window = Window.getWindow();
		GameBoard g = GameBoard.get_board();
		Method m = g.getClass().getDeclaredMethod("getScore");
		Field score = g.getClass().getDeclaredField("score");
		score.setAccessible(true);
		m.setAccessible(true);
		
		window.update();
		assertTrue(window.getTitle().equals("Snake - Score: " + (int)m.invoke(g)));
		
		score.set(g, 123);
		window.update();
		assertTrue(window.getTitle().equals("Snake - Score: " + (int)123));
	}
}
