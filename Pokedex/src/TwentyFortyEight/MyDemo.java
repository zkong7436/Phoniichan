/**
 * 
 */
package TwentyFortyEight;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import guiPractice.components.Component;

/**
 * @author Student 8
 *
 */
public class MyDemo extends Component {
	int[][]a = new int[4][4];
	public MyDemo(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		int height = 40,width = 40;
		for (int row = 0; row < a.length; row++) {
			for (int col = 0; col < a.length; col++) {
				g.drawRect(col*width,row*height, width, height);
				if(a[row][col]== 0){

					
				}
			}
		}
		
	}

	public void start(){
		ArrayList<Integer> Nrow = new ArrayList<Integer>();
		ArrayList<Integer> Ncol = new ArrayList<Integer>();
		for (int row = 0; row < a.length; row++) {
			for (int col= 0; col < a.length; col++) {
				if(a[row][col] == 0){
					Nrow.add(row);
					Nrow.add(col);
				}
			}
			int expo = (int) ((1 * Math.random()) + 1); // (0 or 1) + 1;
			// 
			// 2 ^1 = 2; 2^2 = 4;  it will random 
		}
		
	}
	

}
