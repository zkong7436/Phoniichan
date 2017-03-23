package Memory;

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

	void setName(String string);

	void setText(String string);
	
	void setLabel(String string);
	 
	void flip();
	
	void setChecked(boolean b);

	void setThere(boolean b);

	void setReveal(boolean b);

	void setNumButtons(int size);
}
