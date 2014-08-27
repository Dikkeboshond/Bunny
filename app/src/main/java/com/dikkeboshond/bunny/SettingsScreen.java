package com.dikkeboshond.bunny;

import java.util.List;


import com.dikkeboshond.framework.Game;
import com.dikkeboshond.framework.Graphics;
import com.dikkeboshond.framework.Screen;
import com.dikkeboshond.framework.Input.TouchEvent;


public class SettingsScreen extends Screen {
	public SettingsScreen(Game game) {
		super(game);
		Settings.load(game.getFileIO());
	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
			}
			if (event.type == TouchEvent.TOUCH_UP) {
			}
		}
	}
	
	public void changeSettings(){
		Settings.save(game.getFileIO());
	}
	
	private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        return(event.x > x && event.x < x + width - 1 && 
           event.y > y && event.y < y + height - 1);
    }

	@Override
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.background, 0, 0);
	}

	@Override
	public void pause() {
		changeSettings();
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		
	}

}
