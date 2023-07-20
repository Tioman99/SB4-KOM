package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Asteroid;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.ArrayList;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;
	private ArrayList<Bullet> bullets;
	private ArrayList<Asteroid> asteroids;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		bullets = new ArrayList<Bullet>();
		player = new Player(bullets);
		asteroids = new ArrayList<Asteroid>();
		// testing
		asteroids.add(new Asteroid(100, 100, 0));
		asteroids.add(new Asteroid(200, 200, 1));
		asteroids.add(new Asteroid(300, 300, 2));

	}
	
	public void update(float dt) {
		
		handleInput();

		// checking bullet list, updating their lifeTime and removing if getRemove is true
		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).update(dt);
			if (bullets.get(i).getRemove()) {
				bullets.remove(i);
				i--;
			}
		}
		player.update(dt);
		for (int i = 0; i < asteroids.size(); i++) {
			asteroids.get(i).update(dt);
			if (asteroids.get(i).getRemove()) {
				asteroids.remove(i);
				i--;
			}
			}
		}
	
	public void draw() {
		player.draw(sr);

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(sr);
		}

		for (int i = 0; i < asteroids.size(); i++) {
			asteroids.get(i).draw(sr);
		}

	}
	
	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));
		if (GameKeys.isPressed(GameKeys.SPACE)) {
			player.shoot();
		}
	}
	
	public void dispose() {}
	
}









