package main;

import guiPractice.components.Clickable;
import guiPractice.components.Graphic;

public class AppsLink extends Graphic implements Clickable{

	private static int HEIGHT = 60;
	private static int WIDTH = 60;
	
	public AppsLink(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}
