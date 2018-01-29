package game.player.playershield;

import core.GameObject;
import core.GameObjectManager;
import game.player.playershield.PlayerShield;
import game.square.bullet.SquareBullet;

public class PlayerUseShield {
    public void run(PlayerShield playerShield){
        SquareBullet squareBullet = GameObjectManager.instance.checkCollider(playerShield.boxCollider,SquareBullet.class);
        if (squareBullet != null){
            squareBullet.velocity.multiply(-1);
        }
    }
}
