package memory;

import guiPractice.GUIApplication;

public class TobyDemo extends GUIApplication {
	
	public static TobyDemo game;
	public static MarketScreen market;
	public static MemoryScreen memory;

	public static void main(String[] args) {
		game = new TobyDemo();
		Thread app = new Thread(game);
		app.start();
	}
	
	protected void initScreen() {
		market = new MarketScreen(getWidth(), getHeight());
		memory = new MemoryScreen(getWidth(), getHeight());
		setScreen(market);
	}

}
