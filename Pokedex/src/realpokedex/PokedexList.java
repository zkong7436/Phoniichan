package realpokedex;

import java.io.File;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import main.Pokedex;
import main.PokedexScreen;

/**
 * @author zkong7436
 *
 */
public class PokedexList extends PokedexScreen {

	/**
	 * @param width
	 * @param height
	 */
	private ArrayList<ClickableGraphic> pokemons;
	private ArrayList<TextLabel> pokemonLabels;
	private TextLabel title;
	private int iconIdx;
	private int pokIdx;
	
	public PokedexList(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see main.PokedexScreen#initRemainingItems(java.util.ArrayList)
	 */
	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		pokemons = new ArrayList<ClickableGraphic>();
		pokemonLabels = new ArrayList<TextLabel>();
		title = new TextLabel(340,90,100,30, "Pokedex");
		title.setSize(18);
		findPokemons();
		viewObjects.addAll(pokemons);
		viewObjects.addAll(pokemonLabels);
		viewObjects.add(title);
	}
	
	private void findPokemons() {
		File[] resources = new File("resources/pokemon/").listFiles();
		int numIcons = 0;
		for(int i = 0; i < resources.length; i++){
			pokIdx = i;
			Pokemon destination = new Pokemon(getWidth(),getHeight(),i);
			ClickableGraphic poke = new ClickableGraphic((iconX(numIcons))*120+360,iconY(numIcons)*105+115,90,90,"resources/pokemon/"+resources[i].getName());
			poke.setAction(new Action(){

				@Override
				public void act() {
					Pokedex.game.setScreen(destination);
				}
				
			});
			String name = "#"+resources[i].getName().substring(0,3);
			TextLabel pokeLabel = new TextLabel((iconX(numIcons))*120+360,iconY(numIcons)*105+177,90,40,centerString(name, 12));
			pokeLabel.setSize(16);
			numIcons++;
			pokemons.add(poke);
			pokemonLabels.add(pokeLabel);
		}
	}

	public static int iconX(int numIcons) {
		return (numIcons%3);
	}

	public static int iconY(int numIcons) {
		return (numIcons/3);
	}

	public boolean stringContains(String a, String b){
		boolean doesContain = false;
		for(int i = 0; i < a.length(); i++){
			int bIdx = 0;
			int aIdx = i;
			while(bIdx < b.length() && aIdx < a.length() && a.charAt(aIdx) == b.charAt(bIdx)){
				bIdx++;
				aIdx++;
			}
			if(bIdx == b.length()){
				doesContain = true;
				iconIdx = aIdx - b.length();
				break;
			}
		}
		return doesContain;
	}
	
	public String centerString(String a, int size){
		String space = "";
		if(size>a.length()){
			int spaceSize = (int)((size - a.length()) / 2);
			for(int i = 0; i < spaceSize; i++){
				space += " ";
			}
		}
		return space += a;
	}
	
}