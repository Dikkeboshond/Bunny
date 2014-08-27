package com.dikkeboshond.bunny;

import android.util.Log;

import com.dikkeboshond.framework.Game;
import com.dikkeboshond.framework.Graphics;

/**
 * Created by Christiaan on 27-8-2014.
 */
public class Sun {
    int orbit;
    int radius;
    int centerX, centerY;
    Graphics g;
    float timePassed;
    public Sun(Game game) {
        g = game.getGraphics();
        timePassed = 0;
        radius = Assets.sun.getHeight() / 2;
        orbit = 700;
        centerX = g.getWidth() / 2 - radius;
        centerY = g.getHeight();
    }

    public void update(float deltaTime) {
        timePassed += deltaTime;
    }

    public void draw() {
        float x = centerX + (float) (orbit * Math.sin(timePassed / 5));
        float y = centerY + (float) (orbit * Math.cos(timePassed / 5));
        g.drawPixmap(Assets.sun, x, y);
    }
}
