package game.Scene;

import core.GameObjectManager;
import game.Background.Background;
import game.player.Player;
import game.square.SquareSpawner;

import javax.sound.sampled.*;
import scene.Scene;
import utils.AudioUtils;

import java.awt.image.BufferedImage;

public class GamePlayScene implements Scene{
    Clip clip;

    @Override
    public void init() {
        this.setupBackround();
        this.setupSquare();
        this.setupPlayer();
        this.soundBackGround();

    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
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

    private void soundBackGround() {
        this.clip = AudioUtils.instance.loadSound("asset-geoarcade-master/resources/sound/bgm/bgmwav.wav");
        this.clip.loop(-1);
        this.clip.start();
    }
}
