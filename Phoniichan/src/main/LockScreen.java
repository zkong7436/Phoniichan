package main;

import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.Visible;

public class LockScreen extends PokedexScreen {

	private Button[][] buttons;
	private String corCode = "022716";
	private String code = "";
	
	public LockScreen(int width, int height) {
		super(width, height);
		PokedexScreen.locked = true;
	}

	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		buttons = new Button[3][3];
		for(int i = 0; i< buttons.length; i++){
			//figure out how to position each button
			for(int j = 0; j < buttons[i].length; j++){
				int a = i;
				int b = j;
				buttons[i][j] = new Button(getWidth()/9+3*i,getHeight()/9+3*j,50,50,(i+j+1+i*2)+"",null,new Action(){
	
					@Override
					public void act() {
						code += buttons[a][b].getText();
					}
					
				});
				viewObjects.add(buttons[i][j]);			
			}

		}
	}

}
