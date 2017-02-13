package memory;

import guiPractice.components.Action;
import guiPractice.components.Clickable;

public interface ButtonInterfaceFulton extends Clickable{
	void setX(int i);

	void setY(int i);
	
	void setAction(Action a);
}
