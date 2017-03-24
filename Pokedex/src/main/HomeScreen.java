package main;

import java.util.ArrayList;

import Memory.MemoryScreen;
import TwentyFortyEight.TwentyFortyEightGame;

import java.io.File;

import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;
import realpokedex.PokedexList;
import realpokedex.Pokemon;

public class HomeScreen extends PokedexScreen {

	private ArrayList<ClickableGraphic> appLinks;
	private Graphic backImg;
	private int iconIdx;
	
	public HomeScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		backImg = new Graphic(330, 90, "resources/ivyback.png");
		appLinks = new ArrayList<ClickableGraphic>();
		findApps();
		viewObjects.add(backImg);
		viewObjects.addAll(appLinks);
	}

	public void findApps() {
		File[] resources = new File("resources/").listFiles();
		int numIcons = 0;
		for(int i = 0; i < resources.length; i++){
			if(stringContains(resources[i].getName(),"icon")){
				ClickableGraphic newLinks = new ClickableGraphic((iconX(numIcons))*120+360,iconY(numIcons)*120+120,90,90,"resources/"+resources[i].getName());
				String name = cutString(resources[i].getName(), "icon.png");
				TextLabel newLinkLabel = new TextLabel((iconX(numIcons))*120+360,iconY(numIcons)*120+210,90,40,centerString(name, 8));
				newLinkLabel.setSize(20);
				numIcons++;
				appLinks.add(newLinks);
			}
		}
		appLinks.get(2).setAction(new Action(){
			
			public void act(){
				Pokedex.game.setScreen(new PokedexList(getWidth(),getHeight()));
			}
		});
		appLinks.get(0).setAction(new Action(){
			
			public void act(){
				Pokedex.game.setScreen(new TwentyFortyEightGame(getWidth(),getHeight()));
			}
		});
		appLinks.get(1).setAction(new Action(){
			
			public void act(){
				Pokedex.game.setScreen(new MemoryScreen(getWidth(),getHeight()));
			}
		});
		//hi
	}
	
	public int iconX(int numIcons) {
		return (numIcons%4);
	}

	public int iconY(int numIcons) {
		return (numIcons/4);
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
//how many tiles? 16 (4x4)
//each tile 75x75