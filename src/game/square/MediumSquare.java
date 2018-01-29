package game.square;
import core.Vector2D;
import game.player.bullet.HitPlayerBySquare;
import physic.BoxCollider;
import renderer.ImageRenderer;
import utils.Utils;

public class MediumSquare extends Square{
    public boolean hasGun = false;
    public Vector2D velocity = new Vector2D();
    private SquareShoot squareShoot = new SquareShoot();
    public BoxCollider boxCollider = new BoxCollider(50,50);
    private HitPlayerBySquare hitPlayerBySquare = new HitPlayerBySquare();


    public MediumSquare(){
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/square/enemy_square_medium.png");
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        hitPlayerBySquare.run(this);
        this.boxCollider.position.set(this.position);
        if (hasGun){
            squareShoot.run(this);
        }
        if (this.position.x >= 380 || this.position.x <=0) this.velocity.x = -this.velocity.x;
    }

    @Override
    public void getHit() {
        super.getHit();
        this.velocity = new Vector2D();
    }
}

