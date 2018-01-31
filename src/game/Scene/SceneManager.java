package game.Scene;

import scene.Scene;

public class SceneManager {
    public static SceneManager instance = new SceneManager();
    private Scene currentScene;
    private Scene nextScene;

    private SceneManager() {

    }

    public void changeScene(Scene scene) {
        this.nextScene = scene;
    }
    public void performChangeSceneIfNeeded() {
        if (nextScene != null) {
            if (currentScene != null) {
                this.currentScene.deinit();
            }
            this.nextScene.init();
            this.currentScene = this.nextScene;
            this.nextScene = null;
        }
    }
}
