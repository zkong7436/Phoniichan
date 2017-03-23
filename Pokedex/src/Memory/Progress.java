package Memory;

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
	private static final int WIDTH = 125;
	private static final int HEIGHT = 150;

	public Progress() {
		super(575, 100, WIDTH, HEIGHT);
	}
	
	public String getRound() {
		return round;
	}

	public String getCaught() {
		return caught;
	}

	public String getScore() {
		return score;
	}

	public String getCombos() {
		return combos;
	}
	
	public String getLife() {
		return life;
	}

	public String getHealth() {
		return health;
	}
	
	public void gameOver() {
		gameOver = true;
		update();
	}

	public void setLevel(int level) {
		round = "Level| " + level;
		update();
	}
	
	public void setCaught(int abrasCaught){
		caught = "Abra Candy| " + abrasCaught;
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
		g.setFont(new Font("Helvitca", Font.PLAIN, 16));
		if(gameOver){
			g.setColor(new Color(20,55,90));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.white);
			String go = "Game Over!";
			g.drawString(go, (120 - fm.stringWidth(go)) / 2, 20);
			g.drawString(round, (WIDTH - fm.stringWidth(round)) / 2, 40);
			g.drawString(score, (WIDTH - fm.stringWidth(round)) / 2, 60);
//			Pokedex.game.setScreen(new kevinLeaderBoard(getWidth(),getHeight());
		}else{
			g.setColor(new Color(220,255,230));
			g.fillRect(0, 0, WIDTH, HEIGHT);
			g.setColor(Color.black);
			g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
			if(round != null && caught != null && score != null && life !=null && combos != null && health != null){
				g.setFont(new Font("Helvitca", Font.PLAIN, 20));
				g.drawString(score, (WIDTH - fm.stringWidth(score))/2, 20);
				g.setFont(new Font("Helvitca", Font.PLAIN, 16));
				g.drawString(round, (WIDTH - fm.stringWidth(round))/2, 40);
				g.drawString(life, (WIDTH - fm.stringWidth(life))/2, 60);
				g.drawString(health, (WIDTH - fm.stringWidth(health))/2, 80);
				g.drawString(caught, (WIDTH - fm.stringWidth(caught))/2, 120);
				g.drawString(combos, (WIDTH - fm.stringWidth(combos))/2, 100);
			}
		}
	}

}
