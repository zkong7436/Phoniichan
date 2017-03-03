package memory;

import guiPractice.GuiApplication;
import main.KevinLeaderboard;

public class KevinDemo extends GuiApplication
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
