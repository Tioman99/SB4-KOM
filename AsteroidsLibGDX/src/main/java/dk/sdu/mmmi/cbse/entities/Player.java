package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.main.Game;
import java.util.ArrayList;

public class Player extends SpaceObject {
    private boolean left;
    private boolean right;
    private boolean up;
    private float[] flamex;
    private float[] flamey;
    private float accelerationTime;
    private float maxSpeed;
    private float acceleration;
    private float deceleration;
    private ArrayList<Bullet> bullets;
    private final int maxBullets = 3;

    public Player(ArrayList<Bullet> bullets) {

        x = Game.WIDTH / 2;
        y = Game.HEIGHT / 2;

        maxSpeed = 200; // pixels per second
        acceleration = 200;
        deceleration = 10;

        shapex = new float[4]; // polygon will have 4 points
        shapey = new float[4];
        flamex = new float[3];
        flamey = new float[3];

        radians = valuePi / 2;
        rotationSpeed = 3;

        this.bullets = bullets;

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

    private void setFlame() {
        flamex[0] = x + MathUtils.cos(radians - 5 * valuePi / 6) * 6;
        flamey[0] = y + MathUtils.sin(radians - 5 * valuePi / 6) * 6;

        flamex[1] = x + MathUtils.cos(radians + 5 * valuePi / 6) * 6;
        flamey[1] = y + MathUtils.sin(radians + 5 * valuePi / 6) * 6;

        flamex[2] = x + MathUtils.cos(radians - valuePi) * (6 + accelerationTime * 50);
        flamey[2] = y + MathUtils.sin(radians - valuePi) * (6 + accelerationTime * 50);
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

    public void shoot() {
        if (bullets.size() == maxBullets) {
            return;
        } else {
            bullets.add(new Bullet(x, y, radians));
        }

    }

    public void update(float dt) {

        // I have moved setShape call up closer to the setFlame call to minimize the visual delay
        setShape();

        // accelerating
        if (up) {
            dx += MathUtils.cos(radians) * acceleration * dt;
            dy += MathUtils.sin(radians) * acceleration * dt;
            // I prefer having only one if (up) statement, thus setFlame is called here
            setFlame();
            accelerationTime += 5 * dt;
            if (accelerationTime > 0.2f) {
                accelerationTime = 0.1f;
            }
        }

        // turning
        if (left) {
            radians += rotationSpeed * dt;
        } else if (right) {
            radians -= rotationSpeed * dt;
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

        // screen wrap
        wrap();

    }

    public void draw(ShapeRenderer sr) {

        sr.setColor(1, 1, 1, 1);

        sr.begin(ShapeType.Line);

        // draw ship
        for(int i = 0, j = shapex.length - 1; i < shapex.length; j = i++) {

            // draw a line between two points of two arrays with consecutive indexes i and j.
            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);

        }

        // draw flame
        sr.setColor(0, 1, 1, 1);

        if (up) {
            for(int i =0, j = flamex.length - 1; i < flamex.length; j = i++) {

                sr.line(flamex[i], flamey[i], flamex[j], flamey[j]);

            }
        }

        sr.end();

    }

}
