package main;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class AppsLink extends Component {

	private static final int WIDTH = 60;
	private static final int HEIGHT = 60;
	
	private Action action;
	
	public AppsLink() {
		super(0, 0, WIDTH, HEIGHT);
		// TODO Auto-generated constructor stub
	}

	public void setAction(Action action) {
		this.action = action;
	}
	
	public void act(){
		action.act();
	}
	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	}

}
