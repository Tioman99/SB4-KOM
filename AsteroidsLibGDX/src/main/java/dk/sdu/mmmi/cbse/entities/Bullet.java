package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Bullet extends SpaceObject {

    private float lifeTime;
    private float maxTime;
    private boolean remove;

    public Bullet(float x, float y, float radians) {
        this.x = x;
        this.y = y;
        this.radians = radians;

        float speed = 360;
        dx = MathUtils.cos(radians) * speed;
        dy = MathUtils.sin(radians) * speed;

        width = height = 1;
        lifeTime = 0;
        maxTime = 1;
    }

    public boolean remove() {
        return remove;
    }

    public void update(float dt) {
        x += dx * dt;
        y += dy * dt;
        wrap();
        lifeTime += dt;
        if(lifeTime > maxTime) {
            remove = true;
        }
    }

    public void draw(ShapeRenderer sr) {

    }

}
