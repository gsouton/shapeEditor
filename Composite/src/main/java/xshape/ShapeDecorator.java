package xshape;
import java.awt.geom.Point2D;
/*
* Decorator pattern
*/
public abstract class ShapeDecorator implements Shape {
	private Shape _shape;

	public ShapeDecorator(Shape shape){
		_shape = shape;
	}
	
	@Override
	public ShapeDecorator clone() {
		ShapeDecorator newShape = null;
		try {
			newShape = (ShapeDecorator)super.clone();
			newShape._shape = _shape.clone();
		}
		catch (CloneNotSupportedException e) {
		}
		return newShape;
	}

	@Override
	public void draw() {	
		_shape.draw();
	}

	@Override
	public Point2D size() {
		return _shape.size();
	}

	@Override
	public Shape size(Point2D vec) {
		return _shape.size(vec);
	}

	@Override
	public Point2D position() {
		return _shape.position();
	}

	@Override
	public Shape position(Point2D position) {
		return _shape.position(position);
	}

	@Override
	public Shape rotate(double rad) {
		return _shape.rotate(rad);
	}

	@Override
	public double rotation() {
		return _shape.rotation();
	}

	@Override
	public Shape translate(Point2D new_position) {
		return _shape.translate(new_position);
	}
}