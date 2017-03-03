 package memory;

public class Move implements MoveInterface{
	
	private ButtonInterfaceFulton button;
	
	public Move(ButtonInterfaceFulton b) {
		this.button = b;
	}

	@Override
	public ButtonInterfaceFulton getButton() {
		return button;
	}

}
