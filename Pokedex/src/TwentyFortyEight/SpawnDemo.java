package TwentyFortyEight;

import java.util.ArrayList;
import java.util.Arrays;

public  class SpawnDemo implements SpawnInterface{
	private boolean gameOver = false;
	private boolean move = false;
	private static int [][]board = new int [4][4];
	static ArrayList<Integer> Nrow = new ArrayList<Integer>();
	static ArrayList<Integer> Ncol = new ArrayList<Integer>();
	public static SpawnDemo spawn = new SpawnDemo();
	public static void main(String[] args) {

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
	public void start(int[][]board) {
		for(int i = 0; i<2; i++){
			checkBlank(board);
			int newExpo = (int)Math.pow(2, (int) (((2 * Math.random())) + 1));
			int newRndX = (int)(Nrow.size()*Math.random()) ;
			int newRndY = newRndX;
			board[Nrow.get(newRndX)][Ncol.get(newRndY)] = newExpo;
			Nrow.clear();
			Ncol.clear();
		}
			
	}
	@Override
	public void cont(int[][]board) {
		checkBlank(board);
		for(int i = 0; i<1; i++){
			int newNum = 0;
			
			int determine = (int) (10*Math.random()+1);
			if (determine<4) {
				newNum = 4;
			}else{
				newNum = 2;
			}
			
			int newRndX = (int)(Nrow.size()*Math.random()) ;
			
			int newRndY = newRndX;
			board[Nrow.get(newRndX)][Ncol.get(newRndY)] = newNum;

		}
		Nrow.clear();
		Ncol.clear();
		
	}
	public void checkBlank(int[][]board) {
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

}	
