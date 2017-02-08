package main;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public abstract class PokedexScreen extends ClickableScreen implements PokedexScreenInterface {

	public static Button toHome;
	public static Button togglePower;
	public static Graphic blank;
	
	public static boolean locked;
	public static boolean on;
	
	public static HomeScreen home;
	public static LockScreen lock;
	
	public PokedexScreen(int width, int height) {
		super(width, height);
		home = new HomeScreen(width,height);
		lock = new LockScreen(width, height);
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		initRemainingItems(viewObjects);
		for(int i = 0; i < viewObjects.size(); i++){
			if(viewObjects.get(i).getX() < 330){
				viewObjects.remove(i);
			}
			if(viewObjects.get(i).getX() > 710){
				viewObjects.remove(i);
			}
			if(viewObjects.get(i).getY() < 90){
				viewObjects.remove(i);
			}
			if(viewObjects.get(i).getY() > 435){
				viewObjects.remove(i);
			}
		}
		Color buttonColor = new Color(105,168,79,0);
		toHome = new Button(815,220, 45, 45, "H", buttonColor, new Action(){

			@Override
			public void act() {
				if(on && !locked){
					Pokedex.game.setScreen(home);
				}
			}
			
		});
		togglePower = new Button(770,260, 45, 45, "P", buttonColor, new Action(){

			@Override
			public void act() {
				if(on){
					on = false;
				}else{
					on = true;
					Pokedex.game.setScreen(lock);
				}
			}
			
		});
		viewObjects.add(toHome);
		viewObjects.add(togglePower);
		viewObjects.add(blank);
	}
	
	public abstract void initRemainingItems(ArrayList<Visible> viewObjects);

}
