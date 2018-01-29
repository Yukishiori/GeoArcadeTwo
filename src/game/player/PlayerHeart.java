package game.player;

import core.GameObject;
import renderer.ImageRenderer;

import java.awt.*;

public class PlayerHeart extends GameObject {
    public PlayerHeart(){
        this.renderer = new ImageRenderer("asset-geoarcade-master/resources/ui/heart.png");
    }

}
