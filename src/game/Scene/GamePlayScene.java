package game.Scene;

import core.GameObjectManager;
import game.Background.Background;
import game.player.Player;
import game.square.SquareSpawner;
import scene.Scene;

import java.awt.image.BufferedImage;

public class GamePlayScene implements Scene{

    @Override
    public void init() {
        this.setupBackround();
        this.setupSquare();
        this.setupPlayer();

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

    private void setupSquare() {
        SquareSpawner squareSpawner = GameObjectManager.instance.recycle(SquareSpawner.class);
//        squareSpawner.configAction();
    }
    private void setupPlayer(){
        GameObjectManager.instance.recycle(Player.class);
    }

    private void setupBackround(){
        GameObjectManager.instance.add(GameObjectManager.instance.recycle(Background.class));
    }

}
