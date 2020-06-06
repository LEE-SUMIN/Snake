
public class Engine extends Subject implements Runnable {
	private static Engine engine;
    private GameBoard gameBoard;
    private Painter painter;
    
    private boolean running = false;
    
    public static void initialize() {
    	engine = new Engine();
    }
    
    private Engine() {
        this.gameBoard = new GameBoard();
        this.painter = new Painter();
        
        attach(painter);
        attach(gameBoard);
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
    		painter.setBackground("Dark");
    		break;
    	case KeyManager.F2:
    		painter.setBackground("Sky");
    		break;
    	case KeyManager.F3:
    		painter.setBackground("Mud");
    		break;
    	case KeyManager.F4:
    		painter.setBackground("Rainbow");
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
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
    

}