package memory;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class MarketScreen extends ClickableScreen implements Runnable, MouseMotionListener{
	
	private TextLabel label;
	private ButtonInterfaceFulton[] buttons;
	private Graphic picture;
	private int abraCaught;

	public MarketScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		
		label = new TextLabel(20, 20, 760, 40, "AbraMarket");
		
		viewObjects.add(label);
		
	}
	
	private void addButtons(ArrayList<Visible> viewObjects) {
		String[] names = {"Potion", "Potion2", "Potion3", "Potion4", "Potion5", "Potion6"};
		String[] description = {"","","","","",""};
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceFulton[numberOfButtons];
		for(int i = 0; i <numberOfButtons; i++ ){
			buttons[i] = getAButton();
//			buttons[i].setName(names[i]);
			buttons[i].setY(50*i);
			viewObjects.add(buttons[i]);
		}
	}

	private ButtonInterfaceFulton getAButton() {
		return new ButtonFulton(0,0,100,40,"testButtons",Color.white,null);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseMoved(MouseEvent m){
		for(ButtonInterfaceFulton b:buttons){
			if(b.isHovered(m.getX(), m.getY())){
				Graphic g = b.getGraphic();
				picture = g;
			}
		}
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
