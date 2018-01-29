package game.square;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.player.bullet.HitPlayerBySquare;
import game.square.explosion.ExplosionSquare;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import utils.Utils;

public class Square extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public boolean hasGun = false;
    FrameCounter frameCounter = new FrameCounter(30);
    public BoxCollider boxCollider ;
    private SquareShoot squareShoot = new SquareShoot();
    private HitPlayerBySquare hitPlayer = new HitPlayerBySquare() ;

    public Square() {
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/square/enemy_square_small.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(20,20);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);

        if (hasGun) {
            if (frameCounter.run()) {
                this.squareShoot.run(this);
            }
        }
        this.boxCollider.position.set(this.position);
        hitPlayer.run(this);
        if (this.position.y>= 610) this.getHit();
    }

    public void getHit() {
        this.isAlive = false;
        this.velocity = new Vector2D();
        ExplosionSquare explosionSquare = GameObjectManager.instance.recycle(ExplosionSquare.class);
        explosionSquare.position.set(this.position);
        explosionSquare.config();
    }
    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
