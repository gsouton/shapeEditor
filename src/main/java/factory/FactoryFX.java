package factory;

import javafx.scene.Group;
import xshape.BorderShapeFx;
import xshape.RectangleFx;
import xshape.Shape;

public class FactoryFX implements ShapeFactory {
    private Group _group;

    public FactoryFX(Group group){
        _group = group;
    }

    @Override
    public Shape createRectangle(double posX, double posY, double height, double width) {
        return new RectangleFx(posX, posY, height, width, _group);
    }


    @Override
    public Shape createBorder(Shape shape) {
        return new BorderShapeFx(shape, _group);
    }
    
}
