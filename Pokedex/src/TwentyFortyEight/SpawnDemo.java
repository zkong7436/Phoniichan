package TwentyFortyEight;

import java.util.ArrayList;
import java.util.Arrays;

public class SpawnDemo {
	private static int [][]board = new int [4][4];
	static ArrayList<Integer> Nrow = new ArrayList<Integer>();
	static ArrayList<Integer> Ncol = new ArrayList<Integer>();
	public static void main(String[] args) {
		System.out.println("Game starts and two random blank blocks are turned into 2s or 4s" );
		start(board);
		System.out.println("After you move (which is not shown), a new blank block is turned into a 2 or 4"+"");
		cont(board);

		//14 cont to print out last 14 blanks
//		cont();
//		cont();
		//cont x16 to make sure every blank is filled and working.
		
		
		  // resetArrayList() wasn't working... ended up finding out the arraylist.clear();
//		System.out.println("RESET");
//		board[0][0] = 2;
//		checkBlanks();
//		for (int n = 0; n < Nrow.size(); n++) {
//			System.out.print(Nrow.get(n)+ ","+ Ncol.get(n) + "\n");
//		}
//		Nrow.clear();
//		System.out.print(Nrow.size());
//		checkBlanks();
//		for (int n = 0; n < Nrow.size(); n++) {
//			System.out.print(Nrow.get(n)+ ","+ Ncol.get(n) + "\n");
//		}
		

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
//	public static void resetArrayList(){
//		for (int sz = 0; sz < Nrow.size(); sz++) {
//			Nrow.remove(sz);
//			Ncol.remove(sz);
//		}
//	}
	public static void cont(int[][]board){
		checkBlanks(board);
		for(int i = 0; i<1; i++){
			int newExpo = (int)Math.pow(2, (int) (((2 * Math.random())) + 1));
			int newRndX = (int)(Nrow.size()*Math.random()) ;
			int newRndY = newRndX;
//			int newRndY = (int)(Ncol.size()*Math.random()) ;
			board[Nrow.get(newRndX)][Ncol.get(newRndY)] = newExpo;
			
			// does not work because there are multiple 0-4s and sometimes board[x][y] will be a repeat
		//	 Nrow.remove(newRndX);
		//	 Ncol.remove(newRndY);
		}
		
	//	resetArrayList();
		Nrow.clear();
		Ncol.clear();
		
	}
	
	
	//ended up not using start for now ( its just cont used twice..)

	public static void start(int [][]board){
//	System.out.print(Nrow.size()+ "\n");
//	System.out.print(Ncol.size() + "\n");
	//int rndX = 0,rndY = 0,nR = 0, nC = 0;
	for(int i = 0; i<2; i++){
		checkBlanks(board);
		int newExpo = (int)Math.pow(2, (int) (((2 * Math.random())) + 1));
		int newRndX = (int)(Nrow.size()*Math.random()) ;
		int newRndY = newRndX;
//		int newRndY = (int)(Ncol.size()*Math.random()) ;
		board[Nrow.get(newRndX)][Ncol.get(newRndY)] = newExpo;
		Nrow.clear();
		Ncol.clear();
		
	}
	
	}
//	System.out.print(Arrays.deepToString(board)+ "\n");
//	
//	//test out that ArrayList holds the blocks in correct order
//	//check that the arraylist changed
////	System.out.print(Nrow + "\n");
////	System.out.print(Nrow + "\n");
////	System.out.print(Ncol.size() + "\n");
////	System.out.print(Ncol.size() + "\n");
//	
//	//testing 
////	System.out.print(rndX + "\n");
////	System.out.print(rndY+ "aa"+ "\n" );
////	System.out.print(nR+ "\n");
////	System.out.print(Nrow.get(rndX)+ "\n");
////	System.out.print(nC+ "\n");
////	System.out.print(Ncol.get(rndY));
//	//variables working
////	for (int i = 0; i < 2; i++) {
//////		int rndX = (int)(Nrow.size()*Math.random()) -1;
//////		int rndY = (int)(Ncol.size()*Math.random()) -1;
////		int expo = (int) ((1 * Math.random()) + 1); // (0 or 1) + 1;
////		// 
////		// 2 ^1 = 2; 2^2 = 4;  it will random 
//////		board[Nrow.get(rndX-1)][Nrow.get(rndX-1)] = (int) Math.pow(2, expo);
//////		Nrow.remove(Nrow.get(rndX));
//////		Nrow.remove(Nrow.get(rndX));
////		board[0][i] = i+1;
////	}
//	
////	for (Integer n : Nrow)
////	    System.out.println(n);
////	}
//	//making sure I have 4 0s,1s,2s,...
//
//	}
//}
}	