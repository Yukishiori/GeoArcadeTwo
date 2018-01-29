package action;

import core.GameObject;

public interface Action {
    boolean run(GameObject owner);

    void reset();
}
