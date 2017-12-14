package chap4.PracticeExam;

public class Line extends Shape{

    Point from;
    Point to;

    public Line(Point from , Point to){
        super(new Point(from.x+to.x,from.y+to.y));
        this.from=from;
        this.to=to;
    }

    public Point getFrom(){
        return this.from;
    }

    public Point getTo(){
        return this.to;
    }


    @Override
    public Point getCenter(){
        return this.point;
    }


}
