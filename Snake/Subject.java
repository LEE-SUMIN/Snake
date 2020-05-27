import java.util.ArrayList;

public abstract class Subject {
	public ArrayList<Observer> ob_list;
	
	public void attach(Observer o) {
		ob_list.add(o);
	}
	
	public void detach(Observer o) {
		ob_list.remove(o);
	}
	
	public void update() {
		for(Observer o : ob_list) o.update();
	}
}
