package memory;

public class KevinScoreboard implements ScoreboardInterface
{
	public int level;
	public int combo;
	public int score;
	
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

	@Override
	public void setCombo(int combo) 
	{
		this.combo = combo;
	}

	@Override
	public void setLevel(int level) 
	{
		this.level = level;
	}

	@Override
	public void setScore(int score) 
	{
		this.score = score;
	} 
}
