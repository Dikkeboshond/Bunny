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

public class MainMenuScreen extends Screen {

    List<Bunny> bunnies;
    Random random;

	public MainMenuScreen(Game game) {
		super(game);
        bunnies = new ArrayList<Bunny>();
        random = new Random();
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, g.getWidth() / 4, 250, g.getWidth() / 2, 100)) {
					game.setScreen(new GameScreen(game));
					return;
				}
				if (inBounds(event, g.getWidth() / 4, 550, g.getWidth() / 2, 100)) {
					game.setScreen(new SettingsScreen(game));
					return;
				}
			}
		}
        if (random.nextInt(100) < 2) {
            bunnies.add(new Bunny(game));
        }
        List<Bunny> oldBunnies = new ArrayList<Bunny>();
        for (Bunny b : bunnies) {
            b.update(deltaTime);
            if (b.destroy)
                oldBunnies.add(b);
        }
        bunnies.removeAll(oldBunnies);
	}
	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1) 
            return true;
        else
            return false;
    }

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
        g.drawPixmap(Assets.sky, 0, 0);
        for (Bunny b : bunnies)
            b.draw();
        g.drawText("Play", 100, Typeface.DEFAULT, g.getWidth() / 2, 250, Color.WHITE);
        g.drawText("Settings", 24, Typeface.DEFAULT, g.getWidth() / 2, 550, Color.WHITE);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}
}
