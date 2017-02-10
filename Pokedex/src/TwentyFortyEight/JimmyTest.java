package TwentyFortyEight;

import java.util.Scanner;

public class JimmyTest {
	public static Scanner in = new Scanner(System.in);
	static int[][] game;
	static int temp;
	
	public static void main(String[] args) {
		game = new int[4][4];
		int x = 0;
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				game[i][j] = x;
				
			}
		}
	
		game[3][0] = 2;
		game[2][0] = 2;
		
		
		printgame(game);
		playGame();
	}
	
	
	
	
	private static void playGame() {
		System.out.println("Enter a direction to slide the tile.");
		String input = in.nextLine();
		if (input .equals("d")) {
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[i].length; j++) {
					
					if(j+1 < 4) {
						game[i][j] = game[i][j+1] ;
					}
//					game[i][j] = temp;
//					if (temp != 0) {
//						game[i][j] = game[i][j+1];
//					}
				}
			}
		
		}
		
		
		
		
	}












	private static void printgame(int[][] game) {
		for(int[] row : game) {
			for (int i : row) {
	            System.out.print(i);
	            System.out.print("\t");
	        }
	        System.out.println();

        }
	}
}
