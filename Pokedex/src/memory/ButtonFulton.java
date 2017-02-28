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
	private Color displayColor;
	private boolean highlight;
	private final Color DIM = new Color(105, 105, 105);

	public ButtonFulton(ButtonContainer container) {
		super(0, 0, 50, 50); 
		this.container = container;
	}

	public void act() {
		action.act();
	}

	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX()+ getWidth() && y > getY() && y < getY() + getHeight();
	}
	
	public void flip(){
		
	}
	
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		if(pictureAddress != null){
//			Graphic pic = new Graphic(x, y, w, h, imageLocation);
//			container.getNumberOfButtons();
//		}
		g.setColor(Color.green);
		g.fillRoundRect(0, 0, 50, 100, 5, 10);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, 50-1, 50-1, 5, 10);
		if(highlight){
			g.setColor(Color.white);
		}
	}

	public void setAction(Action a) {
		this.action = a;
		update();
	}

	public void setColor(Color color) {
		this.color = color;
		displayColor = Color.green;
        update();
	}
	
	public void highlight() {
	    displayColor = this.color;
		highlight = true;
		update();
	}

	public void dim() {
		displayColor = DIM;
		highlight = false;
		update();
	}

	@Override
	public void setPicture(String address) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Graphic getGraphic() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setText(String string) {
		// TODO Auto-generated method stub
		
	}

}
