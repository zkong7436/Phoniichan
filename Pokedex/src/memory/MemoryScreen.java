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
	private int lives;
	private int hp;
	private int rowSize;
	private int abraCount;
	private int abraCaught;
	private boolean[] checked;
	private boolean[] abra;
	private ButtonInterfaceFulton[] tiles;
 
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
		roundNumber++;
		hp = 3;
		label.setText("");
		showAbra();
		acceptingInput = true;
	}

	private void nextRound() {
		roundNumber++;
		if(roundNumber % 3 == 0){
			rowSize++;
		}
		generateAbras();
		acceptingInput = false;
		hp = 3;
		showAbra();
		acceptingInput = true;
	}

	private void showAbra() {
		// TODO Auto-generated method stub
		
	}

	private void generateAbras() {
		int count = abraCount;
		while (count >= 0) {
			int place = (int) (Math.random() * abra.length);
			if (abra[place] != true) {
				abra[place] = true;
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
