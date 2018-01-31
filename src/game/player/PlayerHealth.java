package game.player;

        import core.GameObjectManager;

        import java.util.Vector;

public class PlayerHealth{
    public int health;
    private Vector<PlayerHeart> vector = new Vector<>();

    public PlayerHealth(int health) {
        this.health = health;
        for (int i = 0; i < health; i++) {
            PlayerHeart playerHeart = GameObjectManager.instance.recycle(PlayerHeart.class);
            playerHeart.position.set(40 * i + 20, 20);
            this.vector.add(playerHeart);
        }
    }

    public boolean run(){
        if(this.health == 0) {
            return  false;
        } else {
            this.health -= 1;
            vector.elementAt(health).isAlive = false;
            return true;
        }
    }
    public void showHealth(){

    }
}
