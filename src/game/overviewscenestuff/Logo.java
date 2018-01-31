package game.overviewscenestuff;

import core.GameObject;
import renderer.ImageRenderer;

public class Logo extends GameObject {
    public Logo() {
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/ui/logo.png");
        this.position.set(200,200);
    }
}
