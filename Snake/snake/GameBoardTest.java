package snake;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
*Purpose: to check if it is same with existing object.
*Input: NONE
*Expected:
*	Return SUCCESS
*	gameboard = gameboard2
*/
class GameBoardTest {

	@Test
	void testGetBoard() {
		GameBoard gameboard = GameBoard.get_board();
		GameBoard gameboard2 = GameBoard.get_board();
		
		assertSame(gameboard, gameboard2);
	}
}
