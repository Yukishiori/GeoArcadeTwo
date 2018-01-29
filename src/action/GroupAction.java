package action;

import core.GameObject;

import java.util.Arrays;
import java.util.List;

public class GroupAction implements Action {

    private List<Action> list;

    public GroupAction(Action... actions) {
        this.list = Arrays.asList(actions);
    }

    @Override
    public boolean run(GameObject owner) {
        this.list.removeIf(action -> action.run(owner));
        return this.list.size() == 0;
    }



    @Override
    public void reset() {

    }
}
