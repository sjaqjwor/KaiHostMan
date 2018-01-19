package chap8;

import chap8.practice.Practice;
import jdk.nashorn.internal.parser.TokenStream;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ChapPracticeExam {

    @Test
    public void test1(){
        Practice.exam1();
    }

    @Test
    public void test2() throws IOException{
        Practice.exam2();
    }

    @Test
    public void test3(){
        Practice.exam3();
    }

    @Test
    public void test4(){
        Practice.exam4(25214903917L,11L);
    }
    @Test
    public void test5(){
        Practice.exam5();
    }

    @Test
    public void test6(){
        System.out.println(Practice.exam6("koke"));
        System.out.println(Practice.exam6("koke1"));
        System.out.println(Practice.exam6("koke3"));
    }
    @Test
    public void test7() throws IOException{
        Practice.exam7();
    }

    @Test
    public void test9(){
        Practice.exam9();
    }
    @Test
    public void test10(){

        Practice.exam10();;
    }
    @Test
    public void test12(){
        Stream<String> list1 = Arrays.asList("seung","ki").stream();
        Stream<String> list2 = Arrays.asList("fuck").stream();
        Stream<String> list = Practice.zip(list1,list2);
        list.forEach(System.out::println);
    }
    @Test
    public void test13(){
        ArrayList<String> list = new ArrayList<>();
        list.add("seungki");
        list.add("dami");
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("koke");
        list1.add("saida");
        ArrayList<String> list3 = Practice.exam13(Stream.of(list,list1));
        list3.forEach(System.out::print);
    }
    @Test
    public void test14(){
        List<Double> list = new ArrayList<>();
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);
        list.add(6.0);
        list.add(7.0);
        Stream<Double> stream = list.stream();
//        double d1 = stream.mapToDouble(d -> d).average().orElse(0.0);
//        System.out.println(d1);
        //stream은 한번ㅁ나 소비가능한데 2번한 경우가 됨...
        double d = stream.reduce((x,y)->x+y).
                map(x -> x/stream.count()).
                orElse(0.0);

        System.out.println(d);
    }
    @Test
    public void test17(){
        Practice.disti();
    }
}
