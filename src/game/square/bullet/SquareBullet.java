package game.square.bullet;

        import core.GameObject;
        import core.Vector2D;
        import game.player.explosion.ExplosionBullet;
        import physic.BoxCollider;
        import physic.PhysicBody;
        import renderer.ImageRenderer;

public class SquareBullet extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;


    public SquareBullet() {
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(10,10);
    }
    public void run() {
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position);
        if (this.position.y >= 600) isAlive = false;
    }

    public void getHit() {
        this.isAlive = false;
//        this.velocity.set(0,0);
//        this.position.set(0,0);
        ExplosionBullet explosionBullet = new ExplosionBullet();
        explosionBullet.position.set(this.position);
        explosionBullet.config();
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
