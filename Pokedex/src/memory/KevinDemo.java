package memory;

import guiPractice.GUIApplication;

public class KevinDemo extends GUIApplication
{
	@Override
	protected void initScreen() 
	{
		KevinLeaderboard scoreboard = new KevinLeaderboard(getWidth(), getHeight());
		setScreen(scoreboard);
	}
	public static void main(String args)
	{
		KevinDemo game = new KevinDemo();
		Thread app = new Thread(game);
		app.start();
	}
}
