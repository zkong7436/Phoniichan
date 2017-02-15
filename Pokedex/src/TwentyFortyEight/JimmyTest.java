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
		game[0][2] = 2;
		game[0][3] = 4;
		game[1][0] = 0;
		game[1][1] = 4;
		game[1][2] = 8;
		game[3][2] = 8;

		printGame(game);
		playGame();
	}

	private static void playGame() {
		while (true) {
			System.out.println("Enter a direction to slide the tile.");
			String input = in.nextLine();
			if (input.equals("a")) {
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
					for (int k = 0; k < row.length - 1; k++) {
						if (row[k] == row[k + 1]) {
							row[k] = row[k] + row[k + 1];
							row[k + 1] = 0;
						}
					}
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
				printGame(game);

			}else if(input.equals("d")) {
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
					for (int k = 0; k < row.length - 1; k++) {
						if (row[k] == row[k + 1]) {
							row[k] = row[k] + row[k + 1];
							row[k + 1] = 0;
						}
					}
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
				printGame(game);

			}else if (input.equals("s")) {
				game = rotateCW(game);
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
					for (int k = 0; k < row.length - 1; k++) {
						if (row[k] == row[k + 1]) {
							row[k] = row[k] + row[k + 1];
							row[k + 1] = 0;
						}
					}
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

				game = rotateCW(game);
				game = rotateCW(game);
				game = rotateCW(game);
				
				printGame(game);
			}else if (input.equals("w")) {
				game = rotateCW(game);
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
					for (int k = 0; k < row.length - 1; k++) {
						if (row[k] == row[k + 1]) {
							row[k] = row[k] + row[k + 1];
							row[k + 1] = 0;
						}
					}
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
				game = rotateCW(game);
				game = rotateCW(game);
				game = rotateCW(game);
				printGame(game);
			}

		}
		
	}
	static int[][] rotateCW(int[][] mat) {
	    final int M = mat.length;
	    final int N = mat[0].length;
	    int[][] ret = new int[N][M];
	    for (int r = 0; r < M; r++) {
	        for (int c = 0; c < N; c++) {
	            ret[c][M-1-r] = mat[r][c];
	        }
	    }
	    return ret;
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
