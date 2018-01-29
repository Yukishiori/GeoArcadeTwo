package explosionpackage;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import renderer.ImageRenderer;

import java.util.Random;

public class ExplosionParticle extends GameObject {
    public Vector2D velocity;
    private Random random = new Random();
    public FrameCounter frameCounter;
    public String[] url;

    public ExplosionParticle(String... url) {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer(this.url[random.nextInt(url.length)]);

    }

    @Override
    public void run() {
        super.run();
        if(this.frameCounter.run()){
            this.isAlive = false;
        } else {
            this.position.addUp(this.velocity);
        }
    }

    @Override
    public void reset() {
        super.reset();
    }
}
