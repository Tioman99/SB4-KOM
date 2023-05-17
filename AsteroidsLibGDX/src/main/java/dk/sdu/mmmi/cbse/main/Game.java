package dk.sdu.mmmi.cbse.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import dk.sdu.mmmi.cbse.managers.GameInputProcessor;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

public class Game implements ApplicationListener {
	
	public static int WIDTH;
	public static int HEIGHT;
	
	public static OrthographicCamera cam;
	
	private GameStateManager gsm;
	
        @Override
	public void create() { // startup method
		
		WIDTH = Gdx.graphics.getWidth(); // gets w/h from application
		HEIGHT = Gdx.graphics.getHeight();
		
		cam = new OrthographicCamera(WIDTH, HEIGHT); // sets camera to same size as the game
		cam.translate(WIDTH / 2, HEIGHT / 2); // center the camera onto the game
		cam.update(); // commits the above
		
		Gdx.input.setInputProcessor(
			new GameInputProcessor()
		);
		
		gsm = new GameStateManager();
		
	}
	
        @Override
	public void render() { // game loop
		
		// clear screen to black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();

		// testing gameKeys
		if (GameKeys.isPressed(GameKeys.SPACE)) {
			System.out.println("Space");
		}

		GameKeys.update();

	}
	
        @Override
	public void resize(int width, int height) { // window size

		}
        @Override
	public void pause() { // se

		}
        @Override
	public void resume() { // se

		}
        @Override
	public void dispose() { // se

		}
	
}
