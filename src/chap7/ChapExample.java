package chap7;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

public class ChapExample {


   public void concurrent(){
       List<String> list = new ArrayList<>();
       list.add("a");
       list.add("b");
       list.add("c");

//       for(String k : list){
//
//               list.remove(k);
//
//       }

       Iterator<String> iterator = list.iterator();
       while(iterator.hasNext()){
           if("a".equals(iterator.next())){
               iterator.remove();
           }
       }
   }
   public static void swap(List<?> list ,int i , int j){

       swaphelper(list,i,j);
    }
    public static <T> void swaphelper(List<T> list , int i , int j){
       if(list instanceof RandomAccess){
           T temp = list.get(i);
           list.set(i,list.get(j));
           list.set(j,temp);
       }else{
           ListIterator<T> listIterator = list.listIterator();
           T temp = list.get(i);
           T temp1 = list.get(j);
           while (listIterator.hasNext()){
               listIterator.next();
               if(listIterator.nextIndex()-1==i){
                   listIterator.set(temp1);
               }
               if(listIterator.nextIndex()-1==j){
                   listIterator.set(temp);
               }

           }
       }
    }

    public List<Integer> unmodi(){

       return Collections.unmodifiableList(Arrays.asList(1,2,3,4,5,6,7,8,9));
    }

}

