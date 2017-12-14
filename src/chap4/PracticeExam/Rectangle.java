package chap4.PracticeExam;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(Point point ,double width, double height){
        super(point);
        this.width=width;
        this.height=height;
    }

    public double getWidth(){
        return this.width;
    }

    public double getHeight(){
        return this.height;
    }

    @Override
    public Point getCenter(){
        return this.point;
    }

}
