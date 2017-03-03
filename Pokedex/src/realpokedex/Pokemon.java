/**
 * 
 */
package realpokedex;

import java.io.File;
import java.util.ArrayList;

import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
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
	private TextLabel name;
	private int iconIdx;
	
	public Pokemon(int width, int height, int number) {
		super(width, height);
		this.number = number;
	}

	/* (non-Javadoc)
	 * @see guiPractice.Screen#initObjects(java.util.ArrayList)
	 */

	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		File[] resources = new File("resources/pokemon/").listFiles();
		stats = new String[resources.length][5];
		addStats(resources);
		TextLabel name = new TextLabel(360,110,200,30, cutString(resources[number].getName().substring(3),".png"));
		name.setSize(26);
		viewObjects.add(name);
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
