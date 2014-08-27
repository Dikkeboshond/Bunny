package com.dikkeboshond.bunny;

import android.graphics.Color;
import android.graphics.Typeface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dikkeboshond.framework.Game;
import com.dikkeboshond.framework.Graphics;
import com.dikkeboshond.framework.Input.TouchEvent;
import com.dikkeboshond.framework.Screen;

public class GameScreen extends Screen {
    List<Bunny> bunnies;
    Sun sun;
    Random random;
    int score;
    float timePassed;
    public GameScreen(Game game) {
        super(game);
        bunnies = new ArrayList<Bunny>();
        random = new Random();
        timePassed = 0;
        sun = new Sun(game);
    }

    @Override
    public void update(float deltaTime) {
        timePassed += deltaTime;
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        List<Bunny> touchedBunnies = new ArrayList<Bunny>();
        List<Bunny> oldBunnies = new ArrayList<Bunny>();
        for (TouchEvent e : touchEvents) {
            if (e.type == TouchEvent.TOUCH_UP) {
                for (Bunny b : bunnies) {
                    if (b.isTouched(e)) {
                        touchedBunnies.add(b);
                        break;
                    }
                }
            }
        }
        sun.update(deltaTime);
        for (Bunny b : touchedBunnies) {
            bunnies.remove(b);
            score += 10;
        }
        for (Bunny b : bunnies) {
            b.update(deltaTime);
            if (b.destroy)
                oldBunnies.add(b);
        }
        bunnies.removeAll(oldBunnies);
        if (random.nextInt(100) < 1) {
            bunnies.add(new Bunny(game));
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        g.drawPixmap(Assets.sky, 0, 0);
        sun.draw();
        for (Bunny b : bunnies) {
            b.draw();
        }
        g.drawText("" + score, 48, Typeface.SANS_SERIF, g.getWidth() / 2, 24, Color.BLACK);
        g.drawPixmap(Assets.background, 0, g.getHeight() - Assets.background.getHeight());
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {

    }
}