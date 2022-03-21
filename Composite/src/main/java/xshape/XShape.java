package xshape;

import java.awt.geom.Point2D;

public abstract class XShape {
    private ShapeFactory _factory = null;
    Shape[] _shapes = null;

    //method factory to delegate instanciation of Shapefactory to subclass
    protected abstract ShapeFactory createFactory();
    //Handler to start the GUI
    abstract void run();

    private void createScene() {
        Shape shape = _factory.createRectangle(100, 100, 50, 50);
        shape = _factory.createBorder(shape);
        shape = _factory.createBorder(shape);
        Shape shape2 = shape.clone();
        shape2.translate(new Point2D.Double(100, 50));
        Shape[] tmp = { shape, shape2 };
        _shapes = tmp;
    }

    public void draw() {
        if (_shapes == null) {
            _factory = createFactory();
            createScene();
        }

        for (Shape s : _shapes)
            s.draw();
    }

}
