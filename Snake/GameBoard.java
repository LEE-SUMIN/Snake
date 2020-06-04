import java.awt.*;
import java.util.Random;

/**
 * Represents the environment where the Snake moves a food spawns.
 * <br/>
 * There are some special rules as to how the Snake can move. If the Snake's size
 * is 1, it can move in any direction. If the Snake's size is greater than 1, it
 * cannot move 180 degrees. Example: if the Snake is moving right, it cannot
 * immediately change its direction to left because it would run into itself.
 */
public class GameBoard  {
   
    private static GameBoard gameBoard;
    private static int num_invoke;
    private beforeMove data = new beforeMove(0, Direction.DOWN);

	/**
     * Constructs the board.
     */
    GameBoard () {
       gameBoard = this;
       num_invoke = 0;
       this.data.snake = Snake.get_snake();
       this.data.food = new Food();
       this.data.snakeMoveBehavior = new DownBehavior();
       update();
    }
    
    public static GameBoard get_board()
    {
       if(gameBoard == null)
       {
          gameBoard = new GameBoard();
       }
       num_invoke++;
       return gameBoard;
    }

    /**
     * Move the Snake.
     */
    void update () {
        moveSnake();
    }
    
    void set_food(Food food) {
    	this.data.food = food;
    }
    
    Food get_food() {
    	return data.food;
    }
    
    void set_movement(Direction direction) {
    	data.movement = direction;
    }
    
    void set_behavior(SnakeMoveBehavior snakeMoveBehavior) {
    	this.data.snakeMoveBehavior = snakeMoveBehavior;
    }
    
    void directionLeft () {
        if (data.lastMove != Direction.RIGHT || getSnakeSize() == 1) {
            set_movement(Direction.LEFT);
            set_behavior(new LeftBehavior());
        }
    }

    /**
     * Sets the direction of the Snake to go right.
     */
    void directionRight () {
        if (data.lastMove != Direction.LEFT || getSnakeSize() == 1) {
        	set_movement(Direction.RIGHT);
            set_behavior(new RightBehavior());
        }
    }

    /**
     * Sets the direction of the Snake to go up.
     */
    void directionUp () {
        if (data.lastMove != Direction.DOWN || getSnakeSize() == 1) {
        	set_movement(Direction.UP);
            set_behavior(new UpBehavior());
        }
    }

    /**
     * Sets the direction of the Snake to go down.
     */
    void directionDown () {
        if (data.lastMove != Direction.UP || getSnakeSize() == 1) {
        	set_movement(Direction.DOWN);
            set_behavior(new DownBehavior());
        }
    }

    /**
     * Moves the Snake one square, according to its direction.
     */
    private void moveSnake () {
        data.snakeMoveBehavior.action();
        data.lastMove = data.movement;
    }

    int getScore () {
        return data.score;
    }
    
    void addScore(int score) {
    	this.data.score += score;
    }
    
    private int getSnakeSize () {
        return data.snake.getSize();
    }

    void paint (Graphics graphics) {

        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        paintSnake(g);
        paintFood(g);
    }

    private void paintSnake (Graphics2D g) {
        int x, y;
        int corner = Properties.SQUARE_SIZE / 3;

        for (Square sq : data.snake) {

            x = sq.getX() * Properties.SQUARE_SIZE;
            y = sq.getY() * Properties.SQUARE_SIZE;

            g.setColor(Properties.snakeColor);
            g.fillRoundRect(x + 1, y + 1, Properties.SQUARE_SIZE - 2,
                    Properties.SQUARE_SIZE - 2, corner, corner);

        }
    }

    private void paintFood (Graphics2D g) {
        int x = data.food.get_X() * Properties.SQUARE_SIZE;
        int y = data.food.get_Y() * Properties.SQUARE_SIZE;
        int corner = Properties.SQUARE_SIZE / 3;

        g.setColor(Properties.foodColor);
        g.fillRoundRect(x + 1, y + 1, Properties.SQUARE_SIZE - 2,
                Properties.SQUARE_SIZE - 2, corner, corner);
    }

    @Override
    public String toString () {

        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < Properties.BOARD_ROWS; y++) {
            for (int x = 0; x < Properties.BOARD_COLUMNS; x++) {
                Square sq = new Square(x, y);

                if (data.snake.contains(sq)) {
                    sb.append("S");
                } else if (data.food.get_food().equals(sq)) {
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