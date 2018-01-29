package game.Background;

import core.GameObject;
import renderer.ImageRenderer;
import java.awt.*;

public class Background extends GameObject {
    public Background(){
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/background/background.png");
        this.position.set(200,300);
    }
}
