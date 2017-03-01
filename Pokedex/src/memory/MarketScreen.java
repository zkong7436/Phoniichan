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
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class MarketScreen extends ClickableScreen implements Runnable, MouseMotionListener{
	
	private TextLabel label;
	private Button button;
	private ButtonToby[] buttons;
	private Graphic picture;
	private TextLabel description;
	private TextLabel abraNumber;

	public MarketScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void initAllObjects(ArrayList<Visible> viewObjects) {
		label = new TextLabel(20, 20, 760, 40, "AbraMarket");
		label.setFont("Papyrus");
		picture = new Graphic(40, 280, .05, "resources/sampleImages/White.png");
		description = new TextLabel(150, 225, 500, 100, "");
		button = new Button(40,230,100,45,"Return",Color.green,
			new Action() {
			public void act() {
				TobyDemo.game.setScreen(TobyDemo.memory);
			}
		});
		addAbrasCaught(viewObjects);
		addAnimation(viewObjects);
		addButtons(viewObjects);
		viewObjects.add(label);
		viewObjects.add(button);
		viewObjects.add(picture);
		viewObjects.add(description);
	}

	private void addAbrasCaught(ArrayList<Visible> viewObjects) {
		Progress abraCaught = new Progress();
        String x = abraCaught.getCaught();
        System.out.println(x);
        abraNumber.setX(40);
        abraNumber.setY(200);
        abraNumber.setText(x);
        viewObjects.add(abraNumber);	
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		String[] names = {"Potion", "Finer Potion", "Excellent Potion", "Superior Lure", "Legendary Candy"};
		String[] costs = {"x 3","x 8","x15","x16","x25"};
		String[] potionDescription = {"Restores 1 HP","Recovers 1 Life","Recovers 2 Life",
				"Use to lure out all hiding Abras for a few seconds","Legendary item that can be used to skip one level"};
		String[] address= {"resources/sampleImages/Potion1.png","resources/sampleImages/Potion2.png",
				"resources/sampleImages/Potion3.png","resources/sampleImages/Potion4.png",
				"resources/sampleImages/Potion5.png"};
		int numberOfButtons = 5;
		buttons = new ButtonToby[numberOfButtons];
		for(int i = 0; i <numberOfButtons; i++){ 
			buttons[i] = getAButton();
			buttons[i].setName(names[i]);
			buttons[i].setText(costs[i]);
			buttons[i].setX(195);
			buttons[i].setY(45*i+50);
			buttons[i].setPicture(address[i]);
			buttons[i].setLabel(potionDescription[i]);
//			final ButtonInterfaceToby b = buttons[i];
//			buttons[i].setAction(new Action() {
//				public void act() {
			
//				}
//			});
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
			for(int i = 0; i <numberInRow*rows; i++){
				BufferedImage cropped = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
				int leftMargin = 0;
				int topMargin = 0;
				int x1 = leftMargin+w*(i%numberInRow);
				int y1 = topMargin+h*(i/numberInRow);
				Graphics2D g = cropped.createGraphics();
				g.drawImage(icon.getImage(),0,0,w,h,x1,y1,x1+w,y1+h,null);
				a.addFrame(cropped,200);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		viewObjects.add(a);
		a.play();
	}

	private ButtonToby getAButton() {
		return new ButtonToby();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseMoved(MouseEvent m){
		for(ButtonToby b:buttons){
			if(b.isHovered(m.getX(), m.getY())){
				picture.loadImages(b.getPictureAddress(), .2);
				description.setFont("Papyrus");
				description.setText(b.getDescription());
			}
		}
	}
	
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public MouseMotionListener getMouseMotionListener(){
		return this;
	}
	
}
