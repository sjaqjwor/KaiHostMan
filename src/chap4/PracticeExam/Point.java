package chap4.PracticeExam;

import java.util.Objects;

public class Point {
//    private double x;
//    private double y;


    protected double x;
    protected double y;

    public Point(double x , double y){
        this.x=x;
        this.y=y;
    }

//    public double getX(){
//        return this.x;
//    }
//    public double getY(){
//        return this.y;
//    }




    @Override
    public String toString(){
        return "X"+" : "+this.x+" "+"Y : "+this.y;
    }

    @Override
    public boolean equals(Object object){
        if(this==object) return true;
        if(!(object instanceof Point)) return false;
//        if(getClass()!=object.getClass()) return false;
        Point p = (Point)object;
        return new Double(this.x).equals(new Double(p.x))&&new Double(this.y).equals(new Double(p.y));
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.x,this.y);
    }

}
