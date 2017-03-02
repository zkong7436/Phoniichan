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
	
	public void initAllObjects(ArrayList<Visible> viewObjects){
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
			idkName2++;
			tiles.get(i).setY(55*idkName);
			final ButtonInterfaceFulton c = tiles.get(i);
			tiles.get(i).setAction(new Action(){
					public void act(){
						if(acceptingInput){
							for(int index = 0;index < tiles.size(); index++){
								if(c == tiles.get(index)){
									if(!logic[index][1]){
										logic[index][1] = true;
										c.flip();
										if(logic[index][0]){
											currentScore += (combo * level);
											combo++;
											abrasCaught++;
											progress.setCombo(combo);
											progress.setCaught(abrasCaught);
											progress.setPoint(currentScore);
										}else{
											combo = 1;
											progress.setCombo(combo);
											hp--;
											progress.setHp(hp);
										}
									}
								}
							}
							
							if(pass()){
								if(level % 3 == 0){
									increaseSize += 2;
								}
								abraCount++;
								progress.setLevel(level++);
								progress.setHp(3);
								System.out.println("passed");
								Thread nextRound = new Thread(MemoryScreen.this);
								nextRound.start();
							}else if(hp == 0){
								System.out.println("HP IS GONE");
								lives--;
								Thread nextRound = new Thread(MemoryScreen.this);
								nextRound.start();
							}else if(lives == 0){
								progress.gameOver();
								return;
							}
							
						}
					}
			});
			viewObjects.add(tiles.get(i));
		}
		progress = getProgress();
		label = new TextLabel(getWidth()/2 - 150, getHeight()/2 -10, 400, 20, "Text");
		viewObjects.add(progress);
		viewObjects.add(label);
	}
	
	
	
	private ProgressInterface getProgress() {
		return new Progress();
	}

	public boolean pass(){
		for(int i = 0; i < tiles.size(); i++){
			if(logic[i][0] != logic[i][1]){
				return false;
			}
		}
		return true;
	}

	private void firstRound() {
		for(int i = 0; i < tiles.size(); i++){
			final ButtonInterfaceFulton b = tiles.get(i);
			b.setReveal(false);
			b.setChecked(false);
			logic[i][0] = false;
			logic[i][1] = false;
		}
		acceptingInput = false;
		progress.setLevel(level);
		progress.setCaught(abrasCaught);
		progress.setHp(hp);
		progress.setPoint(currentScore);
		progress.setLife(lives);
		progress.setCombo(combo);
		changeText("Wait for message to dissapear to start!");
		wait(1000);
		label.setText("");
		generateAbras();
		showAbras();
		wait(500);
		for(int i = 0; i < tiles.size(); i++){
			final ButtonInterfaceFulton b = tiles.get(i);
			b.setReveal(false);
			b.setChecked(false);
		}
		acceptingInput = true;
	}

	private void wait(int time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void showAbras() { 
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
			}else{
				i--;
			}
		}
		for(int j = 0; j < startingSize + increaseSize; j++){
			final ButtonInterfaceFulton c = tiles.get(j);
			if(logic[j][0] == true){
				System.out.println("not enough space");
				c.setThere(true);
			}else{
				c.setThere(false);
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
