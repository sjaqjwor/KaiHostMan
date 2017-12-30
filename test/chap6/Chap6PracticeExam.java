package chap6;

import chap5.HelperClass;
import org.junit.Ignore;
import org.junit.Test;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Chap6PracticeExam {

    @Test
    public void exam1(){
        Stack<String> st = new Stack<>();
        System.out.println(st.push("asdasd"));
        st.pop();

    }

    @Test
    public void exam2(){
        Stack<String> st = new Stack<>();
        System.out.println(st.isEmpty());
        System.out.println(st.push("tmd"));
        System.out.println(st.push("asdasdasd"));
        System.out.println(st.isEmpty());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());
    }

    @Test
    public void exam3(){
        Table<Integer, String> table = new Table<>();
        table.put(1,"승기");
        System.out.println(table.getValue(10));
        System.out.println(table.getValue(1));
        table.remove(1);
        System.out.println(table.getValue(1
        ));

    }

    @Test
    public void exam5(){
        //오류가 나는건 T에 파라미터를 보고 컴파일러가 추론할수 없다 dobule과 int가 섞였기 때문에

        Number[] result =   ArraysExam.swap(0,1,1.5,2,2.3);

        for(int a=0;a<result.length;a++){
            System.out.println(result[a]);
        }

        // 2가 더블이 아니기에
        Double[] result1 = ArraysExam.<Double>swap(0,1,1.5,2d,2.3);

        //Double[] result = (Double[])ArraysExam.swap(0,1,1.5,2,2.3);

    }

    @Test
    public void exam6(){
        List<Object> list = new ArrayList<>();
        list.add(1);
        List<Employee> list1  = new ArrayList<>();
        ArraysExam.change1(list,list1);
//        list1.forEach(s->System.out.printOln(s.toString()));
        for(int a=0;a<list1.size();a++){
            list1.get(a);
            Object obj= list1.get(a);
            String.valueOf(obj);
        }

    }


    @Test
    public void exam7(){
        Pair<String> pair = new Pair<>("je","rt");
        System.out.println(pair.getF());
        System.out.println(pair.getT());
    }

    @Test
    public void exam8(){
        Pair<String> pair = new Pair<>("a","b");
        System.out.println(pair.getMax());
        System.out.println(pair.getMin());
    }

    @Test
    public void exam9(){
        ArrayList<String> list = new ArrayList<>();
        list.add("k");
        list.add("y");
        list.add("t");
        System.out.println(ArraysExam.firstLast(list).getT());
        System.out.println(ArraysExam.firstLast(list).getF());
    }

    @Test
    public void exam10(){
        ArrayList<Pair<Integer>> list = new ArrayList<>();
        list.add(new Pair<Integer>(3,4));
        list.add(new Pair<Integer>(7,3));
        list.add(new Pair<Integer>(5,6));
        Pair<Integer> p = ArraysExam.min(list);
        System.out.println(p.getF() + " "+ p.getT());
        Pair<Integer> p1 = ArraysExam.max(list);
        System.out.println(p1.getF()+ " "+ p1.getT());
    }

    @Test
    public void exam11(){
        ArrayList<Pair<Integer>> list = new ArrayList<>();
        list.add(new Pair<Integer>(3,4));
        list.add(new Pair<Integer>(7,3));
        list.add(new Pair<Integer>(5,6));
        Pair<Integer> p = ArraysExam.minMax(list);
        System.out.println(p.getF()+" "+p.getT());
    }

    @Test
    public void exam12(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<Object> result = new ArrayList<>();
        ArraysExam.minmax(list,Comparator.comparing(s->s),result);
        result.forEach(s->System.out.println(s));

    }

    @Test
    public void exam13(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        List<Object> result = new ArrayList<>();
        ArraysExam.mx(list,Comparator.comparing(s->s),result);

    }


    @Test
    public void exam14(){


    }

    @Test
    public void exam15(){
        List<Integer> list = new ArrayList<>();
        for(int a=0;a<100;a++){
            list.add(a);
        }
        List<Integer> list1 = ArraysExam.f(list,(s)-> s*2);
        list1.forEach(s->System.out.println(s));
    }

    @Test
    public void exam17(){
        System.out.println("javap -c Employee > e.txt");
    }

    @Test
    public void exam18(){
        //ArraysExam.repeat(10,42,int[]::new);
        ArraysExam.repeat(10,42,Integer[]::new);
    }
    @Test
    public void exam19(){
        System.out.println("타입변수는 인스턴스 생성 불가 이유는 타입변수가 사라지면 개발자의 의도 대로 만들어지지 않는다. ");
    }

    @Ignore
    @Test
    public void exam20(){
       Integer[]k = ArraysExam.r(10,42,43,44,45);

    }





}
