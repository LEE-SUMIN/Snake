import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Engine extends Subject implements Runnable {
	private static Engine engine = new Engine();
    private GameBoard gameBoard;
    
    private Window window;
    private Painter painter;
    
    private boolean running = false;
    
    private Engine() {
        this.gameBoard = new GameBoard();
        this.painter = new Painter();
        
        attach(painter);
        attach(gameBoard);
        //attach(window);
    }
    
    public static Engine getEngine() {
    	return engine;
    }
    
    public Painter getPainter() {
    	return painter;
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
    // keyboard handling
    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void keyInterruptHandler(int keyCode) {
    	if(!engine.running && !KeyManager.isFunctionKey(keyCode)) {
    		startGame();
    	}else if(KeyManager.isFunctionKey(keyCode)) {
    		selectBackGround(keyCode);
    	}
    	
    	if(KeyManager.isMoveKey(keyCode)) {
    		selectMovement(keyCode);
    	}
    	
    }

	private void selectBackGround(int keyCode) {
    	switch(keyCode) {
    	case KeyManager.F1:
    		Properties.Dark();
    		break;
    	case KeyManager.F2:
    		Properties.Sky();
    		break;
    	case KeyManager.F3:
    		Properties.Mud();
    		break;
    	case KeyManager.F4:
    		Properties.Rainbow();
    		break;
    	}
	}
	
    private void selectMovement(int keyCode) {
		switch(keyCode) {
		case KeyManager.LEFT:
			gameBoard.directionLeft();
			break;
		case KeyManager.RIGHT:
			gameBoard.directionRight();
			break;
		case KeyManager.UP:
			gameBoard.directionUp();
			break;
		case KeyManager.DOWN:
			gameBoard.directionDown();
			break;
		}
	}
    
    //////////////////////////////////////////////////////////////////////////////////////////////////
	//paint managerment
    //////////////////////////////////////////////////////////////////////////////////////////////////
    public void setWindow(Window _window) {
    	this.window = _window;
    }
    

    
    public Snake getSnake() {
    	return gameBoard.getSnake();
    }
    
    public int getFoodX() {
    	return gameBoard.getFoodX();
    }
    
    public int getFoodY() {
    	return gameBoard.getFoodY();
    }
    
    
    public void startGame() {
    	running = true;
    	Thread th = new Thread(this);
    	th.start();
    }

	public int getScore() {
		return gameBoard.getScore();
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
                elapsedTime--;
                
            }

            sleep();
            
            update();    
        }
    }
    
    private void sleep () {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    

}