package TwentyFortyEight;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;


import guiPractice.Screen;
import guiPractice.components.Component;

public class JosephBoard extends Component implements BoardInterface{
	private int[][] board = new int [4][4];
	
	public JosephBoard(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				g.drawRect(row*width + width, 30, width, height);

			}
		}
		
		
	}
	








	

}
