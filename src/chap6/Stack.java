package chap6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Stack<E> {


    ArrayList<E> list = new ArrayList<>();
    private int count  = 0;
    private Object obj[] = new Object[16];
    private E e[];

    public Stack(){
        e = (E[]) new Object[10];

    }
//
//    public E push(E var1){
//        list.add(var1);
//        return var1;
//    }
//    public E pop(){
//
//        return (E)list.get(list.size()-1);
//    }
//
//    public boolean isEmpty(){
//        return list.size()==0? true:false;
//    }

    public E push(E var){
        if(count==obj.length-1){
            obj= Arrays.copyOf(obj,count*2);
        }
        if(count==e.length-1){
            e=Arrays.copyOf(e,count*2);
        }
        obj[count]=var;
        e[count++]=var;
        return var;
    }

    public E pop(){
        //return (E)obj[count];
        return e[count--];
    }

    public boolean isEmpty(){
        return count==0;
    }
}
