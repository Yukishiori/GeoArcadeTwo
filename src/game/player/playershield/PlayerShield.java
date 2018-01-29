package game.player.playershield;

import core.GameObject;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;
import utils.Utils;

public class PlayerShield extends GameObject implements PhysicBody{
    public BoxCollider boxCollider = new BoxCollider(40, 20);
    private PlayerUseShield playerUseShield = new PlayerUseShield();
    public PlayerShield(){
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/player/Shield.png");
    }

    @Override
    public void run() {
        super.run();
        playerUseShield.run(this);
    }

    public BoxCollider getBoxCollider() {
        return boxCollider;
    }
}
