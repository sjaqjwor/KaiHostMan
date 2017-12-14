package chap4;

import chap4.PracticeExam.*;
import org.junit.Test;

public class Chap3PracticeExam {

    @Test
    public void pointTest(){
        LabeledPoint lp = new LabeledPoint("exam",10,20);
        LabeledPoint lp2 = new LabeledPoint("exam", 10,20);
        System.out.println(lp.equals(lp2));

        Point p = new LabeledPoint("exam",10,20);

        System.out.println(p.equals(lp));
        System.out.println(lp.equals(p));
        System.out.println(p.hashCode()==lp.hashCode());
        System.out.println(p.toString());
        System.out.println(lp.toString());

    }

    @Test
    public void protectedTest(){
        Point p = new Point(10,20);
        LabeledPoint lp = new LabeledPoint("exam",10,20);
        System.out.println(lp.getX());
    }

    @Test
    public void shapeTest(){
        Point p = new Point(10,20);

        Circle c = new Circle(p,20);
        System.out.println(c.getCenter().toString());
        c.moveBy(20,30);
        System.out.println(c.getCenter().toString());

        System.out.println();
        p= new Point(27,27);
        Rectangle r = new Rectangle(p,30,20);
        System.out.println(c.getCenter().toString());
        r.moveBy(78,8);
        System.out.println(c.getCenter().toString());

        System.out.println();
        p = new Point(45,87);
        Line l = new Line(p,new Point(27,30));
        System.out.println(l.getCenter().toString());
        l.moveBy(20,47);
        System.out.println(l.getCenter().toString());

    }

    @Test
    public void equalTest(){
        //x
        DiscountedItem di = new DiscountedItem(new Item("exam",20),30);
        //y
        Item it = new Item("exam",20);
        //z
        DiscountedItem di2 = new DiscountedItem(new Item("exam",20),31);


        //x y
        System.out.println(di.equals(it));
        //y z
        System.out.println(it.equals(di2));
        //x z
        System.out.println(di.equals(di2));
    }

    @Test
    public void enumTest(){
        System.out.println(Color.getGreen());
        System.out.println(Color.getRed());
        System.out.println(Color.getBlue());
    }

}
