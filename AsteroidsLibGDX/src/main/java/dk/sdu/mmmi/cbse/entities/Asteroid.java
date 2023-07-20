package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Asteroid extends SpaceObject {

    private int type;
    private static final int small = 0;
    private static final int medium = 1;
    private static final int large = 2;
    private int numPoints;
    private float[] distances;
    private float radius;
    private boolean remove;

    public Asteroid(float x, float y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;

        switch (type) {
            case small: {
                numPoints = 6;
                width = height = 16;
                speed = MathUtils.random(40, 50);
                break;
            }
            case medium: {
                numPoints = 8;
                width = height = 32;
                speed = MathUtils.random(30, 40);
                break;
            }
            case large: {
                numPoints = 8;
                width = height = 64;
                speed = MathUtils.random(20, 30);
                break;
            }
        }

        rotationSpeed = MathUtils.random(-1f, 1f);
        radians = MathUtils.random(0f, 2 * valuePi);
        dx = MathUtils.cos(radians) * speed;
        dy = MathUtils.sin(radians) * speed;

        shapex = new float[numPoints];
        shapey = new float[numPoints];
        distances = new float[numPoints];

        radius = width / 2;

        for (int i = 0; i < numPoints; i++) {
            distances[i] = MathUtils.random(radius, radius * 0.6f); // range of size difference for an asteroid
        }

    }

    private void setShape() {
        float angle = 0;
        for (int i = 0; i < numPoints; i++) {
            shapex[i] = x + MathUtils.cos(radians + angle) * distances[i];
            shapey[i] = y + MathUtils.sin(radians + angle) * distances[i];
            angle += 2 * valuePi / numPoints;
        }
    }

    public void update(float dt) {
        x += dx * dt;
        y += dy * dt;
        radians += rotationSpeed * dt;
        setShape();
        wrap();
    }

    public void draw(ShapeRenderer sr) {
        sr.setColor(1,1,1,1);
        sr.begin(ShapeRenderer.ShapeType.Line);

        for(int i = 0, j = shapex.length - 1; i < shapex.length; j = i++) {

            // draw a line between two points of two arrays with consecutive indexes i and j.
            sr.line(shapex[i], shapey[i], shapex[j], shapey[j]);

        }

        sr.end();
    }

    public int getType() {
        return type;
    }

    public boolean getRemove() {
        return remove;
    }
}
