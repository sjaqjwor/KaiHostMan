package chap4.PracticeExam;

import java.util.Objects;

public abstract class Shape implements Cloneable{

    Point point;

    public Shape(Point point){
        this.point=point;
    }

    public void moveBy(double dx, double dy){
        this.point.x+=dx;
        this.point.y+=dy;
    }

    abstract Point getCenter();

    public Shape clone() throws CloneNotSupportedException{
        return (Shape)super.clone();
    }
}
