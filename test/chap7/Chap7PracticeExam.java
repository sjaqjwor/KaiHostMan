package chap7;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Chap7PracticeExam {

    @Test
    public void exma1() {
        HashSet<Integer> hs = new HashSet<Integer>();
            for(int a=2;a<10;a++){
                hs.add(a);
            }
        int s = 2;
        while (s * s < 10) {
            for (int i = 0; i < hs.size(); i++) {
                if (hs.contains(s * (s + i))) {
                    hs.remove(s * (s + i));
                }
            }
            s++;
        }
        hs.forEach(s1->System.out.println(s1));

        BitSet bitSet = new BitSet(10);
        for(int a=2;a<10;a++){
            bitSet.set(a);
        }
        s = 2;
        while (s * s < 10) {
            for (int i = 0; i < hs.size(); i++) {

                    bitSet.clear(s * (s + i));

            }
            s++;
        }
        System.out.println();
        bitSet.stream().forEach(s1->System.out.println(s1));

    }
    @Test
    public void exam2() {
        List<String> list = new ArrayList<>();
        for (char a = 'a'; a <= 'z'; a++) {
            list.add(String.valueOf(a));
        }
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.set(iterator.next().toUpperCase());
        }
        list.forEach(s -> System.out.print(s+" "));
        System.out.println();

        list= new ArrayList<>();
        for (char a = 'a'; a <= 'z'; a++) {
            list.add(String.valueOf(a));
        }

        for(int a=0;a<list.size();a++){
            list.set(a,list.get(a).toUpperCase());
        }
        list.forEach(s->System.out.print(s+" "));

        System.out.println();

        list= new ArrayList<>();
        for(char a='a';a<='z';a++){
            list.add(String.valueOf(a));
        }
        list.replaceAll(String::toUpperCase);
        list.forEach(s->System.out.print(s+ " "));
    }

    @Test
    public void exam3(){
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        Set<String> set1  = new HashSet<>();
        set1.add("a");
        set1.add("c");

       //pluse
//       set.addAll(set1);
//       set.forEach(s->System.out.println(s));
       //minus
        //set.removeAll(set1);
        //set.forEach(s->System.out.println(s));
        //교집합
        set.retainAll(set1);
        set.forEach(s->System.out.println(s));
    }

    @Test
    public void exam4(){
        ChapExample chapExample = new ChapExample();
        chapExample.concurrent();

    }

    @Test
    public void exam5(){
        List<String> list = new ArrayList<>();
        List<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list.add("a");
        list.add("b");
        list.add("c");
        ChapExample.swap(list1,0,1);
        ChapExample.swap(list,0,1);
        list.forEach(s->System.out.println(s));
        list1.forEach(s->System.out.println(s));
    }
    @Test
    public void exam6(){
        Map<String,Set<String>> map  = new TreeMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(10);

    }

    @Test
    public void exam7(){
        Map<String,Integer> map = new TreeMap<>();
        try(BufferedReader bu =new BufferedReader(new FileReader(new File("test.txt")))){
            String read=null;
            while((read=bu.readLine())!=null){
                map.merge(read,1,Integer::sum);
            }
        }catch (Exception e){

        }
        for(Map.Entry<String, Integer> m : map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
    }
    @Test
    public void exam8(){
        Map<String,List<Integer>> set = new HashMap<>();
        try(BufferedReader bu =new BufferedReader(new FileReader(new File("text1.txt")))){
            String read=null;
            int count = 0;
            while((read=bu.readLine())!=null){
                count++;
                if(set.containsKey(read)){
                    List<Integer> list = set.get(read);
                    list.add(count);
                    set.put(read,list);
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(count);
                    set.put(read,list);
                }
            }
        }catch (Exception e){

        }
       for(Map.Entry<String, List<Integer>> e : set.entrySet()){
            System.out.print(e.getKey()+" ");
            for(int a=0;a<e.getValue().size();a++){
                System.out.print(e.getValue().get(a)+" ");
            }
            System.out.println();
       }

    }
    @Test
    public void exam9(){

    Map<String,Integer> map = new TreeMap<>();
        try(BufferedReader bu =new BufferedReader(new FileReader(new File("test.txt")))){
        String read=null;
        while((read=bu.readLine())!=null){
//            if(!map.containsKey(read)){
//                map.put(read,1);
//            }else
//                map.put(read,map.get(read)+1);
//            if(map.get(read)==null){
//                map.put(read,1);
//            }else{
//                map.put(read,map.get(read)+1);
//            }
//            int k = map.getOrDefault(read,0);
//            map.put(read,++k);
            map.putIfAbsent(read,0);
            int k = map.get(read);
            map.put(read,++k);

        }
    }catch (Exception e){

    }
        for(Map.Entry<String, Integer> m : map.entrySet()){
        System.out.println(m.getKey()+" "+m.getValue());
    }
}

    @Test
    public void exam11(){
        List<String> list = new ArrayList<>();
        try(BufferedReader bu =new BufferedReader(new FileReader(new File("test2.txt")))){
            String read=null;
            while((read=bu.readLine())!=null){
//
                    list.add(read);
            }
        }catch (Exception e){

        }
        Collections.shuffle(list.subList(1,list.size()-2));
        list.forEach(s->System.out.println(s));
    }

    @Test
    public void test12(){
        String k = "Happy new year thank you very.";
        List<String> list=Arrays.asList(k.split(" "));
        list.forEach(s->System.out.println(s));
        list.replaceAll(String::toLowerCase);
        String last = list.get(list.size()-1);
        last = last.substring(0,last.length()-1);
        list.set(list.size()-1,last);
        Collections.shuffle(list);
        String first = list.get(0);
        String first_first=first.substring(0,1).toUpperCase()+first.substring(1,first.length()-1);
        list.set(0,first_first);
        last=list.get(list.size()-1)+".";
        list.set(list.size()-1,last);
        list.forEach(s->System.out.println(s));

    }
    @Test
    public void exam13(){

        Cache cache = new Cache(10);
        for(int a=0;a<13;a++){
            cache.put("str"+a,a);
        }
        System.out.println(cache.size());
    }
    @Test
    public void exam14(){
        ChapExample chapExample = new ChapExample();
        List<Integer> list = chapExample.unmodi();
        list.add(123);
    }

    @Test
    public void exam15(){
       
    }




}
