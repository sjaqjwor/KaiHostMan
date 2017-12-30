package chap6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;

public class ArraysExam{

    public static <T> T[] swap(int i, int j , T ...value){
        System.out.println(value.getClass().getComponentType());
        T t = value[i];
        value[i]=value[j];
        value[j]=t;
        return value;
    }

//    public static <E> List<?> change(List<? extends E> list,List<E>list1){
//
//        list1.addAll(list);
//
//        return list1;
//    }
    public static <E> void change1(List<? super E> list , List<E>list1){

      for(int a=0;a<list.size();a++){
          list1.add((E)list.get(a));
      }

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

    public static <T> void minmax(List<T> elements , Comparator<? super T> comp , List<? super T> result){
        T min = elements.get(0);
        T max = elements.get(0);
        for(T t1 : elements){
            if(comp.compare(t1,min)<0){
                min=t1;
            }
            if(comp.compare(t1,max)>0){
                max=t1;
            }
        }
        result.add(min);
        result.add(max);
    }

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> list){
//        T t = null;
//        for(int a=0; a<list.size();a++){
//            try{
//                t=list.get(a);
//            }catch (Exception e){
//
//            }finally {
//                if(t!=null){
//                    try {
//                        t.close();
//                    }catch (Exception e){
//
//                    }
//                }
//            }
//        }


        for(int a=0;a<list.size();a++){
            try(T t = list.get(a)){

            }catch (Exception e){

            }
        }
    }

    public static <T,R> List<R> f(List<T> list , Function<T,R> function){
        List<R> result = new ArrayList<>();
        for(T t : list){
            result.add(function.apply(t));
        }
        return result;
    }

    public static <T> ArrayList<T> repeat(int n, T obj, IntFunction<T[]> constr){
        ArrayList<T> list = new ArrayList<>();
        return list;
    }

    public static final <T> T[] r(int n , T...objs){
        T []t = objs;
        for(int a=0;a<n;a++){
            t= Arrays.copyOf(t,n);
        }
        return t;
    }
    private static <T> void swaph(List<T> elements,int i , int j){
        T temp = elements.get(i);
        elements.set(i,elements.get(j));
        elements.set(j,temp);
    }
    public static <T> void mx(List<T> e , Comparator<? super  T> comparator, List<? super T> list ){
//        minmax(e,comparator,list);

        swaph(list,0,1);
    }


}
