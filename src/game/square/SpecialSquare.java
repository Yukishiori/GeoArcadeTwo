package game.square;

import core.FrameCounter;
import core.GameObjectManager;
import core.Vector2D;
import game.homingsquare.HomingSquare;
import renderer.ImageRenderer;

public class SpecialSquare extends Square{
    private SquareShoot squareShoot;
    private FrameCounter frameCounter = new FrameCounter(300);
    public SpecialSquare() {
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/square/square_deadly_bullet.png");
        this.velocity.set(1,0);
         this.squareShoot = new SquareShoot();
    }

    @Override
    public void run() {
        super.run();
//        squareShoot.run(this);
        if (this.position.x >= 380 || this.position.x <=0) {
            this.velocity.x = -this.velocity.x;
        }
        if (frameCounter.run()){
            shoot();
            frameCounter.reset();
        }
    }
    public void shoot() {
        HomingSquare homingSquare = GameObjectManager.instance.recycle(HomingSquare.class);
        homingSquare.run();
        homingSquare.position.set(this.position);
    }
}
