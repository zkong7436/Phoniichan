package memory;

import guiPractice.GuiApplication;

public class TobyDemo extends GuiApplication {

	public TobyDemo() {
		// TODO Auto-generated constructor stub
	}

	protected void initScreen() {
		MarketScreen market = new MarketScreen(getWidth(), getHeight());
		setScreen(market);
	}

	public static void main(String[] args) {
		TobyDemo game = new TobyDemo();
		Thread app = new Thread(game);
		app.start();

	}

}
