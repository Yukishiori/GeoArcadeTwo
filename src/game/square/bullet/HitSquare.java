package game.square.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.player.bullet.BulletPlayer;
import game.square.Square;

public class HitSquare {


    public void run(BulletPlayer bulletPlayer) {
        Square square = GameObjectManager.instance.checkCollider(bulletPlayer.boxCollider, Square.class);
        if (square != null) {
            bulletPlayer.getHit();
            square.getHit();
        }
    }


}
