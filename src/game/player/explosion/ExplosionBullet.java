package game.player.explosion;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class ExplosionBullet extends GameObject {
    public void config() {
        Random random = new Random();
        for (int i = 45; i < 361 ; i += 360/20) {
            ExplosionParticleBullet explosionParticleBullet = GameObjectManager.instance.recycle(ExplosionParticleBullet.class);
            explosionParticleBullet.position.set(this.position);
            explosionParticleBullet.velocity.set((new Vector2D(0,1).rotate(i).multiply(random.nextInt(5)+3)));
            explosionParticleBullet.frameCounter = new FrameCounter(random.nextInt(10)+5);
        }
    }
}
