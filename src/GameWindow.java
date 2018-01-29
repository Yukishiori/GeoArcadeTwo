import input.MouseMotionInput;

import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {

    GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setSize(400, 600);
        this.setupGameCanvas();
        this.setVisible(true);
        this.event();

    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event() {
        this.addMouseMotionListener(MouseMotionInput.instance);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    gameCanvas.gameCanvasdeflectOn = true;
                }
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - lastTime >= 17_000_000) {
                gameCanvas.runAll();
                this.gameCanvas.renderAll();
                lastTime = currentTime;
            }
        }
    }
}
