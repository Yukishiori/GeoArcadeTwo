package game.homingsquare;

import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.player.bullet.HitPlayerBySquare;
import game.player.Player;
import game.square.Square;
import physic.BoxCollider;
import renderer.ImageRenderer;
import utils.Utils;

public class HomingSquare extends Square {
    public BoxCollider boxCollider = new BoxCollider(10,10);
    public HomingSquare(){
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/square/enemy_square_bullet.png");
    }
    private Player player = GameObjectManager.instance.getPlayer();
    public Vector2D homingVector = new Vector2D();
    @Override
    public void run() {
        super.run();
        this.boxCollider.position.set(this.position);
        this.homingVector = player.position.subtract(this.position);
        this.homingVector.set(homingVector.normalize());
        this.position.addUp(homingVector.multiply(2));
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit() {
        super.getHit();
        homingVector.set(0,0);
    }
}
