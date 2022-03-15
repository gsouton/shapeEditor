package xshape;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

import customAWT.*;

/**
 * RectangleAWT
 */
public class RectangleAWT implements Shape {

    private Rectangle _shape;
    private AWTCanvas _awtCanvas;
    private double _rotation = 0;

    public RectangleAWT(double posX, double posY, double width, double height, AWTCanvas awtCanvas) {
        _awtCanvas = awtCanvas;
        _shape = new Rectangle((int) (posX - width / 2), (int) (posY - height / 2), (int) width, (int) height);
    }

    public RectangleAWT(RectangleAWT rectangleAWT) {
        _awtCanvas = rectangleAWT._awtCanvas;
        _shape = new Rectangle(rectangleAWT._shape);
    }

    @Override
    public void draw() {
        _awtCanvas.addShape(_shape);
    }

    @Override
    public Shape translate(Point2D vec) {
        _shape.translate((int) vec.getX(), (int) vec.getX());
        return this;
    }

    @Override
    public Shape size(Point2D vec) {
        _shape.setSize(new Dimension((int) (vec.getX()), (int) (vec.getY())));
        return this;
    }

    @Override
    public Point2D size() {
        Dimension d = _shape.getSize();
        return new Point2D.Double(d.getWidth(), d.getHeight());
    }

    @Override
    public Shape scale(Point2D vec) {
        int width = (int) (size().getX() * vec.getX());
        int height = (int) (size().getY() * vec.getY());
        Dimension size = new Dimension(width, height);
        _shape.setSize(size);
        return this;
    }

    @Override
    public Shape scale(double scalar) {
        scale(new Point2D.Double(scalar, scalar));
        return this;
    }

    @Override
    public Shape rotate(double rad) {
        return this;
    }

    @Override
    public double rotation() {
        return _rotation;
    }

    @Override
    public RectangleAWT clone() {
        return new RectangleAWT(this);
    }

    @Override
    public Point2D position() {
        return new Point2D.Double(_shape.getX(), _shape.getY());
    }

    @Override
    public Shape position(Point2D position) {
        _shape.setLocation((int) position.getX(), (int) position.getY());
        return null;
    }

}
