package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import dk.sdu.mmmi.cbse.entities.Bullet;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.ArrayList;

public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;
	private ArrayList<Bullet> bullets;
	
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		bullets = new ArrayList<Bullet>();
		player = new Player(bullets);
		
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

	}
	
	public void draw() {
		player.draw(sr);

		for (int i = 0; i < bullets.size(); i++) {
			bullets.get(i).draw(sr);
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









