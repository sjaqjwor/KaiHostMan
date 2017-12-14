package chap4;

import chap3.Example;

public class Example2  extends Example{
    public Example2(int salary){
        super(salary);
    }
    public int get(){
        return salary;
    }

    @Override
    public void test(){
        Thread t = new Thread(super::test);
        t.start();

    }
}
