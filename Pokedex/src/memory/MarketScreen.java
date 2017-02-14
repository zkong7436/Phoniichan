package memory;

import java.util.ArrayList;

import guiPractice.components.ClickableScreen;
import guiPractice.components.Graphic;
import guiPractice.components.TextLabel;
import guiPractice.components.Visible;

public class MarketScreen extends ClickableScreen implements Runnable{
	
	private TextLabel label;
	private ButtonInterfaceFulton[] buttons;
	private Graphic picture;
	private int abraCaught;

	public MarketScreen(int width, int height) {
		super(width, height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void initAllObjects(ArrayList<Visible> viewObjects) {
		addButtons(viewObjects);
		
		label = new TextLabel(20, 20, 760, 40, "AbraMarket");
		
		viewObjects.add(label);
		
	}
	
	private void addButtons(ArrayList<Visible> viewObjects) {
		String[] names = {"Potion", "Potion2", "Potion3", "Potion4", "Potion5", "Potion6"};
		String[] description = {"","","","","",""};
		int numberOfButtons = 6;
		buttons = new ButtonInterfaceFulton[numberOfButtons];
		for(int i = 0; i <numberOfButtons; i++ ){
			buttons[i] = getAButton();
			buttons[i].setName(names[i]);
		}
	}

	private ButtonInterfaceFulton getAButton() {
		return new ButtonToby;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
