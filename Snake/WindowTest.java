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

class WindowTest extends JFrame{

	
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
		assertNotNull(getKeyListeners());
		
		//Container add painter Test
		Container cp = getContentPane();
		Component c[] = cp.getComponents();
		Painter p_tmp = null;
		for(Component com : c) {
			if(com.equals(p)) p_tmp = (Painter)com;
		}
		assertNull(p_tmp);
	}
	
}
