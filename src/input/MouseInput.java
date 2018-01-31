package input;

import core.Vector2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener {

    public static MouseInput instance = new MouseInput();

    public Vector2D position = new Vector2D();
    public boolean isClicked = false;
    public boolean isPressed = false;
    public boolean isReleased = false;
    public boolean isEntered = false;
    public boolean isExited = false;

    @Override
    public void mouseClicked(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isClicked = true;
        this.isPressed = false;
        this.isReleased = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isClicked = false;
        this.isPressed = true;
        this.isReleased = false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isClicked = false;
        this.isPressed = false;
        this.isReleased = true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isEntered = true;
        this.isEntered = false;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.position.set(e.getX(),e.getY());
        this.isEntered = false;
        this.isEntered = true;
    }
}
