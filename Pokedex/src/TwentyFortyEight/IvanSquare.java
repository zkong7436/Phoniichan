package TwentyFortyEight;

public class IvanSquare implements SquareInterface{
	private static int move = 0;
	
	public IvanSquare() {
		
	}
	public static void newSq(int[][] array){
		// spawn 2 or 4
		
		
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array.length; col++) {
				if(array[row][col] == 0){
					//generate 2 random squares.
				}
			}
		}
		if(move != 0 ){
			//spawn a number randomly
			
			//turn move back to 1
			move = 1;
		}
		
	}
	
//ss

}
