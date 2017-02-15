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
		game[0][0] = 2;
		game[0][1] = 2;
		game[0][2] = 1;
		game[0][3] = 3;
		game[1][0] = 2;
		game[1][1] = 2;
		game[1][2] = 2;
		game[1][3] = 2;
		game[2][0] = 2;
		game[2][1] = 2;
		game[2][2] = 2;
		game[2][3] = 2;
		game[3][0] = 2;
		game[3][1] = 2;
		game[3][2] = 2;
		game[3][3] = 2;

		printGame(game);
		playGame();
	}

	private static void playGame() {
		while (true) {
			System.out.println("Enter a direction to slide the tile.");
			String input = in.nextLine();
			if (input.equals("a")) {
				moveTilesPlus(game);
				printGame(game);

			} else if (input.equals("d")) {
				moveTilesMinus(game);
				printGame(game);

			} else if (input.equals("s")) {
				rotate(game, 1);
				moveTilesPlus(game);
				rotate(game, 3);
				printGame(game);

			} else if (input.equals("w")) {
				rotate(game, 1);
				moveTilesMinus(game);
				rotate(game, 3);
				printGame(game);
				
			}

		}

	}

	private static void rotate(int[][] game, int numberOfRotations) {
		// rotates clockwise
		int[][] newArr = new int[4][4];
		while (numberOfRotations >= 1) {
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[i].length; j++) {
					newArr[j][3 - i] = game[i][j];
				}
			}
			for (int i = 0; i < game.length; i++) {
				for (int j = 0; j < game[i].length; j++) {
					game[i][j] = newArr[i][j];
				}
			}
			numberOfRotations--;
		}

	}

	private static void combineTiles(int[] row) {
		for (int k = 0; k < row.length - 1; k++) {
			if (row[k] == row[k + 1]) {
				row[k] = row[k] + row[k + 1];
				row[k + 1] = 0;
			}
		}
	}

	private static void moveTilesPlus(int[][] game) {
		for (int i = 0; i < game.length; i++) {
			int[] row = new int[4];
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] != 0) {
					int temp = 0;
					while (row[temp] != 0) {
						temp++;
					}
					row[temp] = game[i][j];
				}
			}
			combineTiles(row);

			game[i] = row;
		}
		for (int i = 0; i < game.length; i++) {
			int[] row = new int[4];
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] != 0) {
					int temp = 0;
					while (row[temp] != 0) {
						temp++;
					}
					row[temp] = game[i][j];
				}
			}
			game[i] = row;
		}

	}

	private static void moveTilesMinus(int[][] game) {
		for (int i = 0; i < game.length; i++) {
			int[] row = new int[4];
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] != 0) {
					int temp = 3;
					while (row[temp] != 0) {
						temp--;
					}
					row[temp] = game[i][j];
				}
			}
			combineTiles(row);

			game[i] = row;
		}
		for (int i = 0; i < game.length; i++) {
			int[] row = new int[4];
			for (int j = 0; j < game[i].length; j++) {
				if (game[i][j] != 0) {
					int temp = 3;
					while (row[temp] != 0) {
						temp--;
					}
					row[temp] = game[i][j];
				}
			}
			game[i] = row;
		}

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
