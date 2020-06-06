package snake;

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
	private static Window window;
	
    private int canvasWidth;
    private int canvasHeight; 
    
    public Window() {
    	/*
    	Properties p = Properties.Instance();
    	canvasWidth = p.getSquareSize() * p.getBoardColumns();
    	canvasHeight = p.getSquareSize() * p.getBoardRows();
    	
        createEngine();
        setWindowProperties();
        */
    }
    
    public static Window getWindow() {
    	if(window == null) window = new Window();
    	return window;
    }
    
    public void createAndShowGUI() {
    	Properties p = Properties.Instance();
    	canvasWidth = p.getSquareSize() * p.getBoardColumns();
    	canvasHeight = p.getSquareSize() * p.getBoardRows();
    	
        createEngine();
        setWindowProperties();
    }
    
    private void createEngine () {
    	Container cp = getContentPane();

        Engine.initialize();
        engine = Engine.getEngine();
        Painter painter = Painter.getPainter();
        
        painter.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        addKeyListener(new MyKeyAdapter());

        cp.add(painter);
    }

    private void setWindowProperties () {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Snake - Score: 0");
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);// Center window
    }
    
	@Override
	public void update() {
		int score = GameBoard.get_board().getScore();
		setTitle("Snake - Score: " + score);
	}
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Window.getWindow().createAndShowGUI();
			}
        	
        });
    }

}