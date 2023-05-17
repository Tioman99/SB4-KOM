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
	
	protected void wrap() {
		// wrapping object to opposite side of scene
		if(x < 0) x = Game.WIDTH;
		if(x > Game.WIDTH) x = 0;
		if(y < 0) y = Game.HEIGHT;
		if(y > Game.HEIGHT) y = 0; 
	}
	
}


















