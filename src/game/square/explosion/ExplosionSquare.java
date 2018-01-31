package game.square.explosion;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class ExplosionSquare extends GameObject{
    private Random random = new Random();
    public ExplosionSquare() {

    }

    public void config() {
        for (double i = 0; i <= 360 ; i += 360/30 ) {
            ExplosionParticleSquare explosionParticleSquare = GameObjectManager.instance.recycle(ExplosionParticleSquare.class);
            explosionParticleSquare.position.set(this.position);
            explosionParticleSquare.velocity.set((new Vector2D(0,1)).rotate(i).multiply(random.nextInt(3)+2));
            explosionParticleSquare.frameCounter = new FrameCounter(random.nextInt(1) + 100);
        }
    }
}
