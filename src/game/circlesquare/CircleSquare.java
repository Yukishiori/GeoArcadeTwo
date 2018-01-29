package game.circlesquare;
import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.square.Square;
import java.util.Vector;

public class CircleSquare extends GameObject {

    private InvinsibleObject invinsibleObject;
    public CircleSquare() {

        this.invinsibleObject = GameObjectManager.instance.recycle(InvinsibleObject.class);
        this.invinsibleObject.velocity.set(3,3);
        this.invinsibleObject.position.set(51,51);
    }

    @Override
    public void run() {
//        System.out.println(invinsibleObject.velocity.x + "" + invinsibleObject.velocity.y);
}

    public void config() {
        for (int i = 0; i < 360; i += 360 / 10) {
            Square square = GameObjectManager.instance.recycle(Square.class);
            square.position = ((new Vector2D(0,50).rotate(i)).add(invinsibleObject.position));
            square.velocity = invinsibleObject.velocity;
        }

    }
}