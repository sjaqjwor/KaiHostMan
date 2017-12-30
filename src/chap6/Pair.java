package chap6;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Comparator;

//public class Pair <E extends Comparable<E>> {
public class Pair<E extends Comparable<E>>{

    private E f,t;

    public Pair(E f, E t){
        this.f=f;
        this.t=t;
    }

    public E getF(){
        return f;
    }
    public E getT(){
        return t;
    }
    public E getMin(){
        return f.compareTo(t)<0 ? f: t;
    }

    public E getMax(){
        return f.compareTo(t)>0 ? f: t;
    }
}
