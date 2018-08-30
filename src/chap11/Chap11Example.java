package chap11;

public class Chap11Example {
    public static void main(String args[]){
        Point p = new Point(1,2);
        Point p1 = new Point(1,2);
        System.out.println(p.equals(p1));
    }
}
class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}

