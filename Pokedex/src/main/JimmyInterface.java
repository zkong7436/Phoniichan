package TwentyFortyEight;

public interface JimmyInterface {
	void printGame(int[][] game);
	int counter(int number, int[][] gameTemp, int[][] game);
	void createTemp(int[][] gameTemp, int[][]game);
	void rotate(int[][] game, int numberOfRotations);
	void moveTilesPlus(int[][] game);
	void moveTilesMinus(int[][] game);
}
