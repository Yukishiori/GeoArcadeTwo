package game.player.bullet;

import core.GameObject;
import core.Vector2D;
//import game.square.HitMediumSquare;
import game.square.bullet.HitSquare;
import game.square.bullet.HitSquareBullet;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import utils.Utils;

public class BulletPlayer extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    public Vector2D velocity;
    private HitSquare hitSquare = new HitSquare();
    private HitSquareBullet hitSquareBullet = new HitSquareBullet();
//    private HitMediumSquare hitMediumSquare = new HitMediumSquare();

    public BulletPlayer() {
        this.boxCollider = new BoxCollider(10,10);
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/player/player_bullet.png");
        this.velocity = new Vector2D();

    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
        this.boxCollider.position.set(this.position);
        this.hitSquare.run(this);
        this.hitSquareBullet.run(this);
        if (this.position.y <= 0) {
            getHit();
        }
    }

    public void getHit() {
        this.isAlive = false;
        this.position.set(0,0);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}