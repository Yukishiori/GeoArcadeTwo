package game.square.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.player.bullet.BulletPlayer;
import game.square.Square;
import game.square.bullet.SquareBullet;
import hit.RunHitObject;

public class BulletHit {
    private RunHitObject[] arrays;

    public BulletHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(Square.class),
                new RunHitObject(SquareBullet.class)
        };
    }

    public void run(BulletPlayer bulletPlayer) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(bulletPlayer);
        }
    }
}
