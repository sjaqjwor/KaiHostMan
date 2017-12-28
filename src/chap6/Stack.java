package chap6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Stack<E> {


    ArrayList<E> list = new ArrayList<>();
    private int count  = 0;
    private Object obj[] = new Object[16];
    private E e[];

    public Stack(){ }
//
//    public E push(E var1){
//        list.add(var1);
//        return var1;
//    }
//    public E pop(){
//
//        return (E)list.get(list.size());
//    }
//
//    public boolean isEmpty(){
//        return list.size()==0? true:false;
//    }

    public E push(E var){
        e=(E[])java.lang.reflect.Array.newInstance(var.getClass(),16);
        if(count==obj.length-1){
            obj= new Object[count*2];
        }
        if(count==e.length-1){
            e=(E[])java.lang.reflect.Array.newInstance(var.getClass(),count*2);
        }
        obj[count]=var;
        e[count]=var;
        count++;
        return var;
    }

    public E pop(){
        count--;
        //return (E)obj[count];
        return e[count];
    }

    public boolean isEmpty(){
        return count==0 ? true : false;
    }
}
