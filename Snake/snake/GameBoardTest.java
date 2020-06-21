package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;


class GameBoardTest {
	/**
	*Purpose: to check if it is same with existing object.
	*Input: NONE
	*Expected:
	*	Return SUCCESS
	*	gameboard = gameboard2
	*/
	@Test
	void testGetBoard() {
		GameBoard gameboard = GameBoard.get_board();
		GameBoard gameboard2 = GameBoard.get_board();
		assertSame(gameboard, gameboard2);
	}
	
	/**
	*Purpose: to check if update() executes correct method according to the direction.
	*Input: NONE
	*Expected:
	*	Return SUCCESS
	*	testMoveSnakeLeft(): update() --> set movement to LEFT
	*   testMoveSnakeRight(): update() --> set movement to RIGHT
	*   testMoveSnakeUp(): update() --> set movement to UP
	*   testMoveSnakeDown(): update() --> set movement to DOWN
	*/
	@Test
	void testMoveSnakeLeft() {
		GameBoard gameboard = GameBoard.get_board();
		gameboard.set_behavior(new LeftBehavior());
		gameboard.update();
		assertEquals(gameboard.get_movement(), Direction.LEFT);
	}
	@Test
	void testMoveSnakeRight() {
		GameBoard gameboard = GameBoard.get_board();
		gameboard.set_behavior(new RightBehavior());
		gameboard.update();
		assertEquals(gameboard.get_movement(), Direction.RIGHT);
	}
	@Test
	void testMoveSnakeUp() {
		GameBoard gameboard = GameBoard.get_board();
		gameboard.set_behavior(new UpBehavior());
		gameboard.update();
		assertEquals(gameboard.get_movement(), Direction.UP);
	}
	@Test
	void testMoveSnakeDown() {
		GameBoard gameboard = GameBoard.get_board();
		gameboard.set_behavior(new DownBehavior());
		gameboard.update();
		assertEquals(gameboard.get_movement(), Direction.DOWN);
	}
}
