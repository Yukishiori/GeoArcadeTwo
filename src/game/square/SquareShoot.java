package game.square;

import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.square.bullet.SquareBullet;

public class SquareShoot {
    FrameCounter frameCounter;
    public SquareShoot(){
        this.frameCounter = new FrameCounter(150);
    }
    public void run(Square square) {
        if (this.frameCounter.run()) {
            SquareBullet squareBullet = GameObjectManager.instance.recycle(SquareBullet.class);

            squareBullet.position.set(square.position);
            squareBullet.velocity.set(new Vector2D(0, 7));
            this.frameCounter.reset();
        }
    }
}