import java.awt.*;

public class Background extends Sprite {

    public static Color ColorBackground;

    public static void updateBackground(GameCanvas canvas, Graphics g, float deltaTime) {
        ColorBackground = new Color(
                             (int) (Math.random() * 255), //r
                             (int) (Math.random() * 255), //g
                             (int) (Math.random() * 255)  //b
                     );
        canvas.setBackground(ColorBackground);
    }
}
