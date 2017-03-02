package memory;

import guiPractice.GUIApplication;

public class FultonDemo extends GUIApplication {

	@Override
	protected void initScreen() {
		MemoryScreen ssf = new MemoryScreen(getWidth(), getHeight());
		setScreen(ssf);
	}

	public static void main(String[] args) {
		FultonDemo game = new FultonDemo();
		Thread app = new Thread(game);
		app.start();
	}
}
