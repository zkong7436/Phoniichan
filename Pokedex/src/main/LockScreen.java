package main;

import java.awt.Color;
import java.util.ArrayList;

import guiPractice.components.Action;
import guiPractice.components.Button;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class LockScreen extends PokedexScreen {

	private Button[][] buttons;
	private Button enter;
	private Button zero;
	private Button backspace;
	private String corCode = "022716";
	private String code = "";
	private TextLabel codeLabel;
	
	public LockScreen(int width, int height) {
		super(width, height);
		PokedexScreen.locked = true;
	}

	@Override
	public void initRemainingItems(ArrayList<Visible> viewObjects) {
		buttons = new Button[3][3];
		int buttonFactor = 70;
		for(int i = 0; i< buttons.length; i++){
			//figure out how to position each button
			for(int j = 0; j < buttons[i].length; j++){
				int a = i;
				int b = j;
				buttons[i][j] = new Button(420+i*buttonFactor, 130+j*buttonFactor, buttonFactor, buttonFactor, (i+j+1+i*2)+"", new Color(0,0,0,0), new Action(){
	
					@Override
					public void act() {
						code += buttons[a][b].getText();
						codeLabel.setText(code);
					}
					
				});
				viewObjects.add(buttons[i][j]);			
			}
		}
		zero = new Button(420, 130+3*buttonFactor, buttonFactor, buttonFactor, "0", new Color(0,0,0,0), new Action(){
			
			@Override
			public void act() {
				code += zero.getText();
				codeLabel.setText(code);
			}
			
		});
		backspace = new Button(420+buttonFactor, 130+3*buttonFactor, buttonFactor*2, buttonFactor, "Backspace", new Color(0,0,0,0), new Action(){

			@Override
			public void act() {
				code = code.substring(0, code.length()-1);
				codeLabel.setText(code);
			}
			
		});
		enter = new Button(55,230,70,70,"Enter",new Color(0,0,0,0),new Action(){

			@Override
			public void act() {
				if(code.equals(corCode)){
					locked = false;
					Pokedex.game.setScreen(new HomeScreen(getWidth(),getHeight()));
				}
			}
			
		});
		codeLabel = new TextLabel(370, 90, buttonFactor*3, 25, corCode);
		viewObjects.add(backspace);
		viewObjects.add(zero);
		viewObjects.add(enter);
		viewObjects.add(codeLabel);
	}

}
