package main;

import guiPractice.GuiApplication;

public class FultonDemo extends GuiApplication {
	
	@Override
	protected void initScreen() {
		MemoryScreen ssf = new MemoryScreen(944, 526);
		setScreen(ssf);
	}

	public static void main(String[] args) {
		FultonDemo game = new FultonDemo();
		Thread app = new Thread(game);
		app.start();
	}
}
