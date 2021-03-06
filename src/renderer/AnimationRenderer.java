package renderer;

import core.FrameCounter;
import core.Vector2D;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnimationRenderer implements Renderer{

    private boolean isRepeat;
    private int index;
    private List<BufferedImage> list;
    public boolean looped;
    public int count = 0;
    private int timeInterval = 0;
    private FrameCounter frameCounter = new FrameCounter(5);
    private boolean disabled = false;

    public AnimationRenderer(boolean isRepeat, int timeInterval, String... urls) {
        this.isRepeat = isRepeat;
        this.list = new ArrayList<>();
        Arrays.asList(urls).stream().forEach(url -> list.add(Utils.loadImage(url)));
        this.index = 0;
        looped = false;
        this.timeInterval = timeInterval;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        BufferedImage image = this.list.get(this.index);
        graphics.drawImage(image,(int) position.x - image.getWidth() / 2, (int) position.y - image.getHeight() / 2, null);
//        if (isRepeat) {
//            if (this.index == this.list.size() - 1) {
//                this.index = 0;
//            } else {
//                this.index++;
//            }
//        } else {
//            if (this.index == this.list.size() - 1) {
//                index = 0;
//                looped = true;
//            } if (this.index != this.list.size() && !looped)  {
//                this.index++;
//            }
//        }
        FrameCounter frameCounter = new FrameCounter(timeInterval);
        if (this.index == list.size() - 1 && !isRepeat) {
            this.disabled = true;
        } else {
            if (frameCounter.run()) {
                changeFrame();
                frameCounter.reset();
            }
        }
    }

    private void changeFrame() {
        if (this.index >= list.size() - 1) {
            this.index = 0;
        } else {
            this.index++;
        }
    }
}
