package game.player.bullet;
import core.GameObject;
import core.GameObjectManager;
import game.player.Player;
import game.square.MediumSquare;
import game.square.Square;


public class HitPlayerBySquare {
    public void run(Square square) {
        Player player = GameObjectManager.instance.checkCollider(square.boxCollider, Player.class);
        if (player != null) {
            player.getHit();
            square.getHit();
            System.out.println("Squared");
        }
    }
}