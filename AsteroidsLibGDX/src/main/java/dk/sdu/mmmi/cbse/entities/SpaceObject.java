package dk.sdu.mmmi.cbse.entities;

import dk.sdu.mmmi.cbse.main.Game;

public class SpaceObject {
	
	protected float x;
	protected float y; // position
	
	protected float dx;
	protected float dy; // vector (moving force)
	
	protected float radians; // facing direction
	protected float speed; // vector speed
	protected float rotationSpeed; // radians speed
	
	protected int width;
	protected int height; // dimensions
	
	protected float[] shapex;
	protected float[] shapey; // polygon
	
	protected boolean wrap() {
		// wrapping object to opposite side of scene and returning true if warped
		boolean out = false;
		if(x < 0) {
			x = Game.WIDTH;
			out = true;
		}
		if(x > Game.WIDTH) {
			x = 0;
			out = true;
		}
		if(y < 0) {
			y = Game.HEIGHT;
			out = true;
		}
		if(y > Game.HEIGHT) {
			y = 0;
			out = true;
		}
		return out;
	}
	
}


















