package explosionpackage;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;

import java.util.Random;

public class ExplosionMaker extends GameObject {
    private Random random = new Random();
    public String[] url;
    public ExplosionMaker() {
        this.url = url;
    }

    public void config(int number, int liveTime){
        for (int i = 0; i < 360; i+= 360 / number) {
            ExplosionParticle explosionParticle = GameObjectManager.instance.recycle(ExplosionParticle.class);
            explosionParticle.url = this.url;
            explosionParticle.position.set(this.position);
            explosionParticle.velocity.set((new Vector2D(0,1).rotate(i).multiply(random.nextInt(7)+2)));
            explosionParticle.frameCounter = new FrameCounter(random.nextInt(liveTime) + 20);
        }
    }
}
