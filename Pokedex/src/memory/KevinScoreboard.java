package memory;

public class KevinScoreboard
{
	public KevinScoreboard() 
	{
		
	}
	public int updateScore(boolean correct, int level, int combo, int currentScore)
	{
		if(correct == true)
		{
			combo = +1;
			currentScore =+ (combo * level);
		}
		else
		{
			combo = 1;
		}
		return currentScore;
	} 
}
