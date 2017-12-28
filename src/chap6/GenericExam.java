package chap6;

import java.util.ArrayList;
import java.util.Stack;
import java.util.function.Predicate;

public class GenericExam {

    public static void main(String arg[]) {



        person[] people = new person[10];
        for(int a=0;a<people.length;a++){
            people[a]=new person("a"+a,a*10);
        }

        printall(people,e->e.get()>50);

    }
    static void printall(person pepoles[] ,Predicate<? super pe> filter)
    {

        for(person p : pepoles){
            if(filter.test((pe)p)){
                System.out.println(p.name);
            }
        }

    }
}
class person {

    String name;
    int salary ;

    public person(String name,int salary){
        this.name= name;
        this.salary=salary;
    }

    public int get(){
        return this.salary;
    }
}

class pe extends person{

    int count;
    public pe(String name,int salary){
        super(name,salary);
        count=this.salary*10;
    }



}
