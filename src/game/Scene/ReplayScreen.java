package game.Scene;

import core.GameObjectManager;
import game.Background.Background;
import replayscreenstuff.ReplayButton;
import scene.Scene;

public class ReplayScreen implements Scene {
    @Override
    public void init() {
        GameObjectManager.instance.recycle(Background.class);
        GameObjectManager.instance.recycle(ReplayButton.class);
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

}
