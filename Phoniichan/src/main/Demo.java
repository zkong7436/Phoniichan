package main;

import guiPractice.GuiApplication;

@SuppressWarnings("serial")
public class Demo extends GuiApplication {

	public static Demo game;
	public static LockScreen screen;
	
	public static void main(String[] args){
		game = new Demo();
		Thread app = new Thread(game);
		app.start();
	}
	
	protected void initScreen() {
		screen = new LockScreen(944, 526);
		setScreen(screen);
	}

}
