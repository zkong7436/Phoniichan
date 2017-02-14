package memory;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class MemoryScreen extends ClickableScreen implements Runnable {

	private boolean acceptingInput;
	private TextLabel label;
	private int combo;
	private int currentScore;
	private int level;
	private int lives;
	private int hp;
	private int rowSize;
	private int abraCount;
	private int abraCaught;
	private boolean[][] logic;
	private ButtonInterfaceFulton[] tiles;
 
	public int getCombo() {
		return combo;
	}
	
	public void setCombo(int combo) {
		this.combo = combo;
	}
	
	public int getCurrentScore() {
		return currentScore;
	}
	
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void setLives(int lives) {
		this.lives = lives;
	}
	
	public int getAbraCaught() {
		return abraCaught;
	}
	
	public void setAbraCaught(int abraCaught) {
		this.abraCaught = abraCaught;
	}
	
	public MemoryScreen(int height, int width) {
		super(height, height);
		Thread app = new Thread(this);
		app.start();
	}
	
	public void run() {
		label.setText("");
		firstRound();
		nextRound();
	}
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		int numberOfButtons = rowSize*rowSize;
		tiles = new ButtonInterfaceFulton[numberOfButtons];
		
		for(int i = 0; i < numberOfButtons; i++){
			 tiles[i] = getAButton();
             final ButtonInterfaceFulton b = tiles[i];
             b.setColor(Color.green);
//			 b.setX((int)());
//			 b.setY((int)());
			 tiles[i].setAction(new Action(){
					public void act(){
						if(acceptingInput){
							Thread flip = new Thread(new Runnable(){
								public void run(){
									try{
										Thread.sleep(400);
									}catch(Exception e){
										e.printStackTrace();
									}
								}
								
								
							});
						}
					}

			 });
			 viewObjects.add(tiles[i]);
		 }
	}

	private ButtonInterfaceFulton getAButton() {
		return new memory.ButtonFulton();
	}

	private void firstRound() { 
		rowSize = 3;
		lives = 5;
		generateAbras();
		changeText("Click to Start");
		acceptingInput = false;
		level++;
		hp = 3;
		label.setText("");
		showAbras();
		acceptingInput = true;
	}

	private void nextRound() {
		level++;
		if(level % 3 == 0){
			rowSize++;
		}
		generateAbras();
		acceptingInput = false;
		hp = 3;
		showAbras();
		acceptingInput = true;
	}

	private void showAbras() {
		
	}

	private void generateAbras() {
		int count = abraCount;
		while (count >= 0) {
			int place = (int) (Math.random() * logic.length);
			if (logic[place][0] != true) {
				logic[place][0] = true;
				count--;
			}
		}
	}

	private void changeText(String s) {
		try {
			label.setText(s);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
