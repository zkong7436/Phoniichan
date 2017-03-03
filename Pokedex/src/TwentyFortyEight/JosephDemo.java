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
public class JosephDemo extends GuiApplication  {

	static int[][] gameTemp;
 	static int temp;
	static ArrayList<Integer> points = new ArrayList();
	
	
	public static Reward reward;

	/**
	 * 
	 */
	public JosephDemo() {
		reward = new Reward();
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
		JimmyDemo.createTemp(gameTemp, MyDemo.game);
	
		JimmyDemo.printGame(MyDemo.game);
		System.out.println("+++++++++++++++++++++++++++++++");
	
	}

	// nested inner class
	private class DemoScreen  extends main.PokedexScreen {
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
				movementDisplay = new TextLabel(20, 40, 1000, 25, "");
				slideUp = new Button(100, 75, 90, 40, "Up", Color.blue, new Action() {

					@Override
					public void act() {
						JimmyDemo.createTemp(gameTemp, MyDemo.game);
						JimmyDemo.rotate(MyDemo.game, 1);
						JimmyDemo.moveTilesMinus(MyDemo.game);
						JimmyDemo.rotate(MyDemo.game, 3);
						int counter = JimmyDemo.counter(16, gameTemp, MyDemo.game);
						
						if (counter!=0) {
							SpawnDemo.cont(MyDemo.game);
							JimmyDemo.printGame(MyDemo.game);
							
							
							System.out.println("-------------------------------");
							System.out.println(Arrays.toString(points.toArray()));
							movementDisplay.setText("You swiped up!");
						}else{
							movementDisplay.setText("You cannot swipe up anymore.");
						}
						

					}
				});
				slideDown = new Button(100, 225, 90, 40, "Down", Color.blue, new Action() {

					@Override
					public void act() {
						JimmyDemo.createTemp(gameTemp, MyDemo.game);
						JimmyDemo.rotate(MyDemo.game, 1);
						JimmyDemo.moveTilesPlus(MyDemo.game);
						JimmyDemo.rotate(MyDemo.game, 3);
						int counter = JimmyDemo.counter(16, gameTemp, MyDemo.game);
						
						if (counter!=0) {
							SpawnDemo.cont(MyDemo.game);
							JimmyDemo.printGame(MyDemo.game);
							
							System.out.println("-------------------------------");
							System.out.println(Arrays.toString(points.toArray()));
							movementDisplay.setText("You swiped down!");
							update();
						}else{
							movementDisplay.setText("You cannot swipe down anymore.");
						}
						
						

					}
				});
				slideRight = new Button(160, 150, 90, 40, "Right", Color.blue, new Action() {

					@Override
					public void act() {
						JimmyDemo.createTemp(gameTemp, MyDemo.game);
						JimmyDemo.moveTilesMinus(MyDemo.game);		
						int counter = JimmyDemo.counter(16, gameTemp, MyDemo.game);
						if (counter != 0) {
							SpawnDemo.cont(MyDemo.game);
							JimmyDemo.printGame(MyDemo.game);
							System.out.println("-------------------------------");
							System.out.println(Arrays.toString(points.toArray()));
							movementDisplay.setText("You swiped right!");
						}else {
							movementDisplay.setText("You cannot swipe right anymore. ");
						}
						

					}
				});
				slideLeft = new Button(40, 150, 90, 40, "Left", Color.blue, new Action() {

					@Override
					public void act() {
						JimmyDemo.createTemp(gameTemp, MyDemo.game);
						JimmyDemo.moveTilesPlus(MyDemo.game);
						int counter = JimmyDemo.counter(16, gameTemp, MyDemo.game);
						
						if (counter != 0) {
							SpawnDemo.cont(MyDemo.game);
							JimmyDemo.printGame(MyDemo.game);
							System.out.println("-----------------------------"
									+ "");
							System.out.println(Arrays.toString(points.toArray()));
							movementDisplay.setText("You swiped left!");
						}else {
							movementDisplay.setText("You cannot swipe left anymore. ");
						}	
					}
				});
				view.add(movementDisplay);
				view.add(slideUp);
				view.add(slideDown);
				view.add(slideRight);
				view.add(slideLeft);
				MyDemo d = new MyDemo(330,250,380,345);
				TextLabel text = new TextLabel(560, 220, 100, 30, "High Score");
				int[] scores = new int[3];
		//		if(TwentyFortyEightGame.gameOver){
		//			highScore(score, scores);
		//		}
				for(int i = 0; i < 3; i++){
					
					scores[0] = 1;
					scores[1] = 2;
					scores[2] = 3;
					view.add(new TextLabel((560) , (230 + (i*20)), 30, 40, scores[i]+""));			
			}
				view.add(d);
				view.add(text);
			}
	
		}

	}
	
	

