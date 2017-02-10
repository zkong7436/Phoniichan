package TwentyFortyEight;
import TwentyFortyEight.BoardInterface;
public class TwentyFortyEightGame  {
	private int gameOver = 0;
	private int[][] board = new int [4][4];
	public TwentyFortyEightGame() {
		if(gameOver == 0){
			//setBoard(board);
		//	NewSquare();
		}
		reset();		
	}
	public void reset(){
		if(gameOver == 1){
			System.out.println("You've Lost !! :(" + " Click on restart button to play again.");
			//make a restart button somewhere
			
		}
	}//ss


}
