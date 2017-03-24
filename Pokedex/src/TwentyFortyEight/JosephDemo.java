/**
 * 
 */
package TwentyFortyEight;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import guiPractice.GuiApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
// adding ponts into a arraylist

/**
 * @author Jimmy Wu
 *
 */
public class JosephDemo extends GuiApplication {

	static int[][] gameTemp;
	static int temp;
	static ArrayList<Integer> points = new ArrayList();

	// public static Reward reward;
	//
	// /**
	// *
	// */
	public JosephDemo() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see guiPractice.GuiApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(1000, 1000);
		setScreen(demo);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JosephDemo d = new JosephDemo();
		Thread app = new Thread(d);
		app.start();

		gameTemp = new int[4][4];
		JimmyDemo.jimmy.createTemp(gameTemp, MyDemo.game);

		JimmyDemo.jimmy.printGame(MyDemo.game);
		System.out.println("+++++++++++++++++++++++++++++++");

	}

	// nested inner class
	private class DemoScreen extends main.PokedexScreen {
		private TextLabel movementDisplay;
		private Button slideUp;
		private Button slideDown;
		private Button slideLeft;
		private Button slideRight;

		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initRemainingItems(ArrayList<Visible> view) {
			SpawnDemo.spawn.start(MyDemo.game);
			MyDemo d = new MyDemo(330, 250, 380, 345);
			movementDisplay = new TextLabel(20, 40, 1000, 25, "");
			slideUp = new Button(785, 320, 40, 40, "Up", Color.green, new Action() {

				@Override
				public void act() {
					JimmyDemo.jimmy.createTemp(gameTemp, MyDemo.game);
					JimmyDemo.jimmy.rotate(MyDemo.game, 1);
					JimmyDemo.jimmy.moveTilesMinus(MyDemo.game, points);
					JimmyDemo.jimmy.rotate(MyDemo.game, 3);
					int counter = JimmyDemo.jimmy.counter(16, gameTemp, MyDemo.game);


					if (counter != 0) {
						SpawnDemo.spawn.cont(MyDemo.game);
						JimmyDemo.jimmy.printGame(MyDemo.game);
						

						System.out.println("-------------------------------");
						System.out.println(Arrays.toString(points.toArray()));
						movementDisplay.setText("You swiped up!");
						d.update();
					} else {
						movementDisplay.setText("You cannot swipe up anymore.");
					}

				}
			});
			slideDown = new Button(785, 390, 40, 40, "Down", Color.green, new Action() {

				@Override
				public void act() {
					JimmyDemo.jimmy.createTemp(gameTemp, MyDemo.game);
					JimmyDemo.jimmy.rotate(MyDemo.game, 1);
					JimmyDemo.jimmy.moveTilesPlus(MyDemo.game, points);
					JimmyDemo.jimmy.rotate(MyDemo.game, 3);
					int counter = JimmyDemo.jimmy.counter(16, gameTemp, MyDemo.game);
					

					if (counter != 0) {
						SpawnDemo.spawn.cont(MyDemo.game);
						JimmyDemo.jimmy.printGame(MyDemo.game);

						System.out.println("-------------------------------");
						System.out.println(Arrays.toString(points.toArray()));
						movementDisplay.setText("You swiped down!");
						d.update();
						update();
					} else {
						movementDisplay.setText("You cannot swipe down anymore.");
					}

				}
			});
			slideRight = new Button(827, 355, 40, 40, "Right", Color.green, new Action() {

				@Override
				public void act() {
					JimmyDemo.jimmy.createTemp(gameTemp, MyDemo.game);
					JimmyDemo.jimmy.moveTilesMinus(MyDemo.game, points);
					int counter = JimmyDemo.jimmy.counter(16, gameTemp, MyDemo.game);
					if (counter != 0) {
						SpawnDemo.spawn.cont(MyDemo.game);
						JimmyDemo.jimmy.printGame(MyDemo.game);
						System.out.println("-------------------------------");
						System.out.println(Arrays.toString(points.toArray()));
						movementDisplay.setText("You swiped right!");
						d.update();
					} else {
						movementDisplay.setText("You cannot swipe right anymore. ");
					}

				}
			});
			slideLeft = new Button(740, 355, 40, 40, "Left", Color.green, new Action() {

				@Override
				public void act() {
					JimmyDemo.jimmy.createTemp(gameTemp, MyDemo.game);
					JimmyDemo.jimmy.moveTilesPlus(MyDemo.game, points);
					int counter = JimmyDemo.jimmy.counter(16, gameTemp, MyDemo.game);

					if (counter != 0) {
						SpawnDemo.spawn.cont(MyDemo.game);
						JimmyDemo.jimmy.printGame(MyDemo.game);
						System.out.println("-----------------------------" + "");
						System.out.println(Arrays.toString(points.toArray()));
						movementDisplay.setText("You swiped left!");
						d.update();
					} else {
						movementDisplay.setText("You cannot swipe left anymore. ");
					}
				}
			});
			view.add(movementDisplay);
			view.add(slideUp);
			view.add(slideDown);
			view.add(slideRight);
			view.add(slideLeft);
			
			TextLabel text = new TextLabel(560, 220, 100, 30, "High Score");
			int[] scores = new int[3];
			// if(TwentyFortyEightGame.gameOver){
			// highScore(score, scores);
			// }
			for (int i = 0; i < 3; i++) {

				scores[0] = 10000;
				scores[1] = 2000;
				scores[2] = 300;
				view.add(new TextLabel((560), (230 + (i * 20)), 150, 40, (i + 1) + "."+scores[i] + ""));
			}
			view.add(d);
			view.add(text);
		}

	}
}

