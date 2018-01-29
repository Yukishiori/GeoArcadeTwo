package action;

import core.GameObject;

public class RepeatForeverAction implements Action {

    private Action action;

    public RepeatForeverAction(Action action) {
        this.action = action;
    }

    @Override
    public boolean run(GameObject owner) {
//        System.out.println("Ưhat" +
//                "");
        if(this.action.run(owner)) action.reset();
        return false;
    }

    @Override
    public void reset() {
//        this.action.reset();
    }
}
