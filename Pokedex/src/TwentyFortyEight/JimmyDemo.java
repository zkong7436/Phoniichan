/**
 * 
 */
package TwentyFortyEight;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.GuiApplication;
import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.ClickableScreen;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

/**
 * @author Student 8
 *
 */
public class JimmyDemo extends GuiApplication {
	public static Reward reward;

	/**
	 * 
	 */
	public JimmyDemo() {
		reward = new Reward();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see guiPractice.GuiApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(), getHeight());
		setScreen(demo);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JimmyDemo d = new JimmyDemo();
		Thread app = new Thread(d);
		app.start();

	}

	// nested inner class
	private class DemoScreen extends ClickableScreen {
		private TextLabel rewardDisplay;
		private Button slideUp;
		private Button slideDown;
		private Button slideLeft;
		private Button slideRight;

		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(ArrayList<Visible> view) {
			rewardDisplay = new TextLabel(20, 40, 1000, 25, "");
			slideUp = new Button(100, 75, 90, 40, "Up", Color.blue, new Action() {

				@Override
				public void act() {
					moveTilesUp();
					JimmyDemo.reward.getReward(10);
					rewardDisplay.setText(" You earned a reward ! Total points = " + JimmyDemo.reward.getPoints());

				}
			});
			slideDown = new Button(100, 225, 90, 40, "Down", Color.blue, new Action() {

				@Override
				public void act() {
					JimmyDemo.reward.getReward(10);
					rewardDisplay.setText(" You earned a reward ! Total points = " + JimmyDemo.reward.getPoints());

				}
			});
			slideRight = new Button(160, 150, 90, 40, "Right", Color.blue, new Action() {

				@Override
				public void act() {
					JimmyDemo.reward.getReward(10);
					rewardDisplay.setText(" You earned a reward ! Total points = " + JimmyDemo.reward.getPoints());

				}
			});
			slideLeft = new Button(40, 150, 90, 40, "Left", Color.blue, new Action() {

				@Override
				public void act() {
					JimmyDemo.reward.getReward(10);
					rewardDisplay.setText(" You earned a reward ! Total points = " + JimmyDemo.reward.getPoints());

				}
			});
			view.add(rewardDisplay);
			view.add(slideUp);
			view.add(slideDown);
			view.add(slideRight);
			view.add(slideLeft);
		}

	}

	private static void moveTilesUp() {
		
	}

	private static void moveTilesDown() {

	}

	private static void moveTilesLeft() {

	}

	private static void moveTilesRight() {

	}

}