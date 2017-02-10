package TwentyFortyEight;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import guiPractice.Screen;
import guiPractice.components.Component;

public class JosephBoard extends Component implements BoardInterface{
	private int[][] board = new int [4][4];
	//private int sq1,sq2,sq3,sq4,sq5,sq6,sq7,sq8,sq9,sq10,sq11,sq12,sq13,sq14,sq15,s16;
	private static int[]checkBoard = new int[16];
	private int height,width = 400;
	private int x,y = 30;
	public JosephBoard(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	
	
	//set board will put the numbers in the 2d array into a 1d array so we can then use some kind of sort/method to
	//combine them

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				g.drawRect(col*width,row*height, width, height);
			}
		}
	}
	
//	public void makeSquare(Graphics2D g, int a){
//		Image[] pokemonOrder = new Image[16];
//		String pokemon = new String();
//		for(int i = 0; i < pokemonOrder.length; i++){
//			pokemon = //whatever the link is plus i;
//			pokemonOrder[i] = new Image(pokemon);
//		}
//		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		g.setColor(Color.black);
//		g.drawRect(getX(),getY(), width, height);
//		g.drawImage(pokemonOrder[a-1].getImage(), getX(), getY(),width, height);
//	}
	
	public void highScore(int userScore){
		int[] scores = new int[10];
		boolean gameOver = false;
		if(gameOver){
			for(int i = 0; i < scores.length; i++){
				if( scores[i] < userScore){
					scores[i] = userScore;
					for(int j = i; j < scores.length; j++){
						
					}
				}
			}
		}
	}//ss


	@Override
	public void setBoard(int[][] arr) {
		for (int row = 0,i = 0; row < arr.length; row++,i++) {
			for (int col = 0; col < arr.length; col++) {
				checkBoard[i] = arr[row][col];
			}
		}
		
	}
}