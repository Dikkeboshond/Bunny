package com.dikkeboshond.bunny;

import com.dikkeboshond.framework.Game;
import com.dikkeboshond.framework.Graphics;
import com.dikkeboshond.framework.Input;

import java.util.Random;

/**
 * Created by Christiaan on 26-8-2014.
 */
public class Bunny {
    private static final float LIVING_TIME = 4;
    private static final float HALVE_LIVING_TIME = LIVING_TIME / 2;
    Random r;
    float x, y;
    int height, width;
    Graphics g;
    float timePassed;
    boolean destroy = false;
    boolean clicked = false;
    public Bunny(Game game) {
        g = game.getGraphics();
        r = new Random();
        height = Assets.bunny.getHeight();
        width = Assets.bunny.getWidth();
        x = r.nextInt(g.getWidth() - width);
        y = g.getHeight();
        timePassed = 0;
    }

    public void update(float deltaTime) {
        timePassed += deltaTime;
        y = calculateHeight(timePassed) + 50;
        if (timePassed > LIVING_TIME) {
            destroy = true;
        }
    }

    public boolean isTouched(Input.TouchEvent e) {
        return (e.x > x && e.x < x + width - 1 && e.y > y && e.y < y + height - 1);
    }

    public float calculateHeight(float timePassed) {
        return (float) Math.pow((double) ((timePassed - HALVE_LIVING_TIME) * 20), 2.0);
    }

    public void draw() {
        g.drawPixmap(Assets.bunny, x, y);
    }
}
