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
	
	private TextLabel label;
	private int combo;
	private int currentScore;
	private int level;
	private int lives;
	private int hp;
	private int rowSize;
	private int abraCount;
	private int abraCaught;
	private boolean acceptingInput;
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
		//nextRound();
	}
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		rowSize = 5;
		int idkName = 1;
		int idkName2 = 1;
		int numberOfButtons = rowSize * rowSize;
		tiles = new ButtonInterfaceFulton[numberOfButtons];
		
		for(int i = 0; i < numberOfButtons; i++){
			if(i%rowSize == 0){
				idkName++;
				idkName2 = 1;
			}
			tiles[i] = getAButton();
			final ButtonInterfaceFulton b = tiles[i];
            tiles[i].setColor(Color.green);
			tiles[i].setX(10+(50*idkName2));
			idkName2++;
			tiles[i].setY(10+(50*idkName));
			tiles[i].setAction(new Action(){
					public void act(){
						if(acceptingInput){
							Thread flip = new Thread(new Runnable(){
								public void run(){
									level++;
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
	
	public void update(ArrayList<Visible> viewObjects){
		
	}
	
	
	private ButtonInterfaceFulton getAButton() {
		return new memory.ButtonFulton(null);
	}

	private void firstRound() { 
		lives = 5;
//		generateAbras();
		changeText("Click to Start");
		acceptingInput = false;
		level++;
		hp = 3;
		label.setText("");
//		showAbras();
		acceptingInput = true;
	}

	private void nextRound() {
		level++;
		if(level % 3 == 0){
			rowSize++;
		}
//		generateAbras();
		acceptingInput = false;
		hp = 3;
//		showAbras();
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
