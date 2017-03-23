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
	public static int level;
	public static int abrasCaught;
	public static int currentScore;
	public static int lives;
	public static int combo;
	public static int hp;
	private int abraCount;
	private Graphic picture;
	private boolean acceptingInput;
	private ArrayList<Boolean> abra;
	private ArrayList<Boolean> checked;
	private ArrayList<ButtonInterfaceFulton> tiles;
	private ProgressInterface progress;
	private int increaseSize;
	private int startingSize;
	private int totalTiles;
	private Button button;
	private Button enter;
	
	public int getLevel(){
		return level;
	}
	
	public int getAbrasCaught(){
		return abrasCaught;
	}
	
	public void setAbrasCaught(int caught){
		abrasCaught = caught;
		progress.setCaught(caught);
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
		picture = new Graphic(331, 92, 380, 345, "resources/backthingy.png");
		viewObjects.add(picture);
		button = new Button(575,275,100,45,"Store",Color.green,
				new Action() {
			public void act() {
//				Pokedex.game.setScreen(new MarketScreen(getWidth(),getHeight());
			}
		});
		enter = new Button(55,230,70,70,"Home",new Color(0,0,0,0),new Action(){
			public void act() {
				Pokedex.game.setScreen(new HomeScreen(getWidth(),getHeight()));
			}
			
		});
		viewObjects.add(enter);
                intitializeItems();
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
		label = new TextLabel(getWidth()/2 - 150, getHeight()/2 -10, 400, 20, "Text");
		viewObjects.add(progress);
		viewObjects.add(label);
		viewObjects.add(button);
	}
	
	
	public void failedLevel(){
	 	System.out.println("HP IS GONE");
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
	}
	
	public void intitializeItems(){
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
//				 	        TobyMarketScreen.setCaught(abrascaught);
					 	progress.setCombo(combo);
				 	        progress.setCaught(abrasCaught);
						progress.setPoint(currentScore);
					}else{
						combo = 1;
						hp--;
						progress.setCombo(combo);
						progress.setHp(hp);
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
			System.out.println(increaseSize);
//			update(viewObjects);
		}
		Thread nextRound = new Thread(MemoryScreen.this);
		nextRound.start();
	}
		
	public void update(ArrayList<Visible> viewObjects) {
		viewObjects.remove(tiles);
		int idkName = 0;
		int idkName2 = 1;
		totalTiles = tiles.size() + increaseSize;
		
		for(int j = 0; j < increaseSize; j ++){
			abra.add(false);
			checked.add(false);
		}
		
		tiles.clear();
		
		for(int i = 0; i < totalTiles;i++){
			if(i % (Math.sqrt(totalTiles)) == 0){
				idkName++;
				idkName2 = 1;
			}
			ButtonInterfaceFulton b = new ButtonFulton();
			tiles.add(b);		
			tiles.get(i).setX(300+(55*idkName2));
			idkName2++;
			tiles.get(i).setY(100+(55*idkName));
			final ButtonInterfaceFulton c = tiles.get(i);
			tiles.get(i).setAction(new Action(){
				public void act(){
					if(acceptingInput){
						for(int index = 0;index < tiles.size(); index++){
							if(c == tiles.get(index)){
								if(!checked.get(index)){
									checked.set(index, true);
									c.flip();
									if(abra.get(index)){
										currentScore += (combo * level);
										combo++;
										abrasCaught++;
										progress.setCombo(combo);
										progress.setCaught(abrasCaught);
										progress.setPoint(currentScore);
									}else{
										combo = 1;
										hp--;
										progress.setCombo(combo);
										progress.setHp(hp);
									}
								}
							}
						}	
						if(pass()){
							level++;
							abraCount++;
							hp = 3;
							if(level % 3 == 0){
								increaseSize += 2;
								update(viewObjects);
							}
							Thread nextRound = new Thread(MemoryScreen.this);
							nextRound.start();
						}else if(hp == 0){
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
						}
					}
				}
			});
			viewObjects.add(tiles.get(i));
		}
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
		for(int i = 0; i < tiles.size(); i++){
			final ButtonInterfaceFulton b = tiles.get(i);
			b.setReveal(false);
			b.setChecked(false);
			abra.set(i, false);
			checked.set(i, false);
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
		System.out.println("acccepting input");
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
			if(abra.get(i) == true){
				c.flip();
			}
		}
	}

	private void generateAbras() {
		for(int i = 0; i < abraCount; i++){
			int place = (int) (Math.random() * abra.size());
			if(abra.get(place) != true){
				abra.set(place, true);
				System.out.println(place);
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
