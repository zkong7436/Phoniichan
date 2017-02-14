 package memory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Action;
import guiPractice.components.Component;
import guiPractice.components.Graphic;

public class ButtonFulton extends Component implements ButtonInterfaceFulton {

	private Action action;
	private Color color;
	private String pictureAddress;
	private ButtonContainer container;

	public ButtonFulton(ButtonContainer container) {
		super(0, 0, 0, 0); 
		this.container = container;
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
		if(pictureAddress != null){
			Graphic pic = new Graphic(x, y, w, h, imageLocation);
			container.getNumberOfButtons();
		}
	}

	public void setAction(Action a) {
		this.action = a;
		update();
	}

	public void setColor(Color green) {
		this.color = color;
        update();
	}

	@Override
	public void setPicture(String address) {
		// TODO Auto-generated method stub
		
	}

}
