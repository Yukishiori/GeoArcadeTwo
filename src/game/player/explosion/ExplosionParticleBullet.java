package game.player.explosion;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class ExplosionParticleBullet extends GameObject {
    private Random random = new Random();
    public Vector2D velocity = new Vector2D();
    public FrameCounter frameCounter;
    private String[] url= {
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_1.png",
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_2.png",
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_3.png",
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_4.png",
            "asset-geoarcade-master/resources/square/explosion/enemy_square_explosion_particle_5.png"
    };
    public  ExplosionParticleBullet() {
        this.renderer = new ImageRenderer(url[random.nextInt(url.length)]);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()){
            this.isAlive = false;
        } else {
            this.position.addUp(velocity);
        }
    }
}
