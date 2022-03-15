package customAWT;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

// https://stackoverflow.com/questions/37333936/drawing-multiple-rectangles-on-a-panel-in-swing
public class AWTCanvas extends JPanel {

    private List<Shape> _shapes = new ArrayList<>();
    private static final int PREF_WIDTH = 800;
    private static final int PREF_HEIGHT = 650;
    private static final Color SHAPE_COLOR = Color.RED;

    public boolean addShape(Shape shape) {
        return _shapes.add(shape);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponents(graphics);
        Graphics2D graphics2d = (Graphics2D) graphics;
        graphics2d.setColor(SHAPE_COLOR);

        for (Shape shape : _shapes) {
            graphics2d.draw(shape);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet())
            return super.getPreferredSize();
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }

}
