package xshape;
import javafx.scene.shape.Circle;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import java.awt.geom.Point2D;

public class BorderShapeFx extends Border {
    Circle _adapted = null;
    Group _grp = null;
    public BorderShapeFx(Shape _shape, Group grp) {
        super(_shape);
        _adapted = new Circle();
        _grp = grp;
        grp.getChildren().add(_adapted);
    }

    @Override
    public BorderShapeFx clone() {
        BorderShapeFx _clone = (BorderShapeFx)super.clone();
        _clone._adapted = new Circle();
        _grp.getChildren().add(_clone._adapted);
        return _clone;
    }

    @Override
    public void draw() {
        Point2D p = super.position();
        Point2D s = super.size();
        _adapted.setCenterX(p.getX());
        _adapted.setCenterY(p.getY());
        _adapted.setRadius(Math.max(0.5 * s.getX() * Math.sqrt(2), 
        0.5 * s.getY() * Math.sqrt(2)));
        _adapted.setFill(Color.TRANSPARENT);
        _adapted.setStrokeWidth(1);
        _adapted.setStroke(Color.BLACK);
        super.draw();
    }
}
