import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {
    	private Engine engine = Engine.getEngine();
    	
        @Override
        public void keyPressed(KeyEvent keyEvent) {
        	int keyCode = keyEvent.getKeyCode();
        	
        /*	
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
        */
        	engine.keyInterruptHandler(keyCode);
        }
    }