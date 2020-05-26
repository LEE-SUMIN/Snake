import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Engine extends JPanel implements Runnable {
    public GameBoard gameBoard;
    public boolean running = false;

    public Engine() {
        this.gameBoard = new GameBoard();
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        // Ensures that it will run smoothly on Linux.
        if (System.getProperty("os.name").equals("Linux")) {
            Toolkit.getDefaultToolkit().sync();
        }

        setBackground(Properties.backgroundColor);
        gameBoard.paint(graphics);
    }
        
    private void sleep () {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    
    public void startGame() {
    	running = true;
    	Thread th = new Thread(this);
    	th.start();
    }

    public void run () {
        long lastTime = System.nanoTime();
        double elapsedTime = 0.0;
        double FPS = 15.0;

        // Game loop.
        while (true) {
            long now = System.nanoTime();
            elapsedTime += ((now - lastTime) / 1_000_000_000.0) * FPS;
            lastTime = System.nanoTime();

            if (elapsedTime >= 1) {
                gameBoard.update();
                //setTitle("Snake - Score: " + gameBoard.getScore());
                elapsedTime--;
                
            }

            sleep();
               
            //7/28/2017
            //If the rainbow theme is selected lets update the color
            if (Properties.getTheme() == Properties.Theme.Rainbow) Properties.changeColor();
                
            repaint();
        }
    }
}