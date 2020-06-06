package snake;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.Iterator;

import javax.swing.JPanel;

public class Painter extends JPanel implements Observer{
	private Graphics2D g;
	private Engine engine = null;
	private static Painter painter;
	
    Properties p = Properties.Instance();
	
	public Painter() {
	}
	
	public static Painter getPainter() {
		if(painter == null) painter = new Painter();
		return painter;
	}
	
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        if(engine == null) engine = Engine.getEngine();
        g = (Graphics2D) graphics;
        
        // Ensures that it will run smoothly on Linux.
        if (System.getProperty("os.name").equals("Linux")) {
            Toolkit.getDefaultToolkit().sync();
        }

        setBackground(p.getBackgroundColor());
        update();
    }
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
		paintSnake();
		paintFood();

        if (p.getTheme() == Theme.Rainbow) p.changeBackGroundColor();
        
		repaint();
	}

	public void setBackground(String color) {
		switch(color) {
		case "Dark":
			p.Dark();
			break;
		case "Sky":
			p.Sky();
			break;
		case "Mud":
			p.Mud();
			break;
		case "Rainbow":
			p.Rainbow();
			break;
		}
		
		repaint();
	}
	
    private void paintSnake () {
    	Snake snake = Snake.get_snake();
    	
        int x, y;
        int corner = p.getSquareSize()  / 3;
        Iterator<Square> it = snake.iterator();
        
        while(it.hasNext()) {
        	Square sq = it.next();
            x = sq.getX() * p.getSquareSize() ;
            y = sq.getY() * p.getSquareSize() ;

            g.setColor(p.getSnakeColor());
            g.fillRoundRect(x + 1, y + 1, p.getSquareSize()  - 2,
            		p.getSquareSize()  - 2, corner, corner);
        }

    }

    private void paintFood () {
    	Food fd = GameBoard.get_board().get_food();
    	
        int x = fd.get_X() * p.getSquareSize();
        int y = fd.get_Y() * p.getSquareSize();
        int corner = p.getSquareSize() / 3;

        g.setColor(p.getFoodColor());
        g.fillRoundRect(x + 1, y + 1, p.getSquareSize() - 2,
        		p.getSquareSize() - 2, corner, corner);
    }

}
