package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.main.Game;

public class Player extends SpaceObject {

    private boolean left;
    private boolean right;
    private boolean up;
    private final float valuePi = (float) Math.PI;
    private float maxSpeed;
    private float acceleration;
    private float deceleration;

    public Player() {

        x = Game.WIDTH / 2;
        y = Game.HEIGHT / 2;

        maxSpeed = 300; // pixels per second
        acceleration = 200;
        deceleration = 10;

        shapex = new float[4]; // polygon will have 4 points
        shapey = new float[4];

        radians = valuePi / 2;
        rotationSpeed = 3;

    }

    private void setShape() {
        shapex[0] = x + MathUtils.cos(radians) * 8;
        shapey[0] = y + MathUtils.sin(radians) * 8;

        shapex[1] = x + MathUtils.cos(radians - 4 * valuePi / 5) * 8;
        shapey[1] = y + MathUtils.sin(radians - 4 * valuePi / 5) * 8; // this line had misspelled pi

        shapex[2] = x + MathUtils.cos(radians + valuePi) * 5;
        shapey[2] = y + MathUtils.sin(radians + valuePi) * 5;

        shapex[3] = x + MathUtils.cos(radians + 4 * valuePi / 5) * 8;
        shapey[3] = y + MathUtils.sin(radians + 4 * valuePi / 5) * 8;
    }

    public void setLeft(boolean b) {
        left = b;
    }

    public void setRight(boolean b) {
        right = b;
    }

    public void setUp(boolean b) {
        up = b;
    }

    public void update(float dt) {

        // turning
        if (left) {
            radians += rotationSpeed * dt;
        } else if (right) {
            radians -= rotationSpeed * dt;
        }

        // accelerating
        if (up) {
            dx += MathUtils.cos(radians) * acceleration * dt;
            dy += MathUtils.sin(radians) * acceleration * dt;
        }

        // speed vec
        float vec = (float) Math.sqrt(dx * dx + dy * dy);

        // decelerating
        if (vec > 0) {
            dx -= (dx / vec) * deceleration * dt;
            dy -= (dy / vec) * deceleration * dt;
        }

        // speed capping
        if (vec > maxSpeed) {
            dx = (dx / vec) * maxSpeed;
            dy = (dy / vec) * maxSpeed;
        }

        // set position
        x += dx * dt;
        y += dy * dt;

        // set shape, re-calculates player shape
        setShape();

        // screen wrap
        wrap();

    }

    public void draw(ShapeRenderer sr) {

        sr.setColor(1, 1, 1, 1);

        sr.begin(ShapeType.Line);

        for (int i = 0, j = shapex.length - 1; i < shapex.length; j = i++) {

            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]); // draw line between two points of two arrays

        }

        sr.end();

    }

}
