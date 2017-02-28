package memory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

import guiPractice.components.Action;
import guiPractice.components.Component;
import guiPractice.components.Graphic;

public class ButtonToby extends Component implements ButtonInterfaceFulton{

	private Action action;
	private Color c;
	private String pictureAddress;
	private String name;
	private String displayName;
	private String cost;
	private String displayCost;
	private String font;
	private int size;
	
	public ButtonToby() {
		super(0, 0, 330, 35); 
		font = "Papyrus";
		size = 14;
		update();
	}
	
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.cyan);
		g.fillRoundRect(0, 0, 300, 33, 15, 15);
		g.setColor(Color.black);
		g.drawRoundRect(0, 0, 300, 33, 15, 15);
		if(displayName != null){
			g.setFont(new Font(font, Font.PLAIN, size));
			g.drawString(name, 10, 20);	
		}
		if(displayCost != null){
			g.setFont(new Font(font, Font.PLAIN, size));
			g.drawString(cost, 305, 20);
		}
	}
	
	public void act() {
		action.act();
	}

	public boolean isHovered(int x, int y) {
		return x>getX() && x<getX()+getWidth() && y>getY() && y<getY()+getHeight();
	}

	public void setAction(Action a) {
		this.action = a;
		update();
	}

	public void setColor(Color color) {
		this.c = color;
        update();
	}

	public void setName(String name) {
		this.name = name;
		displayName = name;
		update();
	}
	
	public void setPicture(String address) {
		this.pictureAddress = address;
		update();
	}

	@Override
	public Graphic getGraphic() {
		return null;
	}

	public void setText(String text) {
		this.cost = text;
		displayCost = text;
		update();
		
	}

	public String getPictureAddress(){
		return pictureAddress;
	}
	
	@Override
	public void dim() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub
	
	}
 
}
