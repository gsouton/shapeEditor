package xshape;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.text.AsyncBoxView.ChildState;

public class Group implements Shape {
    private ArrayList<Shape> _children = new ArrayList<>();
    private Point2D _pos;
    private Point2D _size;
    private double _rotation;

    public boolean add(Shape child) {
        updateSize(child);
        updatePosition(child);
        return _children.add(child);
    }

    public boolean remove(Shape child) {
        return _children.remove(child);
    }

    @Override
    public void draw() {
        _children.forEach(child -> child.draw());
    }

    @Override
    public Point2D size() {
        return (Point2D) _size.clone();
    }

    @Override
    public Shape size(Point2D vec) {
        _children.forEach(child -> child.size(vec));
        return this;
    }

    @Override
    public Point2D position() {
        return (Point2D) _pos.clone();
    }

    @Override
    public Shape position(Point2D position) {
        double deltaX = _pos.getX() - position.getX();
        double deltaY = _pos.getY() - position.getY();
        Point2D vec = new Point2D.Double(deltaX, deltaY);
        _children.forEach(_children -> {
            _children.translate(vec);
        });
        _pos.setLocation(position);
        return this;
    }

    @Override
    public Shape translate(Point2D vec) {
        _children.forEach(child -> child.translate(vec));
        _pos.setLocation(_pos.getX() + vec.getX(),
                _pos.getY() + vec.getY());
        return this;
    }

    @Override
    public Shape rotate(double rad) {
        _children.forEach(child -> child.rotate(rad));
        return this;
    }

    @Override
    public double rotation() {
        return _rotation;
    }

    @Override
    public Shape clone() {
        Group newGroup = null;
        try {
            newGroup = (Group) super.clone();
            newGroup._pos = (Point2D) _pos.clone();
            newGroup._size = (Point2D) _size.clone();
            newGroup._rotation = _rotation;
            ArrayList<Shape> children = new ArrayList<>();
            for (Shape shape : _children)
                children.add((Shape) shape.clone());
            newGroup._children = children;
        } catch (CloneNotSupportedException e) {
        }
        return newGroup;
    }

    @Override
    public boolean hasNext() {
        return _children.iterator().hasNext();
    }

    @Override
    public Shape next() {
        return _children.iterator().next();
    }

    /**
     * Method use when a shape is added to the group to update its update its
     * position
     */
    private void updatePosition(Shape shape) {
        if (_pos == null) {
            _pos = shape.position();
        } else {
            Point2D point = shape.position();
            if (point.getX() < _pos.getX())
                _pos.setLocation(point.getX(), _pos.getY());
            if (point.getY() < _pos.getY())
                _pos.setLocation(_pos.getX(), point.getY());

        }
    }

    private void updateSize(Shape shape) {
        Point2D size = shape.size();
        if (_size == null) {
            _size = size;
        } else {
            Point2D p = shape.position();
            double deltaX = Math.abs(_pos.getX() - p.getX());
            double deltaY = Math.abs(_pos.getY() - p.getY());
            _size.setLocation(_size.getX() + size().getX() + deltaX, _size.getY() + size().getY() + deltaY);

        }
    }

    @Override
    public Iterator<Shape> iterator() {
        return _children.iterator();
    }

}
