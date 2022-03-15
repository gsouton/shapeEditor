package xshape;

import java.awt.geom.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleFx implements Shape {

    private Rectangle _shape;
    private Point2D _pos;
    private Point2D _size;
    private Group _grp;

    public RectangleFx(double posX, double posY, double height, double width, Group grp) {
        _pos = new Point2D.Double(posX, posY);
        _size = new Point2D.Double(width / 2, height / 2);
        _grp = grp;
        _shape = new Rectangle();
        grp.getChildren().add(_shape);
    }

    // public RectangleFx(RectangleFx rectangle) {
    // _pos = rectangle.position();
    // _size = rectangle.size();
    // _shape = new Rectangle();
    // _shape.setX(rectangle._pos.getX());
    // _shape.setY(rectangle._pos.getY());
    // _shape.setWidth(rectangle._size.getX());
    // _shape.setHeight(rectangle._size.getY());
    // _grp = rectangle._grp;
    // rectangle._grp.getChildren().add(_shape);
    // }

    @Override
    public void draw() {
        _shape.setX(_pos.getX() - _size.getX());
        _shape.setY(_pos.getY() - _size.getY());
        _shape.setWidth(_size.getX() * 2);
        _shape.setHeight(_size.getY() * 2);
        _shape.setFill(Color.BLUE);
    }

    @Override
    public Shape rotate(double rad) {
        _shape.setRotate(rad);
        return this;
    }

    @Override
    public double rotation() {
        return _shape.getRotate();
    }

    @Override
    public Point2D size() {
        return (Point2D) _size.clone();
    }

    @Override
    public Shape size(Point2D vec) {
        _size = (Point2D) vec.clone();
        return this;
    }

    @Override
    public Point2D position() {
        return (Point2D) _pos.clone();
    }

    @Override
    public Shape position(Point2D position) {
        _pos = (Point2D) position.clone();
        return this;
    }

    @Override
    public Shape translate(Point2D vec) {
        _pos.setLocation(_pos.getX() + vec.getX(), _pos.getY() + vec.getY());
        return this;
    }

    @Override
    public Shape scale(Point2D vec) {
        _size.setLocation(_size.getX() * vec.getX(), _size.getY() * vec.getY());
        return this;
    }

    @Override
    public Shape scale(double scalar) {
        scale(new Point2D.Double(scalar, scalar));
        return this;
    }

    @Override
    public Shape clone() {
        return new RectangleFx(this);
    }

}
