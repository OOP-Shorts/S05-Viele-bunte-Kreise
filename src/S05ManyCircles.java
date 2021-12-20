import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

import java.util.Random;

public class S05ManyCircles extends GraphicsApp {

    private Circle[] circles;

    @Override
    public void initialize() {
        setCanvasSize(500, 500);
        circles = new Circle[10];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = createRandomCircle();
        }
    }

    private Circle createRandomCircle() {
        Random random = new Random();
        int radius = random.nextInt(10, 30);
        int x = random.nextInt(radius, getWidth() - radius);
        int y = random.nextInt(radius, getHeight() - radius);
        Color color = Colors.getRandomColor();
        return new Circle(x, y, radius, color);
    }

    @Override
    public void draw() {
        drawBackground(Colors.BLACK);
        for(Circle circle: circles) {
            circle.move(0, 1);
            circle.draw();
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch("S05ManyCircles");
    }
}
