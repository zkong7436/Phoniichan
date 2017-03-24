package TwentyFortyEight;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import guiPractice.components.Component;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;

/**
 * @author Student 8
 *
 */
public class MyDemo extends Component {
	static int[][]game = new int[4][4];
	Graphic[][] grid;
	public MyDemo(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */

	@Override
	public void update(Graphics2D g) {
//		a[0][0] = 2;
//		a[0][3] = 2;
		grid = new Graphic[4][4];
		int y = 1;
		int z = 1;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.black);
		String pics[] = { "resources/images2048/grass.jpg" , "resources/images2048/1.png",
		"resources/images2048/ivysaur.png", "resources/images2048/venasaur.png", "resources/images2048/4.png",
		"resources/images2048/5.png", "resources/images2048/6.png", "resources/images2048/7.png",
		"resources/images2048/8.png", "resources/images2048/9.png", "resources/images2048/10.png",
		"resources/images2048/11.png", "resources/images2048/12.png", "resources/images2048/13.png",
		"resources/images2048/14.png", "resources/images2048/15.png"}; // this is filler.. we don't have ivysaur sprite in images2048 yet
		//changeImages();
		int height = 55,width = 55;
		
//		Graphic picture1 = new Graphic(0,0,80,80,"resources/images2048/grass.jpg");

		for (int row = 0; row < game.length; row++) {
			for (int col = 0; col < game[row].length; col++) {
				y = game[row][col];
					if( y> 0){
						 z= (int) (Math.log(y)/Math.log(2));
					}
					else{
						z = 0;
					}
					Graphic picture1 = new Graphic(col*width,row*height,width,height,pics[0]);
					Graphic picture2 = new Graphic(col*width,row*height,width,height,pics[z]);
					if(grid == null) return;
					grid[row][col] = picture2;
					g.drawImage(picture1.getImage(), picture1.getX(), picture1.getY(), null);
					g.drawImage(picture2.getImage(), picture2.getX(), picture2.getY(), null);
					g.drawRect(col*width,row*height, width, height);
					
					// instead of "hiii" find a way to get the numbers from the front end
					// and replace it on drawString.		
			}	
		}
	}
	
}	


	
//	public void changeImages(){
//		// checks array values.
//		// if its 2 then it will be bulbasaur
//		// default (0) = grass img
//		for (int row = 0; row < board.length; row++) {
//			for (int col = 0; col < board[row].length; col++) {
//				changeBoard[row][col] = (int) Math.sqrt(board[row][col]);
// 			}
//		}
////		// if values of chaneBoard[row][col] == 0  -> img is grass
////		== 1 image is bulbasaur
////				 == 2 is ivysaur
//	}

	
	

//	public void start(){
//		ArrayList<Integer> Nrow = new ArrayList<Integer>();
//		ArrayList<Integer> Ncol = new ArrayList<Integer>();
//		for (int row = 0; row < board.length; row++) {
//			for (int col= 0; col < board.length; col++) {
//				if(board[row][col] == 0){
//					Nrow.add(row);
//					Ncol.add(col);
//					//will add row and col of all unfilled squares
//				}
//			}
//			for (int i = 0; i < 2; i++) {
//				int rndX = (int)(Nrow.size()*Math.random());
//				int rndY = (int)(Ncol.size()*Math.random());
//				int expo = (int) ((1 * Math.random()) + 1); // (0 or 1) + 1;
//				// 
//				// 2 ^1 = 2; 2^2 = 4;  it will random 
//				board[rndX][rndY] = (int) Math.pow(2, expo);
//				Nrow.remove(rndX);
//				Nrow.remove(rndY);
//				
//			}
//		}
//		
//	}
	
