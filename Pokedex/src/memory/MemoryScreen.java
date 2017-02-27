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
	
	public int updateScore(boolean correct, int level, int combo, int currentScore){
		if(correct == true)
		{
			MemoryScreen.combo = +1;
			MemoryScreen.currentScore =+ (combo * level);
		}
		else
		{
			MemoryScreen.combo = 1;
		}
		return currentScore;
	}
	
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		increaseSize=5;
		startingSize=4;
		abraCount = 3;
		level = 1;
		lives = 3;
		int idkName = 0;
		int idkName2 = 0;
		logic = new boolean[9][9];
		tiles = new ArrayList<ButtonInterfaceFulton>();

		
		for(int i = 0; i < startingSize + increaseSize; i++){
			if(i % (Math.sqrt(double)((startingSize + increaseSize))));
			ButtonInterfaceFulton b = new ButtonFulton(null);
			tiles.add(b);		
			tiles.get(i).setX(55*idkName2);
			System.out.println("x is "+b.getX());
			idkName2++;
			tiles.get(i).setY(55*idkName);
			
			tiles.get(i).setAction(new Action(){
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
							flip.start();
							
							if(pass()){
								Thread nextRound = new Thread(MemoryScreen.this);
								nextRound.start();
							}
						//	if(tiles.get(i) == (logic[i][0]))
							if(lives == 0){
								progress.gameOver();
								return;
							}
						}
					}
			});
			viewObjects.add(tiles.get(i));
		}
		label = new TextLabel(getWidth()/2 - 100, getHeight()/2 -10, 200, 20, "Text");
		viewObjects.add(new ButtonFulton(null));
		viewObjects.add(label);
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
		hp = 5;
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
		nextRound();
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
//		ButtonInterfaceFulton b = null;
		for(int i = 0; i < tiles.size(); i++){
			final ButtonInterfaceFulton c = tiles.get(i);
			if(logic[i][0] == true){
				c.highlight();
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
