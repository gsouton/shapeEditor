package factory;

import xshape.Shape;

public interface ShapeFactory {
   Shape createRectangle(double posX, double posY, double height, double width); 
   Shape createBorder(Shape shape);

}
