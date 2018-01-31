package game.player.explosion;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class ExplosionPlayer extends GameObject {
    public ExplosionPlayer() {

    }

    public void config() {
        Random random = new Random();
        for (double i = 0.0; i <= 360; i+=360 / 30) {
            ExplosionParticlePlayer explosionParticlePlayer = GameObjectManager.instance.recycle(ExplosionParticlePlayer.class);
            explosionParticlePlayer.position.set(this.position);
            explosionParticlePlayer.velocity.set((new Vector2D(0.0f, 1.0f)).rotate(i).multiply(random.nextInt(8)+2));
            explosionParticlePlayer.frameCounter = new FrameCounter(random.nextInt(100) + 20 );
        }
    }
}
