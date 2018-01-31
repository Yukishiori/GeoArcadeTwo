package hit;

import core.GameObject;
import core.GameObjectManager;
import physic.PhysicBody;

public class RunHitObject<O extends GameObject & HitObject> {

    private Class<O> cls;

    public<T extends GameObject & PhysicBody & HitObject> void run(T gameObject) {
        O object = GameObjectManager.instance.checkCollider(gameObject.getBoxCollider(),this.cls);
        if (object != null) {
            gameObject.getHit(object);
            object.getHit(gameObject);
        }
    }

    public RunHitObject(Class<O> cls) {
        this.cls = cls;
    }

}
