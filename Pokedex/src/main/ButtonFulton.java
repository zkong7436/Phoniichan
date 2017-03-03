package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import guiPractice.components.Action;
import guiPractice.components.Component;
import guiPractice.components.Graphic;

public class ButtonFulton extends Component implements ButtonInterfaceFulton {

	private Action action;
	private Color color;
	private String pictureAddress;
	private BufferedImage image;
	private Color displayColor;
	private boolean checked;
	private boolean isThere;
	private boolean reveal;
	private int numButtons;

	public ButtonFulton() {
		super(55, 55, 50, 50); 
	}

	public void act() {
		action.act();
	}

	public boolean isHovered(int x, int y) {
		return x > getX() && x < getX()+ getWidth() && y > getY() && y < getY() + getHeight();
	}
	
	public void flip(){
		if(!checked){
			if(isThere){
				reveal = true;
				update();
			}else{
				reveal = true;
				update();
			}
		}
		checked = true;
	}
	
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(reveal){
			if(isThere){
//				ImageIcon icon = new ImageIcon("resources/Abra.png");
//				image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_ARGB);
//				g = image.createGraphics();
//				g.drawImage(icon.getImage(), 0, 0, 0, 0, 0, 0, 50, 50, null);
				g.setColor(Color.white);
				g.fillRoundRect(0, 0, 50, 100, 5, 10);
			}else{
				g.setColor(Color.blue);
				g.fillRoundRect(0, 0, 50, 100, 5, 10);
			}
//		if(pictureAddress != null){
//			Graphic pic = new Graphic(x, y, w, h, imageLocation);
//			container.getNumberOfButtons();
//		}
		}else{
			g.setColor(Color.green);
			g.fillRoundRect(0, 0, 50, 100, 5, 10);
			g.setColor(Color.black);
			g.drawRoundRect(0, 0, 50-1, 50-1, 5, 10);
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
	
	@Override
	public void setPicture(String address) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setText(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLabel(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public void setThere(boolean isThere) {
		this.isThere = isThere;
	}

	public void setReveal(boolean b) {
		this.reveal = b;
		update();
	}

	public void setNumButtons(int numButtons) {
		this.numButtons = numButtons;
	}
}
