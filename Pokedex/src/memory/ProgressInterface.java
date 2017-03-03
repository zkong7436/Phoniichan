package memory;

import guiPractice.components.Visible;

public interface ProgressInterface extends Visible{
	void setLevel(int level);
	
	void gameOver();
	
	void setCaught(int abrasCaught);
	
	void setPoint(int currentScore);
	
	void setLife(int lives);
	
	void setCombo(int combo);

	void setHp(int hp);
}
