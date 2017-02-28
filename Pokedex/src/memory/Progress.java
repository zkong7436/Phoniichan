package memory;

import java.awt.Color;
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
			g.setColor(new Color(20,55,90));
			g.fillRect(0, 0, 120, 50);
			g.setColor(Color.white);
			String go = "Game Over!";
			g.drawString(go, (120 - fm.stringWidth(go)) / 2, 20);
			g.drawString(round, (120 - fm.stringWidth(round)) / 2, 40);
			g.drawString(score, (120 - fm.stringWidth(round)) / 2, 60);
//			FultonDemo.game.setScreen(FultonDemo.kevinLeaderBoard);
		}else{
			g.setColor(new Color(220,255,230));
			g.fillRect(0, 0, 120, 50);
			g.setColor(Color.black);
			g.drawRect(0, 0, 120-1, 50-1);
			if(round !=null){
				g.drawString(round, (120 - fm.stringWidth(round))/2, 20);
				g.drawString(caught, (120 - fm.stringWidth(caught))/2, 40);
				g.drawString(score, (120 - fm.stringWidth(score))/2, 60);
				g.drawString(life, (120 - fm.stringWidth(life))/2, 60);
				g.drawString(combos, (120 - fm.stringWidth(combos))/2, 60);
				g.drawString(health, (120 - fm.stringWidth(health))/2, 60);
			}
		}
	}

}
