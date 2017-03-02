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
//	public static Reward reward;
	/**
	 * 
	 */
	public Demo() {
		//reward = new Reward();
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
		private int score = 1;

		//private TextLabel rewardDisplay;
		//private Button beatAMonster;
		//private MyDemo demo;
		public DemoScreen(int width, int height) {
			super(width, height);
			
			// TODO Auto-generated constructor stub
		}

		@Override
		public void initAllObjects(ArrayList<Visible> view) {

			MyDemo d = new MyDemo(50,50,380,345);
			TextLabel text = new TextLabel(300, 50, 300, 30, "This is the High Score Board");
			int[] scores = new int[3];
	//		if(TwentyFortyEightGame.gameOver){
	//			highScore(score, scores);
	//		}
			for(int i = 0; i < 3; i++){
				
				scores[0] = 1;
				scores[1] = 2;
				scores[2] = 3;
				view.add(new TextLabel((450) , (150 + (i*50)), 30, 40, scores[i]+""));
			}
		
		
		
			//Button reset = new Button (40,40,40,40 , "Reset", Color.BLUE, new Action());
			//reset.setAction(Action());
		//	rewardDisplay = new TextLabel(20,40,1000,25,"");
		//	beatAMonster = new Button(40, 100, 190, 40,"beat a monster" ,Color.blue, 
//					new Action() {
//						
//						@Override
//						public void act() {
//							Demo.reward.getReward(10);
//							rewardDisplay.setText(" You earned a reward ! Total points = " +Demo.reward.getPoints());
//							
//						}
//					});
		//	view.add(rewardDisplay);
		//	view.add(beatAMonster);
			view.add(d);
			view.add(text);
		}

		public void highScore(int userScore, int[] scores){
			for(int i = 0; i < scores.length; i++){
				if( scores[i] < userScore){
					int temp = scores[i];
					scores[i] = userScore;
					scores[i+1] = temp;
					for(int j = i+2; j < scores.length; j++){
						scores[j] = scores[i];
					}
				}
			}
	}
		private Action Action() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}

