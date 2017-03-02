package memory;

import java.awt.Color;

import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceToby extends Clickable {
	void setX(int i);

	void setY(int i);
	
	void setAction(Action a);

	void setColor(Color green);
	
	void setPicture(String address); 

	void setName(String string);

	void setCost(int string);
	
	void setLabel(String string);
}
