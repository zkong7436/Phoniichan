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
	private int rowSize;
	private int abraCount;
	private boolean acceptingInput;
	private boolean[][] logic;
	private ButtonInterfaceFulton[] tiles;
	private ProgressInterface progress;
	
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
		abraCount = 3;
		rowSize = 3;
		int idkName = 0;
		int idkName2 = 0;
		int numberOfButtons = rowSize * rowSize;
		tiles = new ButtonInterfaceFulton[numberOfButtons];
		
		for(int i = 0; i < numberOfButtons; i++){
			if(i%rowSize == 0){
				idkName++;
				idkName2 = 1;
			}
			tiles[i] = getAButton();
            tiles[i].setColor(Color.green);
			tiles[i].setX(55*idkName2);
			idkName2++;
			tiles[i].setY(55*idkName);
			final ButtonInterfaceFulton b = tiles[i];
			tiles[i].setAction(new Action(){
					public void act(){
						if(acceptingInput){
							Thread flip = new Thread(new Runnable(){
								public void run(){
									b.highlight();
									try{
										Thread.sleep(400);
									}catch(Exception e){
										e.printStackTrace();
									}
									b.dim();
								}
							});
							flip.start();
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
		progress.setLife(5);
		generateAbras();
		changeText("Click to Start");
		acceptingInput = false;
//		progress.level++;
		progress.setLife(3);
		label.setText("");
//		showAbras();
		acceptingInput = true;
		for(int i = 0; i < tiles.length; i++){
			System.out.println(tiles[i]);
		}
		nextRound();
	}

	private void nextRound() {
//		level++;
//		if(progress.level % 3 == 0){
//			rowSize++;
//		}
		generateAbras();
		acceptingInput = false;
//		hp = 3;
//		showAbras();
		acceptingInput = true;
	}

	private void showAbras() {
		ButtonInterfaceFulton b = null;
		for(int i = 0; i < tiles.length; i++){
			final ButtonInterfaceFulton b = tiles[i];
			if(
		}
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
