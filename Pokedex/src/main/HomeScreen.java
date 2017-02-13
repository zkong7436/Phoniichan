package main;

import java.util.ArrayList;

import guiPractice.components.Visible;

public class HomeScreen extends PokedexScreen {

	private ArrayList<AppsLink> appLinks;
	
	public HomeScreen(int width, int height) {
		super(width, height);
	}

	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		int xShift = 0;
		int yShift = 0;
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

}
//how many tiles? 16 (4x4)
//each tile 75x75