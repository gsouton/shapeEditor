package xshape;

import java.awt.geom.Point2D;

public interface Shape {
    void draw();

    Point2D size();

    Shape size(Point2D vec);

    Shape scale(double scalar);

    Shape scale(Point2D scalar);

    Shape clone();

    Point2D position();

    Shape position(Point2D position);

    Shape translate(Point2D vec);

    Shape rotate(double rad);

    double rotation();
}
