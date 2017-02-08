package memory;

import java.util.ArrayList;

import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class MemoryScreen extends ClickableScreen implements Runnable {
	
	private boolean acceptingInput;
	private TextLabel label;
	private int roundNumber;
	private int combo;
	private int lives;
	private int hp;
	private int points;
	private int abraCount;
	private ArrayList<ArrayList<Button>> tiles;
	private boolean[][] abra;
		
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

	public void initAllObjects(ArrayList<Visible> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	private void firstRound() {
		randomMove();
		changeText("Click to Start");
		acceptingInput = false;
		roundNumber++;
		hp = 3;
		label.setText("");
		showAbra();
		acceptingInput = true;
	}
	 
	private void nextRound() {
		randomMove();
		acceptingInput = false;
		hp = 3;
		roundNumber++; 
		showAbra();
		acceptingInput = true;
	}
	
	private void showAbra() {
		// TODO Auto-generated method stub
		
	}
	
	private int randomMove() {
		
	}

	private void changeText(String s) {
		try{
			label.setText(s);
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
