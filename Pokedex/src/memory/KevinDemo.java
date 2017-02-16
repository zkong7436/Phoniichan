package memory;

import guiPractice.GuiApplication;

public class KevinDemo extends GuiApplication{

	public KevinDemo()
	{
	}

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
