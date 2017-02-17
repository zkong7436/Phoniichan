package memory;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import guiPractice.components.Action;
import guiPractice.components.AnimatedComponent;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class MarketScreen extends ClickableScreen implements Runnable, MouseMotionListener{
	
	private TextLabel label;
	private Button button;
	private ButtonInterfaceFulton[] buttons;
	private Graphic picture;
//	private int abraCaught;
//	private String[] cost;
	private Button potionButton;
	private TextLabel description;

	public MarketScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void initAllObjects(ArrayList<Visible> viewObjects) {
		label = new TextLabel(20, 20, 760, 40, "AbraMarket");
//		picture = new Graphic(25, 280, .4, "resources/sampleImages/Potion.png");
		button = new Button(25,225,100,45,"Return",Color.green,
			new Action() {
			public void act() {
				TobyDemo.game.setScreen(TobyDemo.memory);
			}
		}
		);
//		potionButton = new Button(180,40,300,33,"",null,
//			new Action() {
//			public void act() {
//				picture = new Graphic(25, 280, .4, "resources/sampleImages/Potion.png");
//				viewObjects.add(picture);
//				description = new TextLabel(125, 250, 500, 100, "A magical medicine used to fall in love with Abras.");
//				viewObjects.add(description);
//			}
//		});

		addAnimation(viewObjects);
		addButtons(viewObjects);
		viewObjects.add(label);
		viewObjects.add(button);
//		viewObjects.add(potionButton);
//		viewObjects.add(picture);
	}
	
//	private String[] addCostLabel(String[] cost) {
//		String[] costs = {"x10","x11","x12","x13","x14","x15"};
//		for(int i = 0; i <costs.length; i++ ){
//			cost[i] = costs[i];
//		}
//		return cost;
//	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		String[] names = {"Potion", "Alright Potion", "Good Potion", "Great Potion", "Best Potion", "Super Potion"};
		String[] costs = {"x1","x2","x4","x8","x16","x32"};
		String[] description = {"1","2","3","4","5","6"};
		String[] address= {"resources/sampleImages/Potion.png","resources/sampleImages/FloatAbra.png"};
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceFulton[numberOfButtons];
		for(int i = 0; i <numberOfButtons; i++ ){
			buttons[i] = getAButton();
			buttons[i].setName(names[i]);
			buttons[i].setText(costs[i]);
			buttons[i].setX(180);
			buttons[i].setY(45*i+40);
//			buttons[i].setPicture(address[i]);
			viewObjects.add(buttons[i]);
		}
	}
	
	private void addAnimation(ArrayList<Visible> viewObjects) {
		AnimatedComponent a = new AnimatedComponent(75,75,150,150);
		try{
			int numberInRow = 5;
			int rows = 1;
			int w = 55;
			int h = 50;
			
			ImageIcon icon = new ImageIcon("resources/sampleImages/FloatAbra.png");
			//create a for loop that will take a "sub-image" from the sprite grid
			for(int i = 0; i <numberInRow*rows; i++){
				//declare the "cropped image"
				BufferedImage cropped = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
				int leftMargin = 0;
				int topMargin = 0;
				int x1 = leftMargin+w*(i%numberInRow);
				int y1 = topMargin+h*(i/numberInRow);
				Graphics2D g = cropped.createGraphics();
				g.drawImage(icon.getImage(),0,0,w,h,x1,y1,x1+w,y1+h,null);
				a.addFrame(cropped,200);//change this for time on each frame
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		viewObjects.add(a);
		a.play();
	}

	private ButtonInterfaceFulton getAButton() {
		return new ButtonToby();
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
//		if(potionButton.isHovered(m.getX(), m.getY())){
//			potionButton.act();	
//		}else{
//			return;
//		}
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
