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
public class Demo extends GuiApplication {
	public static Reward reward;
	/**
	 * 
	 */
	public Demo() {
		reward = new Reward();
	}

	/* (non-Javadoc)
	 * @see guiPractice.GuiApplication#initScreen()
	 */
	@Override
	protected void initScreen() {
		DemoScreen demo = new DemoScreen(getWidth(),getHeight());
		setScreen(demo);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Demo d = new Demo();
		Thread app = new Thread(d);
		app.start();

	}
	// nested inner class
	private class DemoScreen extends ClickableScreen{
		private TextLabel rewardDisplay;
		private Button beatAMonster;
		public DemoScreen(int width, int height) {
			super(width, height);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(ArrayList<Visible> view) {
			rewardDisplay = new TextLabel(20,40,1000,25,"");
			beatAMonster = new Button(40, 100, 190, 40,"beat a monster" ,Color.blue, 
					new Action() {
						
						@Override
						public void act() {
							Demo.reward.getReward(10);
							rewardDisplay.setText(" You earned a reward ! Total points = " +Demo.reward.getPoints());
							
						}
					});
			view.add(rewardDisplay);
			view.add(beatAMonster);
		}
		
	}

}
