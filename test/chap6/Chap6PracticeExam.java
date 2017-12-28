package chap6;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chap6PracticeExam {

    @Test
    public void exam1(){
        Stack<String> st = new Stack<>();
        st.push("asdasd");

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
       // Double[] result =   ArraysExam.swap(0,1,1.5,2,2.3);
        // 2가 더블이 아니기에
        //Double[] result = ArraysExam.<Double>swap(0,1,1.5,2,2.3)

        Double[] result = (Double [])ArraysExam.swap(0,1,1.5,2,2.3);
    }

    @Test
    public void exam6(){
        List<CharSequence> list = new ArrayList<>();
        list.add("asdasdasd");
        List<CharSequence> list1  = new ArrayList<>();
        ArraysExam.change(list,list1);
    }


    @Test
    public void exam7(){
        Pair<String> pair = new Pair<>("SE","KE");
        System.out.println(pair.getF());
        System.out.println(pair.getT());
    }

    @Test
    public void exam8(){
        Pair<String> pair = new Pair<>("a","b");
//        System.out.println(pair.getMax());
//        System.out.println(pair.getMin());
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

}
