package replayscreenstuff;

import core.GameObject;
import game.overviewscenestuff.PlayButton;
import renderer.ImageRenderer;

public class ReplayButton extends PlayButton {

    public ReplayButton() {
        imageRenderer = new ImageRenderer("asset-geoarcade-master/resources/ui/replay.png");
        imageRenderer2 = new ImageRenderer("asset-geoarcade-master/resources/ui/replay_hover.png");
        this.position.set(200,300);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public void run() {
        super.run();
    }
}
