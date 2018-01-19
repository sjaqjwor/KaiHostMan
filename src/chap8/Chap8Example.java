package chap8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
public class Chap8Example {
//
    public static void main(String ags[]) {
////        List<String> list = new ArrayList<>();
////        list.add("ab");
////        list.add("abcd");
////        list.add("ab");
////        list.add("abc");
////        Stream<String> stream = list.stream().filter(s->s.length()>=3);
////        System.out.println(stream.count());
//	  String str = "abc def get";
//	Stream<String> stream = Stream.of(str.split(" "));
//	System.out.println(stream.count());
//	Stream<String> stream1 = Stream.of("kk","k333","ddddddd").filter(s->s.length()>3);
//	System.out.println(stream1.count());
//	Stream<String> stream2 = Stream.empty();
//	String[] st = new String[]{"aa","bbb","cccc","ddddd"};
//	Stream<String> stream3 = Arrays.stream(st,0,2);
//	System.out.println(stream3.count());

////        Stream.iterate(0,n->n+1).limit(10).forEach(s->System.out.println(s));
//        List<String> list = new ArrayList<>();
//        list.add("kee");
//        list.add("see");
//        list.add("lee");
//        list.add("jee");
//       list.stream().map((String s)-> make(s)).forEach(
//                (Stream<String> s1)->System.out.println(Arrays.toString(s1.toArray()))
//        );

//        Stream.concat(make("hello"),make("world")).forEach(System.out::print);
//        Stream.of("a","a","a","b").forEach(System.out::print);
//        Stream.of("lee","seungki","ki").sorted().forEach(System.out::println);
//        Stream.of("lee","seungki","ki").sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
//        Object[] obj = Stream.iterate(1,p -> p*2).peek(System.out::println).limit(10).toArray();
//
//        List<String> list = new ArrayList<>();
//        list.add("QAs");
//        list.add("QAS");
//        list.add("asdfasdf");
////        Optional<String> opt = list.stream().max(String::compareToIgnoreCase);
////        System.out.println(opt.get());
//        boolean start = list.stream().anyMatch(s->s.startsWith("ca"));
//        System.out.println(start);

//        Optional<String> start = Optional.empty();
//        String name = start.orElseThrow(IllegalArgumentException::new);
//        String obj = null;
//        Optional<String> start1 = Optional.ofNullable(obj);
//        System.out.println(start1);
//        List<String> list  = new ArrayList<>();
//        list.add("a");
//        list.add("bc");
//        list.add("def");


//        String[] str = list.stream().toArray(String[]::new);
//        String str = list.stream().collect(Collectors.joining());
//        System.out.println(str);
//        IntSummaryStatistics intSummaryStatistics = list.stream().collect(Collectors.summarizingInt(
//                String::length
//        ));
//        Double avg = intSummaryStatistics.getAverage();
//        int max = intSummaryStatistics.getMax();
////        System.out.println(avg+" "+max);
//        List<PersonExample> list = new ArrayList<>();
//        list.add(new PersonExample(1,"승기"));
//        list.add(new PersonExample(1,"라"));
//        list.add(new PersonExample(3,"컨"));
//        list.add(new PersonExample(4,"츠"));
//        Map<Integer ,String> map = list.stream().collect(Collectors.toMap(
//                PersonExample::getId, PersonExample::getName,
//                (s,s1)->s1
//        ));
//        map.forEach((s,s1)->System.out.println(s+" "+s1));
        List<Country> list= new ArrayList<>();
        list.add(new Country("KOREA","a"));
        list.add(new Country("일본","c"));
        list.add(new Country("KOREA","av"));
        list.add(new Country("일본","cd"));
        list.add(new Country("일본","cddcd"));
//        Map<String,Set<String>> c = list.stream().collect(
//                Collectors.toMap(
//                        Country::getName,
//                        l->Collections.singleton(l.getLanguage()),
//                        (a,b) -> {
//                            Set<String> union = new HashSet(a);
//                            union.addAll(b);
//                            return union;
//                }
//
//                )
//        );
//        c.forEach((s,s1)->System.out.println(s+" "+s1.toString()));
//        Map<String,Country> map = list.stream().collect(
//                Collectors.toMap(
//                        Country::getName,
//                        Function.identity(),
//                        (a,b)->{throw new IllegalArgumentException();},
//                        TreeMap::new
//                )
//        );
//        map.forEach((s,s1)->System.out.println(s+" "+s1.name+" "+s1.language));

        Map<String , List<Country>> map = list.stream().collect(
                Collectors.groupingBy(Country::getName)
        );
        List<Country> l = map.get("KOREA");
        l.forEach((s)->System.out.println(s.name+" "+s.language));

//        Map<Boolean,List<Country>> m = list.stream().collect(
//                Collectors.partitioningBy((Country s) -> s.getName().equals("KOREA"))
//        );
//        List<Country> li = m.get(false);
//        System.out.println();
//        li.forEach(s -> System.out.println(s.name+" "+s.language));
//        System.out.println();
//        Map<String,Optional<String>> m  = list.stream().collect(
//                Collectors.groupingBy(
//                        Country::getName,
////                        counting()
////                        summingInt(Country::getLanguage)
////                        maxBy(Comparator.comparing(Country::getLanguage))
//                        mapping(Country::getLanguage,
//                                maxBy(Comparator.comparing(String::length)))
//                    )
//        );
////        System.out.println(m.get("KOREA").get().name+" "+m.get("KOREA").get().language);
//        System.out.println(m.get("KOREA").get());

//        List<Exampp> list1 = new ArrayList<>();
//        list1.add(new Exampp("A",10));
//        list1.add(new Exampp("B",11));
//        list1.add(new Exampp("C",12));
//        list1.add(new Exampp("D",13));
//        list1.add(new Exampp("E",14));
//        Integer sum = list1.stream().mapToInt(Exampp::getPeek).sum();
//        System.out.println(sum);
        List<String> list1 = new ArrayList<>();
        list1.add("kaaa");
        list1.add("kaaa");
        list1.add("asd");
        list1.add("asd");
        list1.add("asd");
        list1.add("c");
        int arr[] = new int[5];
        List<String> list2  = new ArrayList<>();
        list2.add("a");
        List<String> list3 = new ArrayList<>();
        list3.add("4");
        Stream<String> stringStream = Stream.concat(list2.stream(),list3.stream()).peek(System.out::println);


    }
    public static Stream<String> make(String s){
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.substring(i,i+1));
        }
        return list.stream();
    }


//
//
}

