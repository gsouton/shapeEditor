package xshape;

import java.awt.geom.Ellipse2D;

import customAWT.AWTCanvas;
import java.awt.geom.Point2D;

import java.awt.Shape;

/**
 * BorderShapeAWT
 */
public class BorderShapeAWT extends ShapeDecorator {
    private Ellipse2D _circle = new Ellipse2D.Double();
    private AWTCanvas _canvas;
    private xshape.Shape _shape;

    public BorderShapeAWT(xshape.Shape shape, AWTCanvas canvas) {
        super(shape);
        _shape = shape;
        _canvas = canvas;
    }

    public BorderShapeAWT(xshape.Shape shape, Ellipse2D circle, AWTCanvas canvas){
        super(shape);
        _circle = new Ellipse2D.Double(circle.getCenterX(), circle.getCenterY(), circle.getWidth(), circle.getHeight());
        _canvas = canvas;
    }

    @Override
    public void draw() {
        Point2D p = super.position();
        Point2D s = super.size();
        double max = Math.max(s.getX() * Math.sqrt(2), s.getY() * Math.sqrt(2));
        Ellipse2D circle = new Ellipse2D.Double();
        circle.setFrame(p.getX() - s.getX() / 2, p.getY() - s.getY() / 2, s.getX() + s.getX(),
                s.getY() + s.getY());
        _circle = circle;
        _canvas.addShape(_circle);
        super.draw();
    }

    public Point2D size() {
        Point2D s = super.size();
        double s2 = Math.max(s.getX() * Math.sqrt(2), s.getY() * Math.sqrt(2));
        return new Point2D.Double(s2, s2);
    }

    public BorderShapeAWT clone(){
        xshape.Shape shape = _shape.clone();
        return new BorderShapeAWT(shape, _circle, _canvas);
    }

}
