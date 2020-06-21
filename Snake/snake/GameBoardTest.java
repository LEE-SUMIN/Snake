package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class GameBoardTest {
	@BeforeEach
	static void setup() {
		GameBoard gameboard = GameBoard.get_board();
	}
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
	
	/**
	*Purpose: to check if addScore() adds score correctly.
	*Input: NONE
	*Expected:
	*	Return SUCCESS
	*	0(original score) + 30 = 30
	*/
	@Test
	void testAddScore() {
		GameBoard gameboard = GameBoard.get_board();
		int s = 30;
		gameboard.addScore(s);
		assertEquals(gameboard.getScore(), 30);
	}
}
