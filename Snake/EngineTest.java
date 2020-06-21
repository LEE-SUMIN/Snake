import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import snake.Direction;
import snake.Engine;
import snake.GameBoard;
import snake.Properties;
import snake.Theme;

class EngineTest {
	/**
	* Purpose: Unlike other classes, the Engine is designed with a slightly unusual Singleton pattern. 
	* 		   Therefore, check whether the engine object creates a static object normally.
	*   		if Engine.getEngine() returns null object, it means initiation failed, assert failure will occur.

	* Input: None
	* Expected:
	* 		Return Engine Object
	*/
	@Test
	void initializeTest() {
		Engine.initialize();
		assertNotNull(Engine.getEngine());
	}
	
	/**
	* Purpose: The Engine is designed with a singleton pattern, so it should return the same object everywhere.
	   		   Check if the Engine objects referenced in different places are the same. In other cases, assert failure will occurs
	* Input: None
	* Expected:
	* 		Return true
	*/
	@Test
	void getEngineTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Engine.initialize();
		Engine e = Engine.getEngine();
		Field engine = e.getClass().getDeclaredField("engine");
		engine.setAccessible(true);
		
		assertSame(e, (Engine)engine.get(e));
	}
	
	
	/**
	* Purpose: Check if the keyInterruptHandler method is working properly. 
	* 		   In this method, the function key controls the theme change and the direction key controls the snake movement. everywhere.
	* 	       Function key changes the theme. Otherwise, assert failure occurs.
	*	 	   The first arrow key signals the start of the game. Therefore, assert failure occurs if it is not started after checking the corresponding bit of the engine.
	*	 	   The second direction key indicates the up direction. If the snake's movement does not match the Direction.UP, an assert failure occurs.
	* Input: F1
	* Expected:
	* 		Properties.theme = Theme.Dark
	* Input: Left
	* Expected:
	* 		Engine.running = true;
	* Input: Up
	* Expected:
	* 		Engine.running = true;
	* 		Gameboard.movement = Direction.UP
	*/
	@Test
	void keyInterruptHandlerTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Engine.initialize();
		Engine e = Engine.getEngine();
		GameBoard g = GameBoard.get_board();
		Properties p = Properties.Instance();
		
		Field running = e.getClass().getDeclaredField("running");
		running.setAccessible(true);
		
		e.keyInterruptHandler(KeyEvent.VK_LEFT);
		assertTrue((boolean)running.get(e));
		
		Field m = g.getClass().getDeclaredField("movement");
		m.setAccessible(true);
		e.keyInterruptHandler(KeyEvent.VK_UP);
		assertEquals(Direction.UP, (Direction)m.get(g));
		
		Field t = p.getClass().getDeclaredField("theme");
		t.setAccessible(true);
		e.keyInterruptHandler(KeyEvent.VK_F1);
		assertEquals(Theme.Dark, (Theme)t.get(p));
	}
	
	
	/**
	* Purpose: Run a branch test of the keyInterruptHandler method. 
	* 		   Make sure to execute the proper syntax for each branch condition.
	*     	   If the game is not running and a function key is entered, only the theme is changed and the running bit should not be affected. Otherwise, assert failure occurs.
	*     	   If the direction key is input when the running bit is not set, the game should start. Otherwise, assert failure occurs.
	*     	   The direction of the snake should be set according to the direction key. Otherwise, assert failure occurs.
	* Input: F1
	* Expected:
	* 		Engine.running = false 
	* 		Properties.theme = Theme.Dark
	* Input: Right
	* Expected:
	* 		Engine.running = true
	* Input: Up
	* Expected:
	* 		Engine.running = true
	* 		GameBoard.movement = Direction.UP
	* Input: Right
	* Expected:
	* 		Engine.running = true
	* 		GameBoard.movement = Direction.Right
	* 
	*/
	@Test
	void keyInterruptHandlerEngineRunningDecisionTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Engine.initialize();
		Engine e = Engine.getEngine();
		GameBoard g = GameBoard.get_board();
		Properties p = Properties.Instance();
		
		Field running = e.getClass().getDeclaredField("running");
		running.setAccessible(true);
		assertFalse(running.getBoolean(e));
		
		Field t = p.getClass().getDeclaredField("theme");
		t.setAccessible(true);
		e.keyInterruptHandler(KeyEvent.VK_F1);
		assertFalse(running.getBoolean(e));
		assertEquals(Theme.Dark, (Theme)t.get(p));
		
		e.keyInterruptHandler(KeyEvent.VK_RIGHT);
		assertTrue(running.getBoolean(e));
		
		Field m = g.getClass().getDeclaredField("movement");
		m.setAccessible(true);
		e.keyInterruptHandler(KeyEvent.VK_UP);
		assertEquals(Direction.UP, (Direction)m.get(g));
		assertTrue(running.getBoolean(e));
		
		e.keyInterruptHandler(KeyEvent.VK_RIGHT);
		assertEquals(Direction.RIGHT, (Direction)m.get(g));
		assertTrue(running.getBoolean(e));
	}
	
	
	/**
	* Purpose: perform branch and coverage tests of the selectBackGround method. 
	* 	       React appropriately to each function key input and ignore any unspecified inputs.
	*		   If the theme setting mapped to each function key is not properly performed, assert failure occurs.
	* Input: F1
	* Expected:
	* 		Properties.theme = Theme.Dark
	* Input: F2
	* Expected:
	* 		Properties.theme = Theme.Sky	
	* Input: F3
	* Expected:
	* 		Properties.theme = Theme.Mud
	* Input: F4
	* Expected:
	* 		Properties.theme = Theme.Rainbow
	* Input: F5
	* Expected:
	* 		Properties.theme = Theme.Rainbow
	*/
	@Test
	void selectBackGroundTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Engine.initialize();
		Engine e = Engine.getEngine();
		Properties p = Properties.Instance();
		Method m = e.getClass().getDeclaredMethod("selectBackGround", int.class);
		Field t = p.getClass().getDeclaredField("theme");
		m.setAccessible(true);
		t.setAccessible(true);
		
		m.invoke(e, KeyEvent.VK_F1);
		assertEquals(Theme.Dark, (Theme)t.get(p));
		
		m.invoke(e, KeyEvent.VK_F2);
		assertEquals(Theme.Sky, (Theme)t.get(p));
		
		m.invoke(e, KeyEvent.VK_F3);
		assertEquals(Theme.Mud, (Theme)t.get(p));
		
		m.invoke(e, KeyEvent.VK_F4);
		assertEquals(Theme.Rainbow, (Theme)t.get(p));
		
		m.invoke(e, KeyEvent.VK_F5);
		assertEquals(Theme.Rainbow, (Theme)t.get(p));
	}
	
	
	/**
	* Purpose: perform branch and coverage tests of the selectMovement method. 
	* 	       React appropriately to each direction key input and ignore any unspecified inputs.
	*		   If the theme setting mapped to each direction key is not properly performed, assert failure occurs.
	* Input: Left
	* Expected:
	* 		GameBoard.movement = Direction.LEFT
	* Input: Up
	* Expected:
	* 		GameBoard.movement = Direction.UP
	* Input: Right
	* Expected:
	* 		GameBoard.movement = Direction.RIGHT
	* Input: Down
	* Expected:
	* 		GameBoard.movement = Direction.DOWN
	* Input: F1
	* Expected:
	* 		GameBoard.movement = Direction.(last_movement)
	*/
	@Test
	void selectMovementTest() throws NoSuchFieldException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Engine.initialize();
		Engine e = Engine.getEngine();
		GameBoard g = GameBoard.get_board();
		Method m = e.getClass().getDeclaredMethod("selectMovement", int.class);
		Field movement = g.getClass().getDeclaredField("movement");
		m.setAccessible(true); movement.setAccessible(true);
		movement.setAccessible(true);
		
		m.invoke(e, KeyEvent.VK_LEFT);
		assertEquals((Direction)movement.get(g), Direction.LEFT);
		
		m.invoke(e, KeyEvent.VK_UP);
		assertEquals((Direction)movement.get(g), Direction.UP);
		
		m.invoke(e, KeyEvent.VK_RIGHT);
		assertEquals((Direction)movement.get(g), Direction.RIGHT);
		
		m.invoke(e, KeyEvent.VK_DOWN);
		assertEquals((Direction)movement.get(g), Direction.DOWN);
		
		m.invoke(e, KeyEvent.VK_F1);
		assertEquals((Direction)movement.get(g), Direction.DOWN);
	}
	
	
	@Test
	void startGameTest() {
		Engine.initialize();
		Engine e = Engine.getEngine();
	}
}
