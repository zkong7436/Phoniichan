/**
 * 
 */
package TwentyFortyEight;

import java.util.ArrayList;

import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

/**
 * @author Student 8
 *
 */
@SuppressWarnings("serial")
public class Demo extends main.Pokedex {
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
		DemoScreen demo = new DemoScreen(1000,1000);
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
	private class DemoScreen extends main.PokedexScreen{
		//private TextLabel rewardDisplay;
		//private Button beatAMonster;
		//private MyDemo demo;
		public DemoScreen(int width, int height) {
			super(width, height);
			
			// TODO Auto-generated constructor stub
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
			
	

		@SuppressWarnings("unused")
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
		@Override
		public void initRemainingItems(ArrayList<Visible> view) {
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

