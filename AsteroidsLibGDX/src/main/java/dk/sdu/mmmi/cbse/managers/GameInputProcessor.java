package dk.sdu.mmmi.cbse.managers;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class GameInputProcessor extends InputAdapter { // Changed to switch cases

	public boolean keyDown(int k) {
		switch (k) {
			case Keys.UP: {
				GameKeys.setKey(GameKeys.UP, true);
				break;
			}
			case Keys.LEFT: {
				GameKeys.setKey(GameKeys.LEFT, true);
				break;
			}
			case Keys.DOWN: {
				GameKeys.setKey(GameKeys.DOWN, true);
				break;
			}
			case Keys.RIGHT: {
				GameKeys.setKey(GameKeys.RIGHT, true);
				break;
			}
			case Keys.ENTER: {
				GameKeys.setKey(GameKeys.ENTER, true);
				break;
			}
			case Keys.ESCAPE: {
				GameKeys.setKey(GameKeys.ESCAPE, true);
				break;
			}
			case Keys.SPACE: {
				GameKeys.setKey(GameKeys.SPACE, true);
				break;
			}
			case Keys.SHIFT_LEFT:
			case Keys.SHIFT_RIGHT: {
				GameKeys.setKey(GameKeys.SHIFT, true); // This has OR functionality
				break;
			}
		}
		return true;
	}

	public boolean keyUp(int k) {
		switch (k) {
			case Keys.UP: {
				GameKeys.setKey(GameKeys.UP, false);
				break;
			}
			case Keys.LEFT: {
				GameKeys.setKey(GameKeys.LEFT, false);
				break;
			}
			case Keys.DOWN: {
				GameKeys.setKey(GameKeys.DOWN, false);
				break;
			}
			case Keys.RIGHT: {
				GameKeys.setKey(GameKeys.RIGHT, false);
				break;
			}
			case Keys.ENTER: {
				GameKeys.setKey(GameKeys.ENTER, false);
				break;
			}
			case Keys.ESCAPE: {
				GameKeys.setKey(GameKeys.ESCAPE, false);
				break;
			}
			case Keys.SPACE: {
				GameKeys.setKey(GameKeys.SPACE, false);
				break;
			}
			case Keys.SHIFT_LEFT: {
				switch (k) {
					case Keys.SHIFT_RIGHT: {
						GameKeys.setKey(GameKeys.SHIFT, false); // This has AND functionality, I know its ugly
						break;
					}
				}
				break;
			}
		}
		return true;
	}
}








