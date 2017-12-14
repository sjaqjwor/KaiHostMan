package chap4.PracticeExam;

public class Circle extends Shape {

    private double radius;

    public Circle(Point point , double radius){
        super(point);
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    @Override
    public Point getCenter(){
        return this.point;
    }



}
