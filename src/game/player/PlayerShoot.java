package game.player;
import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.player.bullet.BulletPlayer;
import utils.AudioUtils;

import javax.sound.sampled.*;

public class PlayerShoot {

    Clip clip;
    private FrameCounter frameCounter = new FrameCounter(15);
    public void run(Player player) {
        if (this.frameCounter.run()) {
            BulletPlayer bulletPlayer1 = GameObjectManager.instance.recycle(BulletPlayer.class);
            BulletPlayer bulletPlayer2 = GameObjectManager.instance.recycle(BulletPlayer.class);
            bulletPlayer2.position.set(player.position.x - 10, player.position.y);
            bulletPlayer1.position.set(player.position.x + 10, player.position.y);
            bulletPlayer2.velocity.set(new Vector2D(0, 5));
            bulletPlayer1.velocity.set(new Vector2D(0, 5));
            shootSound();
            frameCounter.reset();
        }
    }

    public void shootSound() {
        clip = AudioUtils.instance.loadSound("asset-geoarcade-master/resources/sound/sfx/player_shoot.wav");
        clip.loop(1);
        clip.start();
    }
}
