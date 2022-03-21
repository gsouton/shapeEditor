package xshape;

import java.awt.geom.Point2D;

public abstract class XShape {
    private ShapeFactory _factory = null;
    Shape[] _shapes = null;

    // method factory to delegate instanciation of Shapefactory to subclass
    protected abstract ShapeFactory createFactory();

    // Handler to start the GUI
    abstract void run();

    private void createScene() {
        Shape shape = _factory.createRectangle(100, 100, 50, 50);
        shape = _factory.createBorder(shape);
        shape = _factory.createBorder(shape);
        Shape shape2 = shape.clone();
        shape2.translate(new Point2D.Double(100, 50));

        Shape shape3 = _factory.createRectangle(300, 300, 200, 200);
        Shape shape4 = shape3.clone();
        shape4.translate(new Point2D.Double(200, 200));
        shape4 = _factory.createBorder(shape4);

        Group group = new Group();
        group.add(shape3);
        group.add(shape4);
        group.translate(new Point2D.Double(200, 0));
        group.rotate(45);

        Shape[] tmp = { shape, group };
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
