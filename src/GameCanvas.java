import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.Background.Background;
import game.circlesquare.CircleSquare;
import game.player.Player;
import game.square.SquareSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;
    public boolean gameCanvasdeflectOn = false;


    public GameCanvas() {

        this.setVisible(true);
        this.setupBackround();
        this.setupBackBuffered();
        this.setupSquare();
        this.setupPlayer();

    }

    private void setupSquare() {
//        GameObjectManager.instance.add(GameObjectManager.instance.recycle(SquareSpawner.class));
        SquareSpawner squareSpawner = GameObjectManager.instance.recycle(SquareSpawner.class);
        squareSpawner.configAction();

    }
    private void setupPlayer() {
        GameObjectManager.instance.recycle(Player.class);
    }
    private void setupBackround(){
        GameObjectManager.instance.add(GameObjectManager.instance.recycle(Background.class));
    }
    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
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
    }
}