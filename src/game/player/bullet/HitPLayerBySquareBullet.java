package game.player.bullet;

import core.GameObject;
import core.GameObjectManager;
import game.player.Player;
import game.square.Square;
import game.square.bullet.SquareBullet;

public class HitPLayerBySquareBullet {
    public void run(SquareBullet squareBullet){
        Player player = GameObjectManager.instance.checkCollider(squareBullet.boxCollider, Player.class );
        if (player != null){
            player.getHit();
            System.out.println("Bulleted");
        }
    }
}
