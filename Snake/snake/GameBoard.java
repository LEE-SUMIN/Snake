package snake;

/**
 * Represents the environment where the Snake moves a food spawns.
 * <br/>
 * There are some special rules as to how the Snake can move. If the Snake's size
 * is 1, it can move in any direction. If the Snake's size is greater than 1, it
 * cannot move 180 degrees. Example: if the Snake is moving right, it cannot
 * immediately change its direction to left because it would run into itself.
 */
class GameBoard implements Observer {
	private static GameBoard gameBoard;
    private Food food;
    private Snake snake;
    private int score = 0;
    private Properties properties = Properties.Instance();
    private DirectionController directionController;

    /**
     * Keep track of the last move so that the Snake cannot do 180 degree turns,
     * only 90 degree turns.
     */
    private Direction movement;
    private SnakeMoveBehavior snakeMoveBehavior;
    private Direction lastMove;
    private Direction nextMove;

    /**
     * Constructs the board.
     */
    GameBoard () {
    	gameBoard = this;
        this.snake = Snake.get_snake();
        this.food = new Food();
        this.snakeMoveBehavior = new DownBehavior();
        this.directionController = new DirectionController(Direction.DOWN);
        properties=Properties.Instance();
        update();
    }
    
    public static GameBoard get_board()
    {
    	if(gameBoard == null)
    	{
    		gameBoard = new GameBoard();
    	}
    	return gameBoard;
    }

    /**
     * Move the Snake.
     */
    public void update () {
        moveSnake();
    }

    void set_food(Food food) {
    	this.food = food;
    }
    
    Food get_food() {
    	return food;
    }
    
    void set_movement(Direction direction) {
    	movement = direction;
    }
    
    void set_behavior(SnakeMoveBehavior snakeMoveBehavior) {
    	this.snakeMoveBehavior = snakeMoveBehavior;
    }
    
    void directionLeft () {
    	directionController.set_direction(movement, Direction.LEFT);   	
    }

    /**
     * Sets the direction of the Snake to go right.
     */
    void directionRight () {
    	directionController.set_direction(movement, Direction.RIGHT);
    }

    /**
     * Sets the direction of the Snake to go up.
     */
    void directionUp () {
    	directionController.set_direction(movement, Direction.UP);
    }

    /**
     * Sets the direction of the Snake to go down.
     */
    void directionDown () {
    	directionController.set_direction(movement, Direction.DOWN);
    }

    /**
     * Moves the Snake one square, according to its direction.
     */
    private void moveSnake () {
    	snakeMoveBehavior.action();
        lastMove = movement;
    }

     int getSnakeSize () {
        return snake.getSize();
    }

    int getScore() {
        return score;
    }
    void addScore(int score) {
    	this.score += score;
    }


    @Override
    public String toString () {

        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < properties.getBoardRows(); y++) {
            for (int x = 0; x < properties.getBoardColumns(); x++) {
                Square sq = new Square(x, y);

                if (snake.contains(sq)) {
                    sb.append("S");
                } else if (food.equals(sq)) {
                    sb.append("F");
                } else {
                    sb.append("-");
                }

                sb.append(" ");

            }
            sb.append("\n");
        }

        return new String(sb);
    }

}
