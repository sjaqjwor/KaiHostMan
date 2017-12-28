package chap6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysExam{

    public static <T> T[] swap(int i, int j , T ...value){
        T t = value[i];
        value[i]=value[j];
        value[j]=t;
        return value;
    }

    public static <E> List<?> change(List<? extends E> list,List<? super E>list1){
        list1.addAll(list);
        return list1;
    }

    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<E> list){
        Pair<E> pair = new Pair<E>(list.get(0),list.get(list.size()-1));
        return pair;
    }

    public static <E extends Comparable<E>> Pair<E> min(ArrayList<Pair<E>> list){
        Pair<E> min = list.get(0);
        Pair<E> max = list.get(0);
        for(Pair<E> p : list){
           if(min.getF().compareTo(p.getF())>0 && min.getT().compareTo(p.getT())>0){
                min=p;
            }

        }
        return min;
    }

    public static <E extends Comparable<E>> Pair<E> max(ArrayList<Pair<E>> list){
        Pair<E> max = list.get(0);
        for(Pair<E> p : list){
            if(max.getF().compareTo(p.getF())<0 && max.getT().compareTo(p.getT())<0){
                max=p;
            }

        }
        return max;
    }
    public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<Pair<E>> list){
        E min = list.get(0).getF();
        E max = list.get(0).getT();
        for(Pair<E> p : list){
            if(min.compareTo(p.getF())<0){
                min=p.getF();
            }
            if(max.compareTo(p.getT())<0){
                max=p.getT();
            }

        }

        return new Pair<E>(min,max);
    }


}
