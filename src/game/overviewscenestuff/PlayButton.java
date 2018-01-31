package game.overviewscenestuff;

import core.GameObject;
import game.Scene.GamePlayScene;
import game.Scene.SceneManager;
import input.MouseInput;
import input.MouseMotionInput;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class PlayButton extends GameObject implements PhysicBody {
    protected ImageRenderer imageRenderer;
    protected ImageRenderer imageRenderer2;
    public BoxCollider boxCollider;
    public PlayButton() {
        this.imageRenderer = new ImageRenderer("asset-geoarcade-master/resources/ui/start_game.png");
        this.imageRenderer2 = new ImageRenderer("asset-geoarcade-master/resources/ui/start_game_hover.png");
        this.renderer = imageRenderer;
        this.boxCollider = new BoxCollider(100,100);
        this.position.set(200,420);
        this.boxCollider.position.set(this.position);
//        System.out.println();
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;

    }

    @Override
    public void run() {
        super.run();
        if (MouseMotionInput.instance.position.x >= this.boxCollider.position.x - this.boxCollider.width/2 &&
                MouseMotionInput.instance.position.x <= this.boxCollider.position.x + this.boxCollider.width/2 &&
                MouseMotionInput.instance.position.y <= this.boxCollider.position.y + this.boxCollider.height/2 &&
                MouseMotionInput.instance.position.y >= this.boxCollider.position.y - this.boxCollider.height/2)
        {
            this.renderer = this.imageRenderer2;
            if (MouseInput.instance.isPressed){
                SceneManager.instance.changeScene(new GamePlayScene());
            }
        } else {
            this.renderer = imageRenderer;
        }

    }

}
