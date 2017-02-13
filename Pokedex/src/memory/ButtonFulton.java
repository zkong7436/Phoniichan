package memory;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class ButtonFulton extends Component implements ButtonInterfaceFulton {

	private Action action;

	public ButtonFulton() {
		super(0, 0, h, h);
	}

	public void act() {
		action.act();
	}

	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX()+getWidth() && y > getY() && y<getY()+getHeight();
	}
	
	public void flip(){
		
	}
	
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public void setAction(Action a) {
		this.action = a;
		update();
	}

}
