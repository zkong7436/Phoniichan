/**
 * 
 */
package pokedex;

import java.io.File;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import main.PokedexScreen;

/**
 * @author Wendigo
 *
 */
public class PokedexList extends PokedexScreen {

	/**
	 * @param width
	 * @param height
	 */
	private ArrayList<ClickableGraphic> pokeList;
	
	public PokedexList(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see main.PokedexScreen#initRemainingItems(java.util.ArrayList)
	 */
	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		pokeList = new ArrayList<ClickableGraphic>();
		viewObjects.addAll(pokeList);
	}
	
	public void findPokemon() {
		File[] resources = new File("resources/pokemon").listFiles();
		int numIcons = 0;
		for(int i = 0; i < resources.length; i++){
			ClickableGraphic poke = new ClickableGraphic((iconX(numIcons))*60+330,iconY(numIcons)*60+90,60,60,"resources/pokemon"+resources[i].getName());
			poke.setAction(new Action(){

				@Override
				public void act() {
					//goto application
					
				}
				
			});
			String name = cutString(resources[i].getName(), "icon.png");
			TextLabel newLinkLabel = new TextLabel((iconX(numIcons))*120+360,iconY(numIcons)*120+210,90,40,centerString(name, 8));
			newLinkLabel.setSize(20);
			numIcons++;
			appLinks.add(newLink);
		}
	}
	
	public int iconX(int numIcons) {
		return (numIcons%3);
	}

	public int iconY(int numIcons) {
		return (numIcons/3);
	}

}
