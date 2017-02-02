/**
 * 
 */
package main;

import guiPractice.GuiApplication;

/**
 * @author Student8
 *
 */
public class Pokedex extends GuiApplication {

	/**
	 * 
	 */
	private static Pokedex game;
	
	public Pokedex() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see guiPractice.GuiApplication#initScreen()
	 */
	@Override
	protected void initScreen() { 
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		game = new Pokedex();
		Thread go = new Thread(game);
		go.start();
	}

}
