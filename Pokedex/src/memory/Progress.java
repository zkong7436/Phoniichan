package memory;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterface{
	
	private boolean gameOver;
	private String round;
	private String caught;
	private String score;
	private String combos;
	private String life;
	private String health;

	public Progress() {
		super(125, 500, 120, 50);
	}
	
	public void gameOver() {
		gameOver = true;
		update();
	}

	public void setLevel(int level) {
		round = "Level|" + level;
		update();
	}
	
	public void setCaught(int abrasCaught){
		caught = "Abra| " + abrasCaught;
		update();
	}
	 
	public void setPoint(int currentScore){
		score = currentScore + " Points";
		update();
	}
	
	public void setLife(int lives){
		life = "Lives| " + lives;
		update();
	}
	
	public void setCombo(int combo){
		combos = "Combo| x" +combo;
		update();
	}

	public void setHp(int hp){
		health = "Hp| " + hp;
		update();
	}
	
	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		g.setFont(new Font("Helvitca", Font.PLAIN, 12));
		if(gameOver){
//			FultonDemo.game.setScreen(FultonDemo.kevinLeaderBoard);
		}
	}

}
