package Memory;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import main.HomeScreen;
import main.Pokedex;

public class MemoryScreen extends main.PokedexScreen implements Runnable {
	
	private TextLabel label;
	private int level;
	private int abrasCaught;
	private int currentScore;
	private int lives;
	private int combo;
	private int hp;
	private int abraCount;
	private Graphic background;
	private boolean acceptingInput;
	private ArrayList<Boolean> abra;
	private ArrayList<Boolean> checked;
	private ArrayList<ButtonInterfaceFulton> tiles;
	private ProgressInterface progress;
	private int increaseSize;
	private int startingSize;
	private Button store;
	private Button home;
	
	public void setLevel(int level){
		this.level = level;
		progress.setLevel(this.level);
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setAbrasCaught(int caught){
		abrasCaught = caught;
		progress.setCaught(abrasCaught);
	}	
	
	public int getAbrasCaught(){
		return abrasCaught;
	}
	
	public void setScore(int score){
		currentScore = score;
		progress.setPoint(currentScore);
	}
	
	public int getScore(){
		return currentScore;
	}

	public void setLives(int lives){
		this.lives = lives;
		progress.setLife(this.lives);
	}
	
	public int getLives(){
		return lives;
	}
	
	public void setCombo(int combo){
		this.combo = combo;
		progress.setCombo(this.combo);
	}
	
	public int getCombo(){
		return combo;
	}
	
	public void setHp(int hp){
		this.hp = hp;
		progress.setHp(this.hp);
	}
	
	public int getHp(){
		return hp;
	}
	
	public MemoryScreen(int height, int width) {
		super(height, height);
		Thread app = new Thread(this);
		app.start();
	}
	
	public void run() {
		label.setText("");
		nextRound();
	}
	
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		background = new Graphic(331, 92, 380, 345, "resources/backthingy.png");
		viewObjects.add(background);
		
		store = new Button(575,275,100,45,"Store",Color.green,new Action(){
			public void act() {
				Pokedex.game.setScreen(new TobyMarketScreen(getWidth(),getHeight()));
			}
		});
		
		home = new Button(55,230,70,70,"Home",new Color(0,0,0,0),new Action(){
			public void act() {
				Pokedex.game.setScreen(new HomeScreen(getWidth(),getHeight()));
			}
		});
		
		initializeItems();
		
        	int idkName = 0;
        	int idkName2 = 1;
		
		for(int i = 0; i < startingSize + increaseSize; i++){
			if(i % (Math.sqrt(startingSize + increaseSize)) == 0){
				idkName++;
				idkName2 = 1;
			}
			ButtonInterfaceFulton b = new ButtonFulton();
			tiles.add(b);		
			tiles.get(i).setNumButtons(tiles.size());
			tiles.get(i).setX(300+(55*idkName2));
			idkName2++;
			tiles.get(i).setY(100+(55*idkName));
			
			final ButtonInterfaceFulton c = tiles.get(i);
			tiles.get(i).setAction(new Action(){
				public void act(){
					if(acceptingInput){
						checkCorrect(c);
						if(pass()){
							passedLevel();
						}else if(hp == 0){
							failedLevel();
						}
					}
				}
			});
			viewObjects.add(tiles.get(i));
		}
		
		progress = getProgress();
		label = new TextLabel(getWidth()/2 - 150, getHeight()/2 -50, 400, 20, "Text");
		viewObjects.add(progress);
		viewObjects.add(home);
		viewObjects.add(label);
		viewObjects.add(store);
	}
	
	public void setProgress(){
		progress.setLevel(level);
		progress.setCaught(abrasCaught);
		progress.setHp(hp);
		progress.setPoint(currentScore);
		progress.setLife(lives);
		progress.setCombo(combo);
	}
	
	public void failedLevel(){
		if(level != 1){
			hp = 3;
			lives--;
			level--;
			abraCount--;
			if(lives == 0){
				progress.gameOver();
				return;
			}
			Thread nextRound = new Thread(MemoryScreen.this);
			nextRound.start();
		}else{
			hp = 3;
			lives--;
			if(lives == 0){
				progress.gameOver();
				return;
			}
			Thread nextRound = new Thread(MemoryScreen.this);
			nextRound.start();
		}
	}
	
	public void initializeItems(){
       		increaseSize=5;
		startingSize=4;
		abraCount = 3;
		currentScore = 0;
		abrasCaught = 0;
		combo = 1;
		level = 1; 
		lives = 3;
		hp = 3;
		tiles = new ArrayList<ButtonInterfaceFulton>();
		abra = new ArrayList<Boolean>();
		checked = new ArrayList<Boolean>();
		
		for(int j = 0; j < startingSize + increaseSize; j ++){
			abra.add(false);
			checked.add(false);
		}
        }

	public void checkCorrect(ButtonInterfaceFulton c){
                for(int index = 0;index < tiles.size(); index++){
		        if(c == tiles.get(index)){
			        if(!checked.get(index)){
					checked.set(index, true);
					c.flip();
					if(abra.get(index)){
						currentScore += (combo * level);
						combo++;
					        abrasCaught++;
					 	setProgress();
					}else{
						combo = 1;
						hp--;
						setProgress();
					}
				}
			}
		}   
        }
	
	public void passedLevel(){
		level++;
		abraCount++;
		hp = 3;
		if(level % 3 == 0){
			increaseSize += 2;
			System.out.println("At this point the number of tiles should increase. "+
					  "However whenever I try to add new button the new buttons have no actions declared onto them."+
					  "Even though it should be the same." +
					  "All the back end still works but the buttons do not work as intended");
//			update(viewObjects);
		}
		Thread nextRound = new Thread(MemoryScreen.this);
		nextRound.start();
	}
	
	private ProgressInterface getProgress() {
		return new Progress();
	}

	public boolean pass(){
		for(int i = 0; i < tiles.size(); i++){
			if(abra.get(i) == true && checked.get(i) != true){
				return false;
			}
		}
		return true;
	}

	private void nextRound() {
		acceptingInput = false;
		setProgress();
		for(int i = 0; i < tiles.size(); i++){
			final ButtonInterfaceFulton b = tiles.get(i);
			b.setReveal(false);
			b.setChecked(false);
			abra.set(i, false);
			checked.set(i, false);
		}
		label.setText("");
		generateAbras();
		showAbras();
		wait(500);
		for(int i = 0; i < tiles.size(); i++){
			final ButtonInterfaceFulton b = tiles.get(i);
			b.setReveal(false);
			b.setChecked(false);
		}
		changeText("Wait for message to dissapear to start!");
		wait(1000);
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
			if(abra.get(i) == true){
				tiles.get(i).flip();
			}
		}
	}

	private void generateAbras() {
		for(int i = 0; i < abraCount; i++){
			int place = (int) (Math.random() * abra.size());
			if(abra.get(place) != true){
				abra.set(place, true);
			}else{
				i--;
			}
		}
		for(int j = 0; j < tiles.size(); j++){
			final ButtonInterfaceFulton c = tiles.get(j);
			if(abra.get(j) == true){
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
