package game.square.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.player.bullet.BulletPlayer;
import game.square.Square;
import game.square.bullet.SquareBullet;

public class HitSquareBullet {
//    GameObject gameObject;
    public void run (BulletPlayer bulletPlayer){
        SquareBullet squareBullet = GameObjectManager.instance.checkCollider(bulletPlayer.boxCollider, SquareBullet.class);
        if (squareBullet != null){
            squareBullet.getHit();
            bulletPlayer.getHit();
        }
    }
}
