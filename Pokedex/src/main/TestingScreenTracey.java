package main;

import java.util.ArrayList;

import guiPractice.components.ClickableScreen;
import guiPractice.components.Visible;

public class TestingScreenTracey extends ClickableScreen {

	private static AppsLink appIcon;
	
	public TestingScreenTracey(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(ArrayList<Visible> arg0) {
		appIcon = new AppsLink();
//		appIcon.setIconImage

	}

}
