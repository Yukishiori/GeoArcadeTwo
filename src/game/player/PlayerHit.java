package game.player;

import game.square.Square;
import game.square.bullet.SquareBullet;
import hit.RunHitObject;

public class PlayerHit {
    private RunHitObject[] arrays;

    public PlayerHit() {
        this.arrays = new RunHitObject[]{
                new RunHitObject(SquareBullet.class),
                new RunHitObject(Square.class),
        };
    }

    public void run(Player player) {
        for (RunHitObject runHitObject : arrays) {
            runHitObject.run(player);
        }
    }

}
