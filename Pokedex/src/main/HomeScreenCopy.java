package main;

import java.util.ArrayList;

import java.io.File;

import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class HomeScreenCopy extends PokedexScreen {

	private ArrayList<ClickableGraphic> appLinks;
	private Graphic backImg;
	private int iconIdx;
	
	public HomeScreenCopy(int width, int height) {
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
				ClickableGraphic newLink = new ClickableGraphic((iconX(numIcons))*60+330,iconY(numIcons)*60+90,60,60,"resources/"+resources[i].getName());
				newLink.setAction(new Action(){

					@Override
					public void act() {
						//goto application
						
					}
					
				});
				TextLabel newLinkLabel = new TextLabel((iconX(numIcons))*60+330,iconY(numIcons)*60+30,60,25,cutString(resources[i].getName(), "icon"));
				numIcons++;
				appLinks.add(newLink);
			}
		}
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
			iconIdx = bIdx - b.length();
			if(bIdx == b.length()){
				doesContain = true;
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
	
	public static void main(String arg){
		
	}

}
//how many tiles? 16 (4x4)
//each tile 75x75