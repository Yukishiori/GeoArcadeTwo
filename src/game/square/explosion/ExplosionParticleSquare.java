package game.square.explosion;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import renderer.ImageRenderer;

import java.util.Random;

public class ExplosionParticleSquare extends GameObject{
    private Random random = new Random();
    public Vector2D velocity;
    public FrameCounter frameCounter;
    private String[] url = {
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_1.png",
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_2.png",
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_3.png",
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_4.png",
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_5.png"};
    public ExplosionParticleSquare() {
        this.renderer = new ImageRenderer(this.url[random.nextInt(5)]);
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        if (frameCounter.run()){
            this.isAlive = false;
        } else {
            this.position.addUp(this.velocity);
        }
    }
}
