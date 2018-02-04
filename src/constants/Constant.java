package constants;

import utils.Utils;

public class Constant {
    public static class Windows {
        public static final int WIDTH = 400;
        public static final int HEIGHT = 600;
        public static final int DELAY_NANO_SECOND = 17_000_000;
    }

    public static class Background {
        public static final String PATH = "asset-geoarcade-master/resources/background/background.png";
    }

    public static class Square {
        public static final String PATH = "asset-geoarcade-master/resources/square/enemy_square_small.png";
        public static final Float BOX_WIDTH = 20f;
        public static final Float BOX_HEIGHT = 20f;
        public static final String HIT_SOUND = "asset-geoarcade-master/resources/sound/sfx/enemy_explosion.wav";
    }

    public static class SquareSpawner {
        public static int WAIT_FRAME_COUNTER;
        private static final constants.Square RESOURCES;

        static {
            RESOURCES = Utils.parseJsonToObject("asset-geoarcade-master/resources/json/square.json", constants.Square.class);
            WAIT_FRAME_COUNTER = (int) (RESOURCES.waitTime * 60);
        }

    }

    public static class Player {
        public static final String PATH = "asset-geoarcade-master/resources/player/straight.png";
        public static final String[] PATHS = new String[]{
                "asset-geoarcade-master/resources/player/straight.png",
                "asset-geoarcade-master/resources/player/straight_white.png",
                "asset-geoarcade-master/resources/player/straight_white.png",
                "asset-geoarcade-master/resources/player/straight.png"
        };
    }


}
