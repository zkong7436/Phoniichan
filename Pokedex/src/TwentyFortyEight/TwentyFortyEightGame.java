package TwentyFortyEight;
public class TwentyFortyEightGame  {
	public static boolean gameOver;
	private int[][] board = new int [4][4];
	public TwentyFortyEightGame() {
		if(gameOver){
			//setBoard(board);
		//	NewSquare();
		}
		reset();		
	}
	public void reset(){
		if(gameOver){
			System.out.println("You've Lost !! :(" + " Click on restart button to play again.");
			//make a restart button somewhere
			
		}
	}//ss


}
