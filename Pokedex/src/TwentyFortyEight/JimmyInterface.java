package TwentyFortyEight;

import java.util.ArrayList;

public interface JimmyInterface {
	void printGame(int[][] game);
	int counter(int number, int[][] gameTemp, int[][] game);
	void createTemp(int[][] gameTemp, int[][]game);
	void rotate(int[][] game, int numberOfRotations);
	void moveTilesPlus(int[][] game, ArrayList<Integer> points);
	void moveTilesMinus(int[][] game, ArrayList<Integer> points);
}
