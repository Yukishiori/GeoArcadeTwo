package game.circlesquare;

import core.GameObject;
import core.Vector2D;

public class InvinsibleObject extends GameObject{
    public Vector2D velocity;
    public InvinsibleObject() {
//        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/square/enemy_square_bullet.png");
        this.velocity = new Vector2D();

    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        if (this.position.x >= 350 || this.position.x <= 50 ) {
            this.velocity.x = -this.velocity.x;
        }
        if (this.position.y >= 550 || this.position.y <= 50 ) {
            this.velocity.y = -this.velocity.y;
        }
    }
}
