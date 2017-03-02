package TwentyFortyEight;

import java.util.ArrayList;
import java.util.Arrays;

public class SpawnDemo implements SInterface{
	private boolean gameOver = false;
	private boolean move = false;
	private static int [][]board = new int [4][4];
	static ArrayList<Integer> Nrow = new ArrayList<Integer>();
	static ArrayList<Integer> Ncol = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		System.out.println("Game starts and two random blank blocks are turned into 2s or 4s" );
		start(board);
		System.out.println("After you move (which is not shown), a new blank block is turned into a 2 or 4"+"");
		cont(board);

		
		

	}
	public static void checkBlanks(int[][]board){
		for (int row = 0; row < board.length; row++) {
			for (int col= 0; col < board.length; col++) {
				if(board[row][col] == 0){
					Nrow.add(row);
					Ncol.add(col);
					//will add row and col of all unfilled squares
				}
			}
				
			}
	}

	public static void cont(int[][]board){
		checkBlanks(board);
		for(int i = 0; i<1; i++){
			int newExpo = (int)Math.pow(2, (int) (((2 * Math.random())) + 1));
			int newRndX = (int)(Nrow.size()*Math.random()) ;
			int newRndY = newRndX;
			board[Nrow.get(newRndX)][Ncol.get(newRndY)] = newExpo;

		}
		Nrow.clear();
		Ncol.clear();
		
	}
	
	

	public static void start(int [][]board){
	for(int i = 0; i<2; i++){
		checkBlanks(board);
		int newExpo = (int)Math.pow(2, (int) (((2 * Math.random())) + 1));
		int newRndX = (int)(Nrow.size()*Math.random()) ;
		int newRndY = newRndX;
		board[Nrow.get(newRndX)][Ncol.get(newRndY)] = newExpo;
		Nrow.clear();
		Ncol.clear();
		
	}
	
	}
	public static void checkStatus(){
//		for (int row = 0; row < board.length; row++) {
//			for (int col = 0; col < board.length; col++) {
//				if (board[row][col] != 0) {
//					
//				}
//			}
//		}
//		if (condition) {
//			
//		}
	}
	@Override
	public boolean gameOver() {
		return gameOver = true;
		
	}

}	