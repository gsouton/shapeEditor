package xshape;

import javafx.scene.shape.Circle;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import java.awt.geom.Point2D;

public class BorderShapeFx extends ShapeDecorator {
    Circle _circle = new Circle();
    private Group _grp;
    Shape shape;

    public BorderShapeFx(Shape shape, Group grp) {
        super(shape);
        this.shape = shape;
        _grp = grp;
        grp.getChildren().add(_circle);
    }

    public BorderShapeFx(Shape shape, Circle circle, Group grp){
        super(shape);
        _circle = new Circle();
        _circle.setCenterX(circle.getCenterX());
        _circle.setCenterY(circle.getCenterY());
        _circle.setRadius(circle.getRadius());
        _grp = grp;
        _grp.getChildren().add(_circle);
    }



    @Override
    public void draw() {
        Point2D p = super.position();
        Point2D s = super.size();
        _circle.setCenterX(p.getX());
        _circle.setCenterY(p.getY());
        _circle.setRadius(Math.max(s.getX() * Math.sqrt(2), s.getY() * Math.sqrt(2)));
        _circle.setFill(Color.TRANSPARENT);
        _circle.setStrokeWidth(2);
        _circle.setStroke(Color.BLACK);
        super.draw();
    }

    public Point2D size() {
        Point2D s = super.size();
        double s2 = Math.max(s.getX() * Math.sqrt(2), s.getY() * Math.sqrt(2));
        return new Point2D.Double(s2, s2);
    }

    @Override
    public BorderShapeFx clone() {
        Shape shape = this.shape.clone();
        return new BorderShapeFx(shape, _circle, _grp);
    }

}
