package action;

import core.GameObject;

public class CountAction implements Action {
    public static int count = 0;
    @Override
    public boolean run(GameObject owner) {
        this.count++;
        System.out.println(this.count);
        return false;
    }

    @Override
    public void reset() {
        this.count = 0;
    }
}
