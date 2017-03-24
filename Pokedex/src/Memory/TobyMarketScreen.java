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
	public ArrayList<TobyButtonInterface> buttons;
	private TextLabel label;
	public TextLabel description;
	private TextLabel abraNumber;
	private TobyGraphic picture;
	private TobyGraphic textbox;
	private TobyGraphic pokemart;
	private static String FONT = "Tw Cen MT Condensed";
	private static int SIZE = 22;

	public TobyMarketScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		button = new Button(620,327,60,30,"Return",Color.yellow,
				new Action() {
			public void act() {
//				Pokedex.game.setScreen(new MemoryScreen(getWidth(),getHeight()));
				button.setColor(Color.yellow);
			}
		});
		button.setFont(FONT);
		button.setSize(SIZE);
		label = new TextLabel(350, 100, 760, 40, "AbraMarket");
		label.setFont(FONT);
		label.setSize(28);
		description = new TextLabel(350, 300, 500, 100, "");
		description.setFont(FONT);
		description.setSize(SIZE);
		picture = new TobyGraphic(360, 270, .01, "resources/TobyMarket/White.png");
		textbox = new TobyGraphic(336, 365, .38, "resources/TobyMarket/PokeBox.png");
//		pokemart = new TobyGraphic(338, 93, 1.16, "resources/TobyMarket/PokeMart.png");
//		
//		viewObjects.add(pokemart);
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
//		MemoryScreen caught = new MemoryScreen(getWidth(),getHeight());
//        abraNumber = new TextLabel(360, 240, 300, 210, "Abras Caught: "+caught.getAbrasCaught());
		abraNumber = new TextLabel(345, 60, 300, 210, "Abras Caught: 40");
        abraNumber.setFont(FONT);
        abraNumber.setSize(SIZE);
        viewObjects.add(abraNumber);	
	}

	private void addButtons(ArrayList<Visible> viewObjects) {
		String[] names = {"Potion", "Finer Potion", "Excellent Potion", "Superior Lure", "Legendary Candy"};
		int[] costs = {3,8,15,16,25};
		String[] potionDescription = {"Restores 1 HP","Recovers 1 Life","Recovers 2 Life",
				"Use to lure out all hiding Abras for a few seconds","Legendary item that can be used to skip one level"};
		String[] address= {"resources/TobyMarket/Potion1.png","resources/TobyMarket/Potion2.png",
				"resources/TobyMarket/Potion3.png","resources/TobyMarket/Potion4.png",
				"resources/TobyMarket/Potion5.png"};
		int numberOfButtons = 5;
		buttons = new ArrayList<TobyButtonInterface>(numberOfButtons);
		for(int i = 0; i <numberOfButtons; i++){
			TobyButtonInterface temp = new TobyButton();
			buttons.add(temp);
			buttons.get(i).setName(names[i]);
			buttons.get(i).setCost(costs[i]);
			buttons.get(i).setX(478);
			buttons.get(i).setY(45*i+110);
			buttons.get(i).setPicture(address[i]);
			buttons.get(i).setLabel(potionDescription[i]);
			
			final TobyButtonInterface b = buttons.get(i);
//			buttons.get(i).setAction(new Action() {
//				MemoryScreen m = new MemoryScreen(getWidth(),getHeight());
//				public void act() {
//					if(m.getAbrasCaught() >= b.getCost()){
//						validCost();
//						for(int i=0; i<buttons.size();i++){
//							if(buttons.get(i) == buttons.get(1)){
//								if(m.getHp() < 3){
//									m.setHp(m.getHp()+1);
//									validCost();
//								}else{
//									description.setText("**You already have max HP**");
//									break;
//								}							
//							}
//							if(buttons.get(i) == buttons.get(2)){
//								if(m.getLives() < 3){
//									m.setLives(m.getLives()+1);
//									validCost();
//								}else{
//									description.setText("**You already have max lives**");
//									break;
//								}
//							}
//							if(buttons.get(i) == buttons.get(3)){
//								if(m.getLives() <= 1){
//									m.setLives(m.getLives()+2);
//									validCost();
//								}else{
//									description.setText("**You already have max lives**");
//									break;
//								}
//							}
//							if(buttons.get(i) == buttons.get(5)){
////								MemoryScreen.firstRound();
//							}
//							if(buttons.get(i) == buttons.get(6)){
//								m.setLevel(m.getLevel()+1);
//							}									
//						}						
//					}else{
//						description.setText("**Return to capture more Abras**");
//						button.setColor(Color.red);
//					}				
//				}
//
//				private void validCost() {
//					int c = (m.getAbrasCaught()) - (b.getCost());
//					System.out.println("subtracted: "+c);
//					abraNumber.setText("Abras Caught: "+c);
//					m.setAbrasCaught(c);
//					description.setText("**Return to use power up**");
//					button.setColor(Color.green);					
//				}
//			});
			viewObjects.add(buttons.get(i));
		}
	}
	
	private void addAnimation(ArrayList<Visible> viewObjects) {
		AnimatedComponent a = new AnimatedComponent(200,200,100,100);
		try{
			int numberInRow = 5;
			int rows = 1;
			int w = 55;
			int h = 50;
			
			ImageIcon icon = new ImageIcon("resources/TobyMarket/FloatAbra.png");
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
		a.setX(355);		
		a.setY(100);
		a.play();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseMoved(MouseEvent m){
		for(TobyButtonInterface b:buttons){
			if(b.isHovered(m.getX(), m.getY())){
				picture.loadImages(b.getPictureAddress(), .17);
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