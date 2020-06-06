package snake;

public class DirectionController {
	private Direction direction;
	public DirectionController() {
		this.direction = direction;
	}
	private static void set_behavoir(Direction nextMove,GameBoard gameBoard) {
		if(nextMove==Direction.LEFT) gameBoard.set_behavior(new LeftBehavior());
		if(nextMove==Direction.RIGHT) gameBoard.set_behavior(new RightBehavior());
		if(nextMove==Direction.UP) gameBoard.set_behavior(new UpBehavior());
		if(nextMove==Direction.DOWN) gameBoard.set_behavior(new DownBehavior());
	}
	public static void setDirection(GameBoard gameBoard,Direction lastMove,Direction nextMove) {
		if(lastMove!=gameBoard.reverse(nextMove)||gameBoard.getSnakeSize()==1){
		gameBoard.set_movement(nextMove);
		set_behavoir(nextMove,gameBoard);
		}
	}
}
