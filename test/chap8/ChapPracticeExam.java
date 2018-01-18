package chap8;

import chap8.practice.Practice;
import jdk.nashorn.internal.parser.TokenStream;
import org.junit.Test;

import java.io.IOException;
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
}
