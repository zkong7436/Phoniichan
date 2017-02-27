package main;

import java.util.ArrayList;

import java.io.File;

import guiPractice.components.Action;
import guiPractice.components.ClickableGraphic;
import guiPractice.components.Graphic;
import guiPractice.components.Visible;

public class HomeScreen extends PokedexScreen {

	private ArrayList<ClickableGraphic> appLinks;
	private Graphic backImg;
	
	public HomeScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		backImg = new Graphic(330, 90, "resources/ivyback.png");
		findApps();
		int xShift = 0;
		int yShift = 0;
		if(appLinks != null){
			for(int i = 0; i < appLinks.size(); i++){
				if(i < 16){
					if(i !=0 && i%4 == 0){
					xShift = 0;
					yShift += 75;
					}else{
						xShift += 75;
					}
				appLinks.get(i).setX(330+i*xShift);
				appLinks.get(i).setY(90+i*yShift);
				}
			}
		}
		viewObjects.add(backImg);
		viewObjects.addAll(appLinks);
	}

	public void findApps() {
		File[] resources = new File("resources/").listFiles();
		for(int i = 0; i < resources.length; i++){
			if(stringContains(resources[i].getName(),"icon")){
				ClickableGraphic newLink = new ClickableGraphic(0,0,"resources/"+resources[i].getName());
				newLink.setAction(new Action(){

					@Override
					public void act() {
						// TODO Auto-generated method stub
						
					}
					
				});
				appLinks.add(newLink);
			}
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
				break;
			}
		}
		return doesContain;
	}

}
//how many tiles? 16 (4x4)
//each tile 75x75