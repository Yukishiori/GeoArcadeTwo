import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.Background.Background;
import game.Scene.GameOverviewScene;
import game.Scene.GamePlayScene;
import game.Scene.ReplayScreen;
import game.Scene.SceneManager;
import game.circlesquare.CircleSquare;
import game.player.Player;
import game.square.SquareSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;

    public GameCanvas() {
        this.setVisible(true);
        this.setupBackBuffered();
        SceneManager.instance.changeScene(new GameOverviewScene());
    }



    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        GameObjectManager.instance.renderAll(this.graphics);
        this.repaint();
    }

    public void runAll() {
        GameObjectManager.instance.runAll();
        SceneManager.instance.performChangeSceneIfNeeded();
    }
    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

}