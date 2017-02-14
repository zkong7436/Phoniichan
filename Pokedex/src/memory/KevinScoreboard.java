package memory;

public class KevinScoreboard
{
	private int lives;
	private int combo;
	private int level;
	private int currentScore;
	public KevinScoreboard() 
	{
		combo = 1;
		level = 1;
		lives = 3;
		currentScore = 0;
	}
	
	public int increaseScore(boolean correct)
	{
		if(correct == true)
		{
			combo = +1;
			currentScore =+ addScore(combo, level);
		}
		else
		{
			combo = 1;
			lives -= 1;
		}
		return currentScore;
	} 
	private int addScore(int combo, int level)
	{
		return combo * level;
	}
}
