import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Runs a game of Snake.
 * Uses the arrow keys to move the Snake.
 * Click F1, F2, F3, F4 or F5 to change the color.
 */
public class Window extends JFrame {
    private Engine engine;
    
    private final int canvasWidth = Properties.SQUARE_SIZE * Properties.BOARD_COLUMNS;
    private final int canvasHeight = Properties.SQUARE_SIZE * Properties.BOARD_ROWS;
    
    private Window() {
        createEngine();
        setWindowProperties();
    }

    private void createEngine () {
        Container cp = getContentPane();
        engine = new Engine();
        
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

    private void startGame () {
        engine.startGame();
    }

    private class MyKeyAdapter extends KeyAdapter {
    	// maybe move to properties?
    	private final int LEFT = KeyEvent.VK_LEFT;
    	private final int RIGHT = KeyEvent.VK_RIGHT;
    	private final int UP =  KeyEvent.VK_UP;
    	private final int DOWN = KeyEvent.VK_DOWN;
    	private final int F1 = KeyEvent.VK_F1;
    	private final int F2 = KeyEvent.VK_F2;
    	private final int F3 = KeyEvent.VK_F3;
    	private final int F4 = KeyEvent.VK_F4;
    	private final int F5 = KeyEvent.VK_F5; 
    	
    	private int keyCode;
    	
    	//private boolean 
    	private boolean isFunctionKey() {
    		return keyCode == F1 || keyCode == F2 || keyCode == F3 || keyCode == F4 || keyCode == F5;
    	}
    	
    	private boolean isMoveKey() {
    		return keyCode == LEFT || keyCode == RIGHT || keyCode == UP || keyCode == DOWN;
    	}
    	
    	private boolean isGameStarted() {
    		return engine.running && isMoveKey();
    	}
    	
        @Override
        public void keyPressed(KeyEvent keyEvent) {
        	keyCode = keyEvent.getKeyCode();
        	
        	if(isFunctionKey()) {
      			switch(keyCode) {
    			case F1:
    				Properties.Dark();
    				break;
    			case F2:
    				Properties.Sky();
    				break;
    			case F3:
    				Properties.Mud();
    				break;
    			case F4:
    				Properties.Rainbow();
    				break;
    			}
    			repaint();  // should be replaced returnning start game signal to window
        	}else if (!isGameStarted()) {
            	startGame(); // should be replaced returnning start game signal to window
            }else if (isMoveKey()) {
            	switch(keyCode) {
            	case LEFT:
            		engine.gameBoard.directionLeft();
            		break;
            	case RIGHT:
            		engine.gameBoard.directionRight();
            		break;
            	case UP:
            		engine.gameBoard.directionUp();
            		break;
            	case DOWN:
            		engine.gameBoard.directionDown();
            		break;
            	}
            }
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Window());
    }
}