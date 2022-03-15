import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import customAWT.AWTCanvas;
import factory.FactoryAWT;
import xshape.Shape;

public class AppAWT {

    public static void run() {
        JFrame frame = new JFrame("Hello world awt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AWTCanvas canvas = new AWTCanvas();

        FactoryAWT factoryAWT = new FactoryAWT(canvas);

        Shape shape = factoryAWT.createRectangle(100, 100, 50, 50);

        Shape shape2 = shape.clone();

        shape = factoryAWT.createBorder(shape);
        // shape = factoryAWT.createBorder(shape);
        shape.translate(new Point2D.Double(200, 300));
        shape.scale(2);

        shape.draw();
        shape2.draw();

        frame.getContentPane().add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> run());
    }

}
