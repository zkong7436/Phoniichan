package main;

import guiPractice.GUIApplication;
import realpokedex.PokedexList;
import realpokedex.Pokemon;

/**
 * @author Student8
 *
 */
@SuppressWarnings("serial")
public class Pokedex extends GUIApplication {

	/**
	 * static fields
	 */
	public static Pokedex game;
	public static PokedexScreen screen;
	
	public static void main(String[] args){
		game = new Pokedex();
		Thread app = new Thread(game);
		app.start();
	}
	
	protected void initScreen() {
		screen = new LockScreen(944, 526);
		setScreen(screen);
	}

}
