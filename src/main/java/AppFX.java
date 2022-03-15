import javafx.application.Application;
import java.awt.geom.Point2D;

import factory.FactoryFX;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import xshape.Shape;

public class AppFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 650);
        primaryStage.setTitle("Hello World!");

        FactoryFX factoryFX = new FactoryFX(root);

        Shape shape = factoryFX.createRectangle(225, 225, 50, 50);
        shape.rotate(45);
        

        shape = factoryFX.createBorder(shape);
        shape = factoryFX.createBorder(shape);

        Shape shape2 = shape.clone();
        // shape.scale(2);
        //
        shape.translate(new Point2D.Double(-50, 70));

        shape.translate(new Point2D.Double(50, 70));

        shape.draw();
        shape2.draw();

        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
