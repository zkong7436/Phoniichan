package memory;

import java.awt.Color;

import guiPractice.components.Action;
import guiPractice.components.Clickable;
import guiPractice.components.Graphic;

public interface ButtonInterfaceFulton extends Clickable{
	void setX(int i);

	void setY(int i);
	
	void setAction(Action a);

	void setColor(Color green);
	
	void setPicture(String address); 
	
	Graphic getGraphic();

	void setName(String string);

	void setText(String string);

}
 