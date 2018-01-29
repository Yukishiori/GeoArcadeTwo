package action;

import core.FrameCounter;
import core.GameObject;

public class WaitAction implements Action{
    FrameCounter frameCounter;

    public WaitAction(int max) {
        this.frameCounter = new FrameCounter(max);
    }

    @Override
    public boolean run(GameObject owner) {
//        System.out.println("What!");
        return this.frameCounter.run();
    }

    @Override
    public void reset() {
        this.frameCounter.reset();

    }
}
