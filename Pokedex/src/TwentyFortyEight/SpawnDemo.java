package TwentyFortyEight;

import java.util.ArrayList;
import java.util.Arrays;

public class SpawnDemo {
	private static int [][]board = new int [4][4];
	static ArrayList<Integer> Nrow = new ArrayList<Integer>();
	static ArrayList<Integer> Ncol = new ArrayList<Integer>();
	public static void main(String[] args) {
		System.out.println("Game starts and two random blank blocks are turned into 2s or 4s" );
		start();
		
		System.out.println("After you move (which is not shown), a new blank block is turned into a 2 or 4"+"");
		cont();
//		System.out.print(Arrays.deepToString(board));

	}
	
	public static void cont(){
		for(int i = 0; i<1; i++){
			int newExpo = (int)Math.pow(2, (int) (((2 * Math.random())) + 1));
			int newRndX = (int)(Nrow.size()*Math.random()) ;
			int newRndY = (int)(Ncol.size()*Math.random()) ;
			board[Nrow.get(newRndX)][Ncol.get(newRndY)] = newExpo;
			 Nrow.remove(newRndX);
			 Ncol.remove(newRndY);
		}
		System.out.print(Arrays.deepToString(board)+ "\n");
	}

	public static void start(){
	
	for (int row = 0; row < board.length; row++) {
		for (int col= 0; col < board.length; col++) {
			if(board[row][col] == 0){
				Nrow.add(row);
				Ncol.add(col);
				//will add row and col of all unfilled squares
			}
		}
			
		}
//	System.out.print(Nrow.size()+ "\n");
//	System.out.print(Ncol.size() + "\n");
	int rndX = 0,rndY = 0,nR = 0, nC = 0;
	for(int i = 0; i<2; i++){
		int expo = (int)Math.pow(2, (int) (((2 * Math.random())) + 1));
		 rndX = (int)(Nrow.size()*Math.random()) ;
		 rndY = (int)(Ncol.size()*Math.random()) ;
		 nR = Nrow.get(rndX);
		 nC = Ncol.get(rndY);	 
		 board[nR][nC] = expo;
		 Nrow.remove(rndX);
		 Ncol.remove(rndY);
	}
	System.out.print(Arrays.deepToString(board)+ "\n");
	
	//check that the arraylist changed
//	System.out.print(Nrow + "\n");
//	System.out.print(Nrow + "\n");
//	System.out.print(Ncol.size() + "\n");
//	System.out.print(Ncol.size() + "\n");
	
	//testing 
//	System.out.print(rndX + "\n");
//	System.out.print(rndY+ "aa"+ "\n" );
//	System.out.print(nR+ "\n");
//	System.out.print(Nrow.get(rndX)+ "\n");
//	System.out.print(nC+ "\n");
//	System.out.print(Ncol.get(rndY));
	//variables working
//	for (int i = 0; i < 2; i++) {
////		int rndX = (int)(Nrow.size()*Math.random()) -1;
////		int rndY = (int)(Ncol.size()*Math.random()) -1;
//		int expo = (int) ((1 * Math.random()) + 1); // (0 or 1) + 1;
//		// 
//		// 2 ^1 = 2; 2^2 = 4;  it will random 
////		board[Nrow.get(rndX-1)][Nrow.get(rndX-1)] = (int) Math.pow(2, expo);
////		Nrow.remove(Nrow.get(rndX));
////		Nrow.remove(Nrow.get(rndX));
//		board[0][i] = i+1;
//	}
	
//	for (Integer n : Nrow)
//	    System.out.println(n);
//	}
	//making sure I have 4 0s,1s,2s,...

	}
}
