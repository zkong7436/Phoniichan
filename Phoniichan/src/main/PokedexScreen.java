package main;

import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.Visible;

public abstract class PokedexScreen extends ClickableScreen {

	public static Button toHome;
	public static Button togglePower;
	
	public static boolean locked;
	public static boolean on;
	
	public static HomeScreen home;
	public static LockScreen lock;
	
	private static int w;
	private static int h;
	
	public PokedexScreen(int width, int height) {
		super(width, height);
		w = width;
		h = height;
		home = new HomeScreen(w,h);
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		initRemainingItems(viewObjects);
		int buttonWidth = w/8;
		toHome = new Button(w/8,h/2+h/16, buttonWidth, buttonWidth, null, null, new Action(){

			@Override
			public void act() {
				if(on && !locked){
					Pokedex.game.setScreen(home);
				}
			}
			
		});
		togglePower = new Button(7*w/8,h/2+h/16, buttonWidth, buttonWidth, null, null, new Action(){

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
	}
	
	public abstract void initRemainingItems(ArrayList<Visible> viewObjects);

}
