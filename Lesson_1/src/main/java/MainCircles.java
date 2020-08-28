import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private long testTime = 0l;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainCircles();
            }
        });
    }

    Sprite[] sprites = new Sprite[10];
    Sprite[] spritesOnMouse = new Sprite[10];

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);

        JPanel pan = new JPanel ();
        add(pan);
        pan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                initApplicationOnMouseClick();
            }
        });

        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        initApplication();
        setTitle("Circles");
        setVisible(true);
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    private void initApplicationOnMouseClick() {
        for (int i = 0; i < spritesOnMouse.length; i++) {
            spritesOnMouse[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        updateBackground(canvas, g, deltaTime);
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void updateBackground(GameCanvas canvas, Graphics g, float deltaTime) {
       if (deltaTime != testTime) {
           Background.updateBackground(canvas, g, deltaTime);
       }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}