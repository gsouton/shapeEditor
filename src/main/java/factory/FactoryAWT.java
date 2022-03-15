package factory;

import customAWT.AWTCanvas;
import xshape.BorderShapeAWT;
import xshape.RectangleAWT;
import xshape.Shape;

public class FactoryAWT implements ShapeFactory {

    private AWTCanvas _canvas;

    public FactoryAWT(AWTCanvas canvas) {
        _canvas = canvas;

    }

    @Override
    public Shape createRectangle(double posX, double posY, double height, double width) {
        return new RectangleAWT(posX, posY, width, height, _canvas);
    }

    @Override
    public Shape createBorder(Shape shape) {
        return new BorderShapeAWT(shape, _canvas);
    }

}
