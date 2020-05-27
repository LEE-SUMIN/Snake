import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Runs a game of Snake.
 * Uses the arrow keys to move the Snake.
 * Click F1, F2, F3, F4 or F5 to change the color.
 */
public class Window extends JFrame implements Observer{
	private Engine engine;
	
    private final int canvasWidth = Properties.SQUARE_SIZE * Properties.BOARD_COLUMNS;
    private final int canvasHeight = Properties.SQUARE_SIZE * Properties.BOARD_ROWS;
    private Color background = Properties.backgroundColor;
    
    public Window() {
        createEngine();
        setWindowProperties();
    }

    private void createEngine () {
        Container cp = getContentPane();
        engine = Engine.getEngine();
        engine.setWindow(this);
        engine.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        addKeyListener(new MyKeyAdapter());

        cp.add(engine);
    }

    private void setWindowProperties () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake - Score: 0");
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);// Center window
    }

    public void setBackgroundHandler(Object object) {
    	setBackground((Color)object);
    }
    
	@Override
	public void update() {
		int score = engine.getScore();
		setTitle("Snake - Score: " + score);
	}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window());
    }

}