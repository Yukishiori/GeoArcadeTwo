package action;

import core.GameObject;

import java.util.Arrays;
import java.util.List;

public class SequenceAction implements Action {
    private List<Action> actions;
    private int currentIndex;


    public SequenceAction( Action... actions) {
        this.actions = Arrays.asList(actions);
        this.currentIndex = 0;

    }

    @Override
    public boolean run(GameObject owner) {
        Action currentAction = this.actions.get(currentIndex);
            if (currentAction.run(owner)) {
                if (this.currentIndex == this.actions.size() - 1) {
                    return true;
                } else {
                    currentIndex++;
                    return false;
                }
            } else {
                return false;
            }
    }

    @Override
    public void reset() {
        this.currentIndex = 0;
        for (Action action : this.actions) {
            action.reset();
        }
    }
}
