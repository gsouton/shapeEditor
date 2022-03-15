package xshape;

public abstract class AbstractShape implements Cloneable, Shape  {
    public Shape clone(){
        Shape shape = null;
        try{
            shape = (Shape) super.clone();
        }catch(Exception e){
            e.printStackTrace();
        }
        return shape;
    }
}
