
public class beforeMove {
	public Food food;
	public Snake snake;
	public int score;
	/**
	 * Keep track of the last move so that the Snake cannot do 180 degree turns,
	 * only 90 degree turns.
	 */
	public Direction movement;
	public SnakeMoveBehavior snakeMoveBehavior;
	public Direction lastMove = movement;

	public beforeMove(int score, Direction movement) {
		this.score = score;
		this.movement = movement;
	}
}