/**
 * 
 */
package TwentyFortyEight;

/**
 * @author Student 8
 *
 */
public class Reward {

	private int rewardPoints;
	/**
	 * 
	 */
	public Reward() {
		rewardPoints = 0;
	}
	public void getReward(int points){
		rewardPoints +=points;
	}
	public int getPoints(){
		return rewardPoints;
	}

}
