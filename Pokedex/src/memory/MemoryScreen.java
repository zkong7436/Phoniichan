package memory;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextArea;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class MemoryScreen extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private TextArea area;
	public static int level;
	public static int abrasCaught;
	public static int currentScore;
	public static int lives;
	public static int combo;
	public static int hp;
	private int abraCount;
	private boolean acceptingInput;
	private boolean[][] logic;
	private ArrayList<ButtonInterfaceFulton> tiles;
	private ProgressInterface progress;
	private int increaseSize;
	private int startingSize;
	
	public MemoryScreen(int height, int width) {
		super(height, height);
		Thread app = new Thread(this);
		app.start();
	}
	
	public void run() {
		label.setText("");
		firstRound();
	}
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		increaseSize=5;
		startingSize=4;
		abraCount = 3;
		currentScore = 0;
		abrasCaught = 0;
		combo = 1;
		level = 1; 
		lives = 3;
		hp = 3;
		int idkName = 0;
		int idkName2 = 1;
		logic = new boolean[startingSize+increaseSize][startingSize+increaseSize];
		tiles = new ArrayList<ButtonInterfaceFulton>();

		
		for(int i = 0; i < startingSize + increaseSize; i++){
			if(i % (Math.sqrt(startingSize + increaseSize)) == 0){
				idkName++;
				idkName2 = 1;
			}
			ButtonInterfaceFulton b = new ButtonFulton(null);
			tiles.add(b);		
			tiles.get(i).setX(55*idkName2);
			System.out.println("x is "+b.getX());
			idkName2++;
			tiles.get(i).setY(55*idkName);
			final ButtonInterfaceFulton c = tiles.get(i);
			c.setThere(logic[i][0]);
			tiles.get(i).setAction(new Action(){
					public void act(){
						if(acceptingInput){
							Thread flip = new Thread(new Runnable(){
								public void run(){
									c.setChecked(true);
									c.flip();
								}
							});
							flip.start();
							
							if(pass()){
								Thread nextRound = new Thread(MemoryScreen.this);
								nextRound.start();
							}
							for(int index = 0;index < tiles.size(); index++){
								if(c == tiles.get(index)){
									if(!logic[index][1]){
										if(logic[index][0]){
											currentScore += (combo * level);
											combo++;
										}else{
											combo = 1;
											hp--;
										}
									}
								}
							}
							if(lives == 0){
								progress.gameOver();
								return;
							}
						}
					}
			});
			viewObjects.add(tiles.get(i));
		}
		progress = getProgress();
		label = new TextLabel(getWidth()/2 - 100, getHeight()/2 -10, 200, 20, "Text");
		viewObjects.add(progress);
		viewObjects.add(label);
	}
	
	private ProgressInterface getProgress() {
		return new Progress();
	}

	public boolean pass(){
		for(int i = 0; i < tiles.size(); i++){
			if(logic[i][0] == true && logic[i][1] != true){
				return false;
			}
		}
		return true;
	}
	
	public void update(ArrayList<Visible> viewObjects){
		
	}

	private void firstRound() {
		progress.setLevel(level);
		progress.setCaught(abrasCaught);
		progress.setHp(hp);
		progress.setPoint(currentScore);
		progress.setLife(lives);
		progress.setCombo(combo);
		generateAbras();
		changeText("Click to Start");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		acceptingInput = false;
		label.setText("");
//		showAbras();
		acceptingInput = true;
	}

	private void nextRound() {
		abraCount++;
		level++;
		if(level % 3 == 0){
			increaseSize++;
		}
		generateAbras();
		acceptingInput = false;
		hp = 3;
//		showAbras();
		acceptingInput = true; 
	}

	private void showAbras() { 
		ButtonInterfaceFulton b = null;
		for(int i = 0; i < tiles.size(); i++){
			final ButtonInterfaceFulton c = tiles.get(i);
			if(logic[i][0] == true){
				c.flip();
			}
		}
	}

	private void generateAbras() {
		for(int i = 0; i < abraCount; i++){
			int place = (int) (Math.random() * logic.length);
			if(logic[place][0] != true){
				logic[place][0] = true;
				System.out.println(place); 
			}else{
				i--;
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
