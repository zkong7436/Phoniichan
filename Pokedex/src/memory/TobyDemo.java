package memory;

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
		market = new TobyMarketScreen(getWidth(), getHeight());
		memory = new MemoryScreen(getWidth(), getHeight());
		setScreen(market);
	}

}
