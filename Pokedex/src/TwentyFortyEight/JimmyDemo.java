/**
 * 
 */
package TwentyFortyEight;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import guiPractice.GuiApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
// adding ponts into a arraylist

/**
 * @author Jimmy Wu
 *
 */
public class JimmyDemo implements JimmyInterface  {
	public static JimmyDemo jimmy = new JimmyDemo();
//	static int[][] game;
//	static int[][] gameTemp;
// 	static int temp;
	static ArrayList<Integer> points = new ArrayList();
//	
//	
//	public static Reward reward;
//
//	/**
//	 * 
//	 */
//	public JimmyDemo() {
//		jimmy= this;
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see guiPractice.GuiApplication#initScreen()
//	 */
//	@Override
//	protected void initScreen() {
//		DemoScreen demo = new DemoScreen(getWidth(), getHeight());
//		setScreen(demo);
//
//	}
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		JimmyDemo d = new JimmyDemo();
//		Thread app = new Thread(d);
//		app.start();
//		
//		game = new int[4][4];
//		gameTemp = new int[4][4];
//		SpawnDemo.start(game);
//		createTemp(gameTemp, game);
//		printGame(game);
//		System.out.println("+++++++++++++++++++++++++++++++");
//	
//	}
//
//	// nested inner class
//	private class DemoScreen extends ClickableScreen {
//		private TextLabel movementDisplay;
//		private Button slideUp;
//		private Button slideDown;
//		private Button slideLeft;
//		private Button slideRight;
//
//		public DemoScreen(int width, int height) {
//			super(width, height);
//			// TODO Auto-generated constructor stub
//		}
//
//		@Override
//		public void initAllObjects(ArrayList<Visible> view) {
//			movementDisplay = new TextLabel(20, 40, 1000, 25, "");
//			slideUp = new Button(100, 75, 90, 40, "Up", Color.blue, new Action() {
//
//				@Override
//				public void act() {
//					createTemp(gameTemp, game);
//					rotate(game, 1);
//					moveTilesMinus(game);
//					rotate(game, 3);
//					int counter = counter(16, gameTemp, game);
//					
//					if (counter!=0) {
//						SpawnDemo.cont(game);
//						printGame(game);
//						
//						System.out.println("-------------------------------");
//						System.out.println(Arrays.toString(points.toArray()));
//						movementDisplay.setText("You swiped up!");
//					}else{
//						movementDisplay.setText("You cannot swipe up anymore.");
//					}
//					
//
//				}
//			});
//			slideDown = new Button(100, 225, 90, 40, "Down", Color.blue, new Action() {
//
//				@Override
//				public void act() {
//					createTemp(gameTemp, game);
//					rotate(game, 1);
//					moveTilesPlus(game);
//					rotate(game, 3);
//					int counter = counter(16, gameTemp, game);
//					
//					if (counter!=0) {
//						SpawnDemo.cont(game);
//						printGame(game);
//						
//						System.out.println("-------------------------------");
//						System.out.println(Arrays.toString(points.toArray()));
//						movementDisplay.setText("You swiped down!");
//					}else{
//						movementDisplay.setText("You cannot swipe down anymore.");
//					}
//					
//					
//
//				}
//			});
//			slideRight = new Button(160, 150, 90, 40, "Right", Color.blue, new Action() {
//
//				@Override
//				public void act() {
//					createTemp(gameTemp, game);
//					moveTilesMinus(game);		
//					int counter = counter(16, gameTemp, game);
//					
//					if (counter != 0) {
//						SpawnDemo.cont(game);
//						printGame(game);
//						System.out.println("-------------------------------");
//						System.out.println(Arrays.toString(points.toArray()));
//						movementDisplay.setText("You swiped right!");
//					}else {
//						movementDisplay.setText("You cannot swipe right anymore. ");
//					}
//					
//
//				}
//			});
//			slideLeft = new Button(40, 150, 90, 40, "Left", Color.blue, new Action() {
//
//				@Override
//				public void act() {
//					createTemp(gameTemp, game);
//					moveTilesPlus(game);
//					int counter = counter(16, gameTemp, game);
//					
//					if (counter != 0) {
//						SpawnDemo.cont(game);
//						printGame(game);
//						System.out.println("-----------------------------"
//								+ "");
//						System.out.println(Arrays.toString(points.toArray()));
//						movementDisplay.setText("You swiped left!");
//					}else {
//						movementDisplay.setText("You cannot swipe left anymore. ");
//					}
//					
//					
//					
//					
//					
//					
//				}
//			});
//			view.add(movementDisplay);
//			view.add(slideUp);
//			view.add(slideDown);
//			view.add(slideRight);
//			view.add(slideLeft);
//		}
//
//	}
//	
	public int counter(int number, int[][] gameTemp, int[][] game) {
		for (int i = 0; i < game.length; i++) {
			for (int j = 0; j < game[i].length; j++) {
				if (gameTemp[i][j] == game[i][j]) {
					number--;
				}
			}
		}
		return number;
	
	}
	public void createTemp(int[][] gameTemp, int[][]game) {
		
		for (int i = 0; i < gameTemp.length; i++) {
			for (int j = 0; j < gameTemp[i].length; j++) {
				gameTemp[i][j] = game[i][j];
			}
		}
	
	}


	public void rotate(int[][] game, int numberOfRotations) {
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

	private static void combineTiles(int[] row, ArrayList<Integer> points) {
		for (int k = 0; k < row.length - 1; k++) {
			if (row[k] == row[k + 1]) {
				row[k] = row[k] + row[k + 1];
				if (row[k]!=0) {
					points.add(row[k]);
				}
				
				row[k + 1] = 0;
				
			}
			
		}
		
	}

	public void moveTilesPlus(int[][] game, ArrayList<Integer> points) {
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
			combineTiles(row, points);

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

	public void moveTilesMinus(int[][] game, ArrayList<Integer> points) {
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
			combineTiles(row, points);

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
		
	
	
	public void printGame(int[][] game) {
		for (int[] row : game) {
			for (int i : row) {
				System.out.print(i);
				System.out.print("\t");
			}
			System.out.println();

		}
	}

}
