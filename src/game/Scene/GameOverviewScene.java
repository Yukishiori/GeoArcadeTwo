package game.Scene;

import core.GameObjectManager;
import game.Background.Background;
import game.overviewscenestuff.Logo;
import game.overviewscenestuff.PlayButton;
import scene.Scene;

public class GameOverviewScene implements Scene{
    @Override
    public void init() {
        setupBackground();
        setupPlayButton();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

    private void setupPlayButton() {
        GameObjectManager.instance.recycle(PlayButton.class);
    }
    private void setupBackground() {
        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.recycle(Logo.class);
    }
}
