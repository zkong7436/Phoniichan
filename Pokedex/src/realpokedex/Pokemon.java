package realpokedex;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import main.Pokedex;
import main.PokedexScreen;

/**
 * @author zkong7436
 *
 */
public class Pokemon extends PokedexScreen{

	/**
	 * @param width
	 * @param height
	 */
	
	private String[][] stats;
	private int number;
	private int iconIdx;
	private File[] resources;
	private TextLabel name;
	
	public Pokemon(int width, int height, int number) {
		super(width, height);
		System.out.println("You created a screen using number "+number);
		this.number = number;
		name.setText(stats[number][0]);
	}

	/* (non-Javadoc)
	 * @see guiPractice.Screen#initObjects(java.util.ArrayList)
	 */

	public void goToScreen(){
		Pokedex.game.setScreen(new PokedexList(getWidth(),getHeight()));
	}
	
	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		String [] category = {"Seed","Seed","Seed","Lizard","Flame", "Flame","Tiny Turtle","Turtle","Shellfish"};
		String[] abilities = {"Overgrow", "Overgrow", "Overgrow", "Blaze", "Blaze", "Blaze", "Torrent","Torrent","Torrent"};
		String[] type = {"Grass, Poison", "Grass, Poison", "Grass, Poison", "Fire", "Fire", "Fire, Flying", "Water","Water","Water" };
		String[] weaknesses = {"Fire, Flying, Ice, Psychic","Fire, Flying, Ice, Psychic","Fire, Flying, Ice, Psychic", "Ground, Rock, Water","Ground, Rock, Water","Rock,"
				+ "Electric, Water", "Electric, Grass","Electric, Grass","Electric, Grass"};
		resources = new File("resources/pokemon/").listFiles();
		addStats(category, abilities, type, weaknesses);
		name = new TextLabel(360,110,200,30, stats[number][0]);
		name.setSize(26);
		TextLabel printCate = new TextLabel(350,140,500,30, stats[number][1]);
		TextLabel printAbil = new TextLabel(350,165,500,30, stats[number][2]);
		TextLabel printType = new TextLabel(350,190,500,30, stats[number][3]);
		TextLabel printWeak = new TextLabel(350,215,500,30, stats[number][4]);
		Button back = new Button(560,270,70,60,"Back",Color.white, new Action(){
			public void act(){
				Pokedex.game.setScreen(new PokedexList(getWidth(),getHeight()));
			}
		});
		viewObjects.add(name);
		viewObjects.add(printCate);
		viewObjects.add(printAbil);
		viewObjects.add(printType);
		viewObjects.add(printWeak);
		viewObjects.add(back);
	}
	
	public void addStats(String[] category, String[] abilities, String[] type, String[] weaknesses){
		stats = new String[9][5];
		for(int i = 0; i < 9; i++){
			stats[i][0]=cutString(resources[i].getName().substring(3),".png");
			stats[i][1]="Category: " + category[0];
			stats[i][2]="Abilities: " + abilities[0];
			stats[i][3]="Type: " + type[0];
			stats[i][4]="Weaknesses: " + weaknesses[0];
		}
		
	}
	
	public String cutString(String a, String b){
		StringBuilder text = new StringBuilder(a);
		if(stringContains(a, b)){
			text.delete(iconIdx, iconIdx+b.length());
		}
		return text.toString();
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

}