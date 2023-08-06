package projava;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.function.Consumer;

public class DiffSampleInherit {
    static BufferedImage createImage(Consumer<Graphics2D> drawer) {
        var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
        var g = image.createGraphics();
        drawer.accept(g);
        return image;
    }

    interface ImageDrawer {
        default BufferedImage createImage() {
            var image = new BufferedImage(600, 400, BufferedImage.TYPE_INT_RGB);
            var g = image.createGraphics();
            draw(g);
            return image;
        }

        void draw(Graphics2D g);
    }

    static class LineDrawer implements ImageDrawer {
        @Override
        public void draw(Graphics2D g) {
            g.drawLine(10, 10, 220, 180);
        }
    }


    static BufferedImage lineImage() {
        return createImage(g -> g.drawLine(10, 10, 220, 180));
    }

    static BufferedImage rectImage() {
        return createImage(g -> g.drawRect(10, 10, 220, 180));
    }


    public static void main(String[] args) {
        var lineDrawer = new LineDrawer();
        lineDrawer.createImage();


    }
}
