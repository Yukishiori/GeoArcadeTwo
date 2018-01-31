package game.player;

import core.GameObject;
import core.GameObjectManager;
import explosionpackage.ExplosionMaker;
import game.Scene.ReplayScreen;
import game.Scene.SceneManager;
import game.player.explosion.ExplosionParticlePlayer;
import game.player.explosion.ExplosionPlayer;
import game.player.playershield.PlayerShield;
import game.player.playershield.PlayerUseShield;
import input.MouseMotionInput;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.AnimationRenderer;
import renderer.ImageRenderer;
import utils.Utils;

public class Player extends GameObject implements PhysicBody{

    private PlayerShoot playerShoot;
    private PlayerHealth playerHealth;
    public BoxCollider boxCollider;
    public boolean deflectOn = true;
    private ImageRenderer imageRenderer;
    private AnimationRenderer animationRenderer;

    public Player() {
        this.imageRenderer = new ImageRenderer("asset-geoarcade-master/resources/player/straight.png");
        animationRenderer = new AnimationRenderer(false,
                "asset-geoarcade-master/resources/player/straight.png",
                "asset-geoarcade-master/resources/player/straight.png",
                "asset-geoarcade-master/resources/player/straight.png",
                "asset-geoarcade-master/resources/player/straight_white.png",
                "asset-geoarcade-master/resources/player/straight_white.png",
                "asset-geoarcade-master/resources/player/straight_white.png",
                "asset-geoarcade-master/resources/player/straight.png",
                "asset-geoarcade-master/resources/player/straight.png",
                "asset-geoarcade-master/resources/player/straight.png",
                "asset-geoarcade-master/resources/player/straight_white.png",
                "asset-geoarcade-master/resources/player/straight_white.png",
                "asset-geoarcade-master/resources/player/straight_white.png");

        this.renderer = this.imageRenderer;
//        this.renderer = animationRenderer;
        this.playerShoot = new PlayerShoot();

        this.isAlive = true;
        this.playerHealth = new PlayerHealth(5);
        this.boxCollider = new BoxCollider(40,40);

//        playerShield.isAlive = false;
//
    }

    @Override
    public void run() {
        super.run();
        this.playerShoot.run(this);
        boxCollider.position.set(this.position);
        this.position.set(MouseMotionInput.instance.position);
        playerHealth.showHealth();
        playerKeeper();

    }
    public void getHit(){

        this.isAlive = this.playerHealth.run();

        if (this.isAlive){
            animationRenderer.looped = false;
            this.renderer = this.animationRenderer;
//            this.renderer = this.imageRenderer;

        }
//        this.isAlive = false;
        ExplosionPlayer explosionPlayer = GameObjectManager.instance.recycle(ExplosionPlayer.class);
        explosionPlayer.position.set(this.position);
        explosionPlayer.config();
//        ExplosionMaker explosionMaker  = GameObjectManager.instance.recycle(ExplosionMaker.class);
//        explosionMaker.position.set(this.position);
//
//        explosionMaker.config(15,50);
        System.out.println("mat troi kia du o dau");
        SceneManager.instance.changeScene(new ReplayScreen());
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    private void playerKeeper(){
        if (this.position.x > 360) this.position.x = 360;
        if (this.position.x <0) this.position.x = 0;
        if (this.position.y >560) this.position.y = 560;
        if (this.position.y <-50) this.position.y = -50;
    }
}
