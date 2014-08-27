package com.dikkeboshond.bunny;

import com.dikkeboshond.framework.Audio;
import com.dikkeboshond.framework.Game;
import com.dikkeboshond.framework.Graphics;
import com.dikkeboshond.framework.Graphics.PixmapFormat;
import com.dikkeboshond.framework.Screen;

public class LoadingScreen extends Screen {

	public LoadingScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Audio a = game.getAudio();
		Assets.background = g.newPixmap("background_mdpi.png", PixmapFormat.ARGB4444);
        Assets.bunny = g.newPixmap("bunny.png", PixmapFormat.ARGB4444);
        Assets.sun = g.newPixmap("sun.png", PixmapFormat.ARGB4444);
        Assets.cloud = g.newPixmap("cloud.png", PixmapFormat.ARGB4444);
        Assets.sky = g.newPixmap("sky.jpg", PixmapFormat.RGB565);
		Settings.load(game.getFileIO());
		game.setScreen(new MainMenuScreen(game));
	}

	@Override
	public void present(float deltaTime) {
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

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
