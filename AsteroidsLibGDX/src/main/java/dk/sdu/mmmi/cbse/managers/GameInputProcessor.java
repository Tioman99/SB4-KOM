package dk.sdu.mmmi.cbse.managers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class GameInputProcessor extends InputAdapter { // Changed to switch cases
	
	public boolean keyDown(int k) {
		switch (k) {
			case Keys.UP: {
				GameKeys.setKey(GameKeys.UP, true);
			}
			case Keys.LEFT: {
				GameKeys.setKey(GameKeys.LEFT, true);
			}
			case Keys.DOWN: {
				GameKeys.setKey(GameKeys.DOWN, true);
			}
			case Keys.RIGHT: {
				GameKeys.setKey(GameKeys.RIGHT, true);
			}
			case Keys.ENTER: {
				GameKeys.setKey(GameKeys.ENTER, true);
			}
			case Keys.ESCAPE: {
				GameKeys.setKey(GameKeys.ESCAPE, true);
			}
			case Keys.SPACE: {
				GameKeys.setKey(GameKeys.SPACE, true);
			}
			case Keys.SHIFT_LEFT:
			case Keys.SHIFT_RIGHT: {
				GameKeys.setKey(GameKeys.SHIFT, true); // This has OR functionality
			}
		}
		return true;
	}

	public boolean keyUp(int k) {
		switch (k) {
			case Keys.UP: {
				GameKeys.setKey(GameKeys.UP, false);
			}
			case Keys.LEFT: {
				GameKeys.setKey(GameKeys.LEFT, false);
			}
			case Keys.DOWN: {
				GameKeys.setKey(GameKeys.DOWN, false);
			}
			case Keys.RIGHT: {
				GameKeys.setKey(GameKeys.RIGHT, false);
			}
			case Keys.ENTER: {
				GameKeys.setKey(GameKeys.ENTER, false);
			}
			case Keys.ESCAPE: {
				GameKeys.setKey(GameKeys.ESCAPE, false);
			}
			case Keys.SPACE: {
				GameKeys.setKey(GameKeys.SPACE, false);
			}
			case Keys.SHIFT_LEFT: {
				switch (k) {
					case Keys.SHIFT_RIGHT: {
						GameKeys.setKey(GameKeys.SHIFT, false); // This has AND functionality, I know its ugly
					}
				}
			}
		}
		return true;
	}

	/*
	public boolean keyDown(int k) {
		if(k == Keys.UP) {
			GameKeys.setKey(GameKeys.UP, true);
		}
		if(k == Keys.LEFT) {
			GameKeys.setKey(GameKeys.LEFT, true);
		}
		if(k == Keys.DOWN) {
			GameKeys.setKey(GameKeys.DOWN, true);
		}
		if(k == Keys.RIGHT) {
			GameKeys.setKey(GameKeys.RIGHT, true);
		}
		if(k == Keys.ENTER) {
			GameKeys.setKey(GameKeys.ENTER, true);
		}
		if(k == Keys.ESCAPE) {
			GameKeys.setKey(GameKeys.ESCAPE, true);
		}
		if(k == Keys.SPACE) {
			GameKeys.setKey(GameKeys.SPACE, true);
		}
		if(k == Keys.SHIFT_LEFT || k == Keys.SHIFT_RIGHT) {
			GameKeys.setKey(GameKeys.SHIFT, true);
		}
		return true;
	}
	
	public boolean keyUp(int k) {
		if(k == Keys.UP) {
			GameKeys.setKey(GameKeys.UP, false);
		}
		if(k == Keys.LEFT) {
			GameKeys.setKey(GameKeys.LEFT, false);
		}
		if(k == Keys.DOWN) {
			GameKeys.setKey(GameKeys.DOWN, false);
		}
		if(k == Keys.RIGHT) {
			GameKeys.setKey(GameKeys.RIGHT, false);
		}
		if(k == Keys.ENTER) {
			GameKeys.setKey(GameKeys.ENTER, false);
		}
		if(k == Keys.ESCAPE) {
			GameKeys.setKey(GameKeys.ESCAPE, false);
		}
		if(k == Keys.SPACE) {
			GameKeys.setKey(GameKeys.SPACE, false);
		}
		if(k == Keys.SHIFT_LEFT && k == Keys.SHIFT_RIGHT) {
			// I've changed the operator to AND as it should only setKey to false when both l AND r keys are released
			GameKeys.setKey(GameKeys.SHIFT, false);
		}
		return true;
	}
	*/
	
}








