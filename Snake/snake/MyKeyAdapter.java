package snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MyKeyAdapter extends KeyAdapter {
    	private Engine engine = Engine.getEngine();
    	
        @Override
        public void keyPressed(KeyEvent keyEvent) {
        	int keyCode = keyEvent.getKeyCode();
        	
        	engine.keyInterruptHandler(keyCode);
        }
    }