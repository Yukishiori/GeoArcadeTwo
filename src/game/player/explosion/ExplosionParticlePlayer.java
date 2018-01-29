package game.player.explosion;

import core.FrameCounter;
import core.GameObject;
import core.Vector2D;
import renderer.ImageRenderer;

import java.util.Random;
import java.util.Vector;

public class ExplosionParticlePlayer  extends GameObject {
    private String[] url = {"asset-geoarcade-master/resources/player/explostion/player_explosion_particle_1.png",
            "asset-geoarcade-master/resources/player/explostion/player_explosion_particle_2.png",
            "asset-geoarcade-master/resources/player/explostion/player_explosion_particle_3.png",
            "asset-geoarcade-master/resources/player/explostion/player_explosion_particle_4.png",
            "asset-geoarcade-master/resources/player/explostion/player_explosion_particle_5.png"};
    private Random random = new Random();
    public Vector2D velocity;
    public FrameCounter frameCounter;
    public ExplosionParticlePlayer(){
        this.renderer = new ImageRenderer(this.url[random.nextInt(url.length)]);
        this.velocity = new Vector2D();
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
}
