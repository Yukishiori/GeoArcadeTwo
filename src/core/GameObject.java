package core;


import action.Action;
import game.player.Player;

import physic.BoxCollider;
import physic.PhysicBody;
import renderer.Renderer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    public boolean isAlive = true;
    protected Renderer renderer;
    private Vector<Action> actions;
    private Vector<Action> newActions = new Vector<>();

    public GameObject() {
        this.position = new Vector2D();
        this.actions = new Vector<>();
    }

    public void render(Graphics graphics){
        if (this.renderer != null) {
            this.renderer.render(graphics, this.position);
        }
    }
    public void run() {
        this.actions.removeIf(action -> action.run(this));
        this.actions.addAll(this.newActions);
        this.newActions.clear();
    }

    public void reset() {
        this.actions.removeAllElements();
    }

    public void add(Action action) {
        this.newActions.add(action);
    }
    public void clear() {
        this.actions.clear();
        this.newActions.clear();
    }
}
