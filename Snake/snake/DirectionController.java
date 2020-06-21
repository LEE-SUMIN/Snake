package snake;

public class DirectionController {
	private Direction direction;
	public DirectionController() {
		this.direction = direction;
	}
	private static void set_behavior(Direction nextMove,GameBoard gameBoard) {
		if(nextMove==Direction.LEFT) gameBoard.set_behavior(new LeftBehavior());
		if(nextMove==Direction.RIGHT) gameBoard.set_behavior(new RightBehavior());
		if(nextMove==Direction.UP) gameBoard.set_behavior(new UpBehavior());
		if(nextMove==Direction.DOWN) gameBoard.set_behavior(new DownBehavior());
	}
		
	static Direction reverse(Direction direction) {
		Direction rev = null;
		if(direction ==Direction.LEFT) rev = Direction.RIGHT;
		if(direction ==Direction.RIGHT) rev = Direction.LEFT;
		if(direction ==Direction.UP) rev = Direction.DOWN;
		if(direction ==Direction.DOWN) rev = Direction.UP;
		return rev;
	}
	public static void setDirection(GameBoard gameBoard,Direction lastMove,Direction nextMove) {
		if(lastMove!=reverse(nextMove)||gameBoard.getSnakeSize()==1){
		gameBoard.set_movement(nextMove);
		set_behavior(nextMove,gameBoard);
		}
	}
}
