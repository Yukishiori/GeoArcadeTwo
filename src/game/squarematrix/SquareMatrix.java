package game.squarematrix;
import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.square.Square;
import java.util.Random;
import java.util.Vector;

public class SquareMatrix extends GameObject {
    private Vector<Square> vector;
    private Vector<Square> newVector;
    private Vector2D velocity;
    public SquareMatrix() {
        vector = new Vector<>();
        newVector = new Vector<>();
        this.velocity = new Vector2D();
        this.velocity.set(1,0);
    }
    @Override
    public void run() {
        super.run();

        for (Square square: this.vector){
            square.position.addUp(velocity);
            if (square.isAlive) {
                if (square.position.x >= 400 || square.position.x <= 0) {
                    this.velocity.x = -this.velocity.x;
                    this.downOne();
                }
            } else {
                newVector.add(square);
            }
        }
        for (Square square: newVector){
            vector.removeElement(square);
        }
        newVector.clear();
    }

    private void downOne() {
        for (Square square: this.vector) {
            square.position.y += 10;
        }
    }

    public void config() {
        for (int i = 0; i < 220; i += 70) {
            for (int j = 20; j < 380 ; j += 380 / 7) {
                Square square= GameObjectManager.instance.recycle(Square.class);
                square.position.set(j,i);
                vector.add(square);
            }
        }
    }
}
