package com.dikkeboshond.bunny;
import com.dikkeboshond.framework.Screen;
import com.dikkeboshond.framework.impl.AndroidGame;

public class BunnyGame extends AndroidGame {
    public Screen getStartScreen() {
        return new LoadingScreen(this);
    }
    @Override
    public void onBackPressed() {
        if (screen instanceof MainMenuScreen) {
            finish();
        } else if (screen instanceof SettingsScreen) {
            setScreen(new MainMenuScreen(this));
        } else if (screen instanceof GameScreen) {
            setScreen(new MainMenuScreen(this));
        }else {
            super.onBackPressed();
        }
    }
}