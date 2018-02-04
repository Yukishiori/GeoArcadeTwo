package game.square;

import action.*;
import constants.Constant;
import core.FrameCounter;
import core.GameObject;
import core.GameObjectManager;
import core.Vector2D;
import game.circlesquare.CircleSquare;
import game.squarematrix.SquareMatrix;
import game.homingsquare.HomingSquare;

import java.util.Random;
import java.util.Vector;

public class SquareSpawner extends GameObject {

    private Random random = new Random();
    public static boolean speacialSquareDie = false;


    private SequenceAction sequenceAction;
    private SequenceAction sequenceAction1;
    private RepeatForeverAction foreverAction;
    private RepeatForeverAction foreverAction1;
    private Vector<Action> actions;
    private int count = 0;

    public SquareSpawner() {

//        CircleSquare circleSquare = GameObjectManager.instance.recycle(CircleSquare.class);
//        circleSquare.config();
        this.foreverAction = new RepeatForeverAction(
                new SequenceAction(
                        new WaitAction(Constant.SquareSpawner.WAIT_FRAME_COUNTER),
                        createSquareAction
                )
        );
         foreverAction1 = new RepeatForeverAction(
                new SequenceAction(
                        new WaitAction(240),
                        new ActionAdapter() {
                            @Override
                            public boolean run(GameObject owner) {
                                MediumSquare mediumSquare = GameObjectManager.instance.recycle(MediumSquare.class);
                                mediumSquare.position.set(random.nextInt(380), 0);
                                mediumSquare.velocity.set(random.nextInt(2),random.nextInt(2));
                                mediumSquare.hasGun = true;
                                return true;
                            }

                            @Override
                            public void reset() {
                                super.reset();
                            }
                        }
                )
        );
         sequenceAction = new SequenceAction(
                 createCircleSquareAct,
                 new WaitAction(500),
                 createSquareMatrixAct,
                 new WaitAction(500),
                 createCircleSquareAct,
                 createSquareMatrixAct,
                 new WaitAction(10)
         );
         sequenceAction1 = new SequenceAction(
                 createSpecialSquareAct,
                 checkCondition,
                 createSpecialSquareAct,
                 checkCondition,
                 createSpecialSquareAct,
                 new WaitAction(1)
         );

    }


    @Override
    public void run() {
        super.run();
//        if (frameCounter.run()) {
//            count++;
//            System.out.println(count);
//        }
//        frameCounter.reset();

        count ++;
        this.foreverAction.run(this);
        if (count >= 600) {
            this.foreverAction1.run(this);
        }
        if (count >= 900) {
            this.sequenceAction.run(this);
            foreverAction.run(this);
        }
        if (count >= 1500){
            sequenceAction1.run(this);
        }


    }

    public void configAction() {
        //default spawning
        this.add(new RepeatForeverAction(
                new SequenceAction(
                        new WaitAction(60),
                        createSquareAction
                )
        ));

    }

//    private Action checkCountAct = new ActionAdapter() {
//        @Override
//        public boolean run(GameObject owner) {
//            int count;
//            if (sequenceAction.run(this))count++
//            return super.run(owner);
//        }
//    }


    private Action createSquareAction = new ActionAdapter() {
        @Override
        public boolean run(GameObject owner) {
            Square square = GameObjectManager.instance.recycle(Square.class);
            square.position.set(random.nextInt(Constant.Windows.WIDTH - 20), 0.0f);
            square.velocity.set(new Vector2D(0.0f, random.nextInt(1) + 3));
            return true;
        }

        @Override
        public void reset() {

        }
    };

    private Action createCircleSquareAct = new ActionAdapter() {
        @Override
        public boolean run(GameObject owner) {
            CircleSquare circleSquare = GameObjectManager.instance.recycle(CircleSquare.class);
            circleSquare.config();
            return true;
        }

        @Override
        public void reset() {
            super.reset();
        }
    };
    private Action createSquareMatrixAct = new ActionAdapter() {
        @Override
        public boolean run(GameObject owner) {
            SquareMatrix squareMatrix = GameObjectManager.instance.recycle(SquareMatrix.class);
            squareMatrix.config();
            return true;
        }

        @Override
        public void reset() {
            super.reset();
        }
    };
    private Action createSpecialSquareAct = new ActionAdapter() {
        @Override
        public boolean run(GameObject owner) {
            SpecialSquare specialSquare = GameObjectManager.instance.recycle(SpecialSquare.class);
            specialSquare.position.set(0,0);
            specialSquare.velocity.set(2f,0f);
            return true;
        }
        @Override
        public void reset() {
            super.reset();
        }
    };
    private Action checkCondition = new ActionAdapter() {
        @Override
        public boolean run(GameObject owner) {
            if (speacialSquareDie) {
                speacialSquareDie = false;
                return true;
            } else {
                return false;
            }
        }

        @Override
        public void reset() {
            super.reset();
        }
    };
}
