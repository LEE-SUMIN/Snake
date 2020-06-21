package snake;

import java.awt.event.KeyEvent;

class KeyManager {
	public final static int LEFT = KeyEvent.VK_LEFT;
	public final static int RIGHT = KeyEvent.VK_RIGHT;
	public final static int UP =  KeyEvent.VK_UP;
	public final static int DOWN = KeyEvent.VK_DOWN;
	public final static int F1 = KeyEvent.VK_F1;
	public final static int F2 = KeyEvent.VK_F2;
	public final static int F3 = KeyEvent.VK_F3;
	public final static int F4 = KeyEvent.VK_F4;
	public final static int F5 = KeyEvent.VK_F5; 
	
	static boolean isFunctionKey(int keyCode) {
		return keyCode == F1 || keyCode == F2 || keyCode == F3 || keyCode == F4 || keyCode == F5;
	}
	
	static boolean isMoveKey(int keyCode) {
		return keyCode == LEFT || keyCode == RIGHT || keyCode == UP || keyCode == DOWN;
	}
}
