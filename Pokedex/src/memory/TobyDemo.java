package memory;

import main.Pokedex;

public class TobyDemo extends main.Pokedex {
	
	public static TobyDemo game;
	public static TobyMarketScreen market;
	public static MemoryScreen memory;

	public static void main(String[] args) {
		game = new TobyDemo();
		Thread app = new Thread(game);
		app.start();
	}
	
	protected void initScreen() {
		memory = new MemoryScreen(944, 526);
		market = new TobyMarketScreen(944, 526);
		setScreen(market);
	}

}
