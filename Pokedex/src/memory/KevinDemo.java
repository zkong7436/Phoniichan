package memory;

import guiPractice.GUIApplication;

public class KevinDemo extends GUIApplication
{
	public static KevinDemo game;
	public static KevinLeaderboard leaderboard;
	public static MemoryScreen memory;
	
	public static void main(String[] args)
	{
		game = new KevinDemo();
		Thread app = new Thread(game);
		app.start();
	}
	
	protected void initScreen() 
	{
		leaderboard = new KevinLeaderboard(getWidth(), getHeight());
		memory = new MemoryScreen(getWidth(), getHeight());
		setScreen(leaderboard);
	}
}
