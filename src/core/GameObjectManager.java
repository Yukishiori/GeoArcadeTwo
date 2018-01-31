package core;

import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.util.Vector;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private Vector<GameObject> vector;
    private Vector<GameObject> newVector;

    private GameObjectManager(){
        this.vector = new Vector<>();
        this.newVector = new Vector<>();
    }

    public void add(GameObject gameObject) {
        newVector.add(gameObject);
    }

    public void runAll() {
        for (GameObject gameObject : vector) {
            if (gameObject.isAlive) {
                gameObject.run();
            }
        }
        vector.addAll(newVector);
        newVector.clear();
    }

    public  void renderAll(Graphics graphics) {
        for (GameObject gameObject : vector) {
            if (gameObject.isAlive) {
                gameObject.render(graphics);
            }
        }
    }
    public  <T extends GameObject> T checkCollider(BoxCollider boxCollider, Class<T> cls) {
        for (GameObject gameObject : vector) {
            if (!(gameObject.isAlive)) continue;
            if (!(cls.isInstance(gameObject))) continue;
            // interface thing
            if (!(gameObject instanceof PhysicBody)) continue;
            BoxCollider other = ((PhysicBody) gameObject).getBoxCollider();
            //collide with
            if (boxCollider.checkBoxCollider(other)) {
                return (T) gameObject;
            }

        }
        return null;
    }

    public  <T extends GameObject> T recycle(Class<T> cls){
        for (GameObject gameObject: vector){
            if(gameObject.isAlive) continue;
            if (!(cls.isInstance(gameObject))) continue;
            gameObject.isAlive = true;
            gameObject.clear();
            return (T) gameObject;
        }
        try {
            T instance = cls.newInstance();
            this.add(instance);
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Player getPlayer() {
        for (GameObject gameObject : vector) {
            if (!(gameObject instanceof Player)) continue;
            return (Player) gameObject;
        }
        return null;
    }
    public void clear() {
        this.vector.clear();
        this.newVector.clear();
    }
}
