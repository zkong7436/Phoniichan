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

		game[0][3] = 2;
		game[1][3] = 2;
	
		printGame(game);
		playGame();
	}

	private static void playGame() {
	
		System.out.println("Enter a direction to slide the tile.");
		String input = in.nextLine();
		if (input.equals("a")) {
			  for(int i = 0; i < game.length; i++){
			        int[] row = new int[4];
			        for(int j = 0; j < game[i].length; j++){

			            if (game[i][j] != 0)
			            {
			                temp = 0;
			                while(row[temp] != 0) {
			                    temp++;
			                }
			                row[temp] = game[i][j];
			            }

			        }
			        game[i] = row;
			    }
			    printGame(game);
			
		}

	}
	
	
	private static void moveTiles() {
		// TODO Auto-generated method stub
		
	}

	private static void printGame(int[][] game) {
		for (int[] row : game) {
			for (int i : row) {
				System.out.print(i);
				System.out.print("\t");
			}
			System.out.println();

		}
	}
}