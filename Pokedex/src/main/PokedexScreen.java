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
	
	public PokedexScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		Color buttonColor = new Color(105,168,79,0);
		toHome = new Button(815,220, 45, 45, "H", buttonColor, new Action(){

			@Override
			public void act() {
				if(on && !locked){
					Pokedex.game.setScreen(new HomeScreen(getWidth(),getHeight()));
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
					Pokedex.game.setScreen(new LockScreen(getWidth(), getHeight()));
				}
			}
			
		});
		blank = new Graphic(0,0,"resources/DefaultScreen.jpg");
		viewObjects.add(toHome);
		viewObjects.add(togglePower);
		viewObjects.add(blank);
		initRemainingItems(viewObjects);
	}
	
	public abstract void initRemainingItems(ArrayList<Visible> viewObjects);

}
/*
max x: 710
min x: 330
max y: 435
min y: 90
approx. 380x345
*/