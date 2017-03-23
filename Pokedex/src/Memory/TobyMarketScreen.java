package Memory;

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
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import main.Pokedex;
import Memory.TobyGraphic;

public class TobyMarketScreen extends main.PokedexScreen implements Runnable, MouseMotionListener{
	
	private Button button;
	public TobyButton[] buttons;
	private TextLabel label;
	public TextLabel description;
	private TextLabel abraNumber;
	private TobyGraphic picture;
	private TobyGraphic textbox;
	private static String FONT = "Tw Cen MT Condensed";
	private static int SIZE = 25;
	//testing abraCaught
//	public static int z;

	public TobyMarketScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		button = new Button(35,230,100,45,"Return",Color.yellow,
				new Action() {
			public void act() {
				Pokedex.game.setScreen(new MemoryScreen(getWidth(),getHeight()));
				button.setColor(Color.yellow);
			}
		});
		label = new TextLabel(25, 20, 760, 40, "AbraMarket");
		label.setFont(FONT);
		label.setSize(SIZE);
		description = new TextLabel(150, 225, 500, 100, "");
		description.setFont(FONT);
		description.setSize(SIZE);
		picture = new TobyGraphic(25, 280, .01, "resources/sampleImages/White.png");
		textbox = new TobyGraphic(123, 285, .54, "resources/sampleImages/PokeBox.png");
		
		addAnimation(viewObjects);
		addButtons(viewObjects);
		addAbrasCaught(viewObjects);
		viewObjects.add(label);
		viewObjects.add(button);
		viewObjects.add(textbox);
		viewObjects.add(picture);
		viewObjects.add(description);
	}

	public void addAbrasCaught(ArrayList<Visible> viewObjects) {
//		Progress caught = new Progress();
//		int x = caught.getCaught();
        abraNumber = new TextLabel(20, 15, 300, 210, "Abras Caught: "+MemoryScreen.abrasCaught);
        abraNumber.setFont(FONT);
        abraNumber.setSize(SIZE);
        viewObjects.add(abraNumber);	
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		String[] names = {"Potion", "Finer Potion", "Excellent Potion", "Superior Lure", "Legendary Candy"};
		int[] costs = {3,8,15,16,25};
		String[] potionDescription = {"Restores 1 HP","Recovers 1 Life","Recovers 2 Life",
				"Use to lure out all hiding Abras for a few seconds","Legendary item that can be used to skip one level"};
		String[] address= {"resources/sampleImages/Potion1.png","resources/sampleImages/Potion2.png",
				"resources/sampleImages/Potion3.png","resources/sampleImages/Potion4.png",
				"resources/sampleImages/Potion5.png"};
		int numberOfButtons = 5;
		buttons = new TobyButton[numberOfButtons];
		for(int i = 0; i <numberOfButtons; i++){ 
			buttons[i] = getAButton();
			buttons[i].setName(names[i]);
			buttons[i].setCost(costs[i]);
			buttons[i].setX(185);
			buttons[i].setY(45*i+50);
			buttons[i].setPicture(address[i]);
			buttons[i].setLabel(potionDescription[i]);
			
			final TobyButton b = buttons[i];
			buttons[i].setAction(new Action() {
				public void act() {	
					if(MemoryScreen.abrasCaught >= b.getCost()){
						validCost();
//						for(int i=0; i<buttons.length;i++){
//							if(buttons[i] = buttons[1]){
//								if(MemoryScreen.hp < 3){
//									MemoryScreen.hp++;
//									validCost();
//								}else{
//									description.setText("**You already have max HP**");
//									break;
//								}							
//							}
//							if(buttons[i] = buttons[2]){
//								if(MemoryScreen.lives < 3){
//									MemoryScreen.lives++;
//									validCost();
//								}else{
//									description.setText("**You already have max lives**");
//									break;
//								}
//							}
//							if(buttons[i] = buttons[3]){
//								if(MemoryScreen.lives <= 1){
//									MemoryScreen.lives += 2;
//									validCost();
//								}else{
//									description.setText("**You already have max lives**");
//									break;
//								}
//							}
//							if(buttons[i] = buttons[4]){
//								MemoryScreen.firstRound();
//							}
//							if(buttons[i] = buttons[5]){
//								MemoryScreen.level++;
//							}									
//						}						
					}else{
						description.setText("**Return to capture more Abras**");
						button.setColor(Color.red);
					}				
				}

				private void validCost() {
					int c = (MemoryScreen.abrasCaught) - (b.getCost());
					System.out.println("subtracted: "+c);
					abraNumber.setText("Abras Caught: "+c);
					MemoryScreen.abrasCaught = c;
					description.setText("**Return to use power up**");
					button.setColor(Color.green);					
				}
			});
			viewObjects.add(buttons[i]);
		}
	}
	
	private void addAnimation(ArrayList<Visible> viewObjects) {
		AnimatedComponent a = new AnimatedComponent(200,200,150,150);
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
				a.addFrame(cropped,220);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		viewObjects.add(a);
		a.setX(20);		
		a.setY(55);
		a.play();
	}

	private TobyButton getAButton() {
		return new TobyButton();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseMoved(MouseEvent m){
		for(TobyButton b:buttons){
			if(b.isHovered(m.getX(), m.getY())){
				picture.loadImages(b.getPictureAddress(), .2);
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