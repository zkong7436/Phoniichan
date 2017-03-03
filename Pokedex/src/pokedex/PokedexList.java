/**
 * 
 */
package pokedex;

import java.util.ArrayList;

import guiPractice.components.Visible;
import main.PokedexScreen;
import main.Pokemon;

/**
 * @author Wendigo
 *
 */
public class PokedexList extends PokedexScreen {

	/**
	 * @param width
	 * @param height
	 */
	private ArrayList<Pokemon> pokeList;
	
	public PokedexList(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see main.PokedexScreen#initRemainingItems(java.util.ArrayList)
	 */
	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		pokeList = new ArrayList<Pokemon>();
		viewObjects.addAll(pokeList);
		update();
	}

}
