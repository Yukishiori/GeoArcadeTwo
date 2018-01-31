package game.player.bullet;

import core.GameObject;
import core.Vector2D;
//import game.square.HitMediumSquare;
import game.square.bullet.BulletHit;
import hit.HitObject;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class BulletPlayer extends GameObject implements PhysicBody, HitObject {

    public BoxCollider boxCollider;
    public Vector2D velocity;
    private BulletHit bulletHit = new BulletHit();
    private BulletHit hitSquareBullet = new BulletHit();
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
        bulletHit.run(this);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject != null){
            this.isAlive = false;
            this.position.set(0,0);
        }
    }
}