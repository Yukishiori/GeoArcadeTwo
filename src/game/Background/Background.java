package game.Background;

import constants.Constant;
import core.GameObject;
import renderer.ImageRenderer;
import java.awt.*;

public class Background extends GameObject {
    public Background(){
        this.renderer = new ImageRenderer(Constant.Background.PATH);
        this.position.set(Constant.Windows.WIDTH / 2, Constant.Windows.HEIGHT / 2);
    }
}
