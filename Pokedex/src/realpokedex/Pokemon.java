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
public class Pokemon extends PokedexScreen {

	/**
	 * @param width
	 * @param height
	 */
	
	private static String[][] stats;
	private int number;
	private int iconIdx;
	private File[] resources;
	private TextLabel name;
	
	public Pokemon(int width, int height, int number) {
		super(width, height);
		System.out.println("You created a screen using number "+number);
		this.number = number;
		name.setText(cutString(resources[number].getName().substring(3),".png"));
	}

	/* (non-Javadoc)
	 * @see guiPractice.Screen#initObjects(java.util.ArrayList)
	 */

	public void goToScreen(){
		Pokedex.game.setScreen(new PokedexList(getWidth(),getHeight()));
	}
	
	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		resources = new File("resources/pokemon/").listFiles();
		stats = new String[resources.length][5];
		addStats(resources);
		name = new TextLabel(360,110,200,30, cutString(resources[number].getName().substring(3),".png"));
		name.setSize(26);
		Button back = new Button(560,210,60,60,"Back",Color.black, new Action(){
			public void act(){
				Pokedex.game.setScreen(new PokedexList(getWidth(),getHeight()));
			}
		});
		viewObjects.add(name);
		viewObjects.add(back);
	}
	
	public void addStats(File[] resources){
		for(int i = 0; i < resources.length; i++){
			stats[i][0]=cutString(resources[i].getName().substring(3),".png");
		}
		
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
	
	public String cutString(String a, String b){
		StringBuilder text = new StringBuilder(a);
		if(stringContains(a, b)){
			text.delete(iconIdx, iconIdx+b.length());
		}
		return text.toString();
	}

}