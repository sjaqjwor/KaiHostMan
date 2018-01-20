package chap8.practice;

import jdk.nashorn.internal.parser.TokenStream;

import javax.swing.text.StringContent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Practice{

    public static void exam1(){
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("키위");
        list.add("적포도");
        list.add("파인애플1");
        list.add("파인애플2");
        list.add("파인애플3");
        list.add("ko");
        list.add("ki3");
        Collections.sort(list, Comparator.comparing(String::length).reversed());
        list.stream().filter(s -> {
            if (s.length() >2) {
                System.out.println(s);
                return true;
            }else{
                return false;
            }
        }).limit(5).toArray();
    }
    public static void exam2() throws IOException{

        List<String> list = new ArrayList<>();
        try(BufferedReader bu =new BufferedReader(new FileReader(new File("checktime.txt")))) {
            String read=null;
            while((read=bu.readLine())!=null){
                list.add(read);
            }
        }
        Collections.sort(list, Comparator.comparing(String::length).reversed());

        System.out.println("stream");
        long start = System.currentTimeMillis();
        list.stream().filter(s -> s.length()>2).count();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        System.out.println();
        System.out.println("parallelStream");
        long start1=System.currentTimeMillis();
        list.parallelStream().filter(s -> s.length()>2).count();
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start1);
    }

    public static void exam3(){
        int value[] = {1,4,9,16};
        Stream<int[]> stream = Stream.of(value);
        System.out.println(stream.count());
        IntStream intStream = Arrays.stream(value);
        System.out.println(intStream.count());
        IntStream i = IntStream.of(value);
        System.out.println(i.count());
    }
    public static void exam4(Long a, Long c){
        Stream<Long>stream = Stream.iterate(new Long(0), (Long n) -> ((a*n)+c)%(long)Math.pow(2,48));
        stream.limit(10).forEach(System.out::println);
    }
    public static void exam5(){
      String str = "boat";
      //map은 같은 자료형은로 반환 mapToObj는 다른 객체로 반환//
      Stream<String> stream = IntStream.rangeClosed(0, str.length()-1).mapToObj(k -> str.substring(k,k+1));
      stream.forEach(System.out::println);
    }
    public static void exam6(String s){
        if(check(s)){
            System.out.println("only 단어");
        }else{
            System.out.println("뛰어쓰기 존재 or 혹은 다른 문자");
        }
    }
    private static boolean check(String s){
//      return IntStream.range(0, s.length()).mapToObj(i -> s.substring(i,i+1)).allMatch(c -> { for(int a=0;a<c.length();a++){ if(!Character.isAlphabetic(c.charAt(a))){ return false; }; }return true; });
        return s.codePoints().allMatch(c-> Character.isAlphabetic(c)&&c!=32);
    }

    public static void exam7() throws IOException {
        try (Stream<String> stream = Files.lines(Paths.get("alice.txt"))) {
            Map<String, Long> wo = stream.flatMap(line -> Arrays.stream(line.trim().split(" ")))
                    .map(w -> w.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(
                            w -> w.length() > 0
                    ).map(w -> new AbstractMap.SimpleEntry<>(w, 1)).collect(
                            Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, Collectors.counting()));

//            wo.forEach((k,v)-> System.out.println(k+" "+v));
//            wo.keySet().stream().sorted(Comparator.comparing(wo::get).reversed()).limit(10)
//                    .forEach(s-> System.out.println(s+" "+wo.get(s)));
            wo.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEach(System.out::println);
//        try(Stream<String> stream = Files.lines(Paths.get("/test.txt"))){
////           list = stream.filter(s->check(s)).map(String::toLowerCase)
//        }
            ;

        }
    }
    public static void exam8() throws IOException{
        try (Stream<String> stream = Files.lines(Paths.get("/usr/share/dict/words"))){
            long lo = stream.flatMap(s->Arrays.stream(s.trim().split(" "))).map(w -> w.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(s1 -> s1.contains("a") && s1.contains("e") && s1.contains("i") && s1.contains("o") && s1.contains("u")).count();
            System.out.println(lo);
        }
    }
    public static void exam9(){
        String str = "ohjinwoo is fool and he is a always solo";
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(str.split(" ")).collect(Collectors.summarizingInt(String::length));
        System.out.println(intSummaryStatistics.getAverage());
    }

    public static void exam10(){
        String str = "kola is the best drink and goods";
//        String str = null;
        int max = Arrays.stream(str.split(" ")).mapToInt(s->s.length()).max().orElse(0);
        List<String> list = Arrays.stream(str.split(" ")).filter(s->s.length()==max).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
    public static void exam11(){
        //무한이면 찾을 방도가 없다.
    }
    public static <T> Stream<T> zip(Stream<T> stream1, Stream<T> stream2){
        List<T> list1 = stream1.collect(Collectors.toList());
        List<T> list2 = stream2.collect(Collectors.toList());
        int max = list1.size() > list2.size() ? list1.size() : list2.size();
        List<T> list3 = new ArrayList<>();
        for(int a=0;a<max;a++){
            list3.add(a>=list1.size() ? null : list1.get(a));
            list3.add(a>=list2.size() ? null : list2.get(a));
        }
        return list3.stream();
    }
    public static<T> ArrayList<T> exam13( Stream<ArrayList<T>> stream ){

        return stream.reduce(new ArrayList<>(),(s,s1)->Stream.concat(s.stream(),s1.stream()).collect(Collectors.toCollection(ArrayList::new)));
        
    }

    public static void disti(){
        List<String> list = new ArrayList<>();
        for(char a='A';a<'Z';a++){
            for(int a1=0;a1<2;a1++) {
                list.add(String.valueOf(a));
            }
        }
        list.forEach(System.out::print);
        System.out.println();
        list.stream().distinct().forEach(System.out::print);
        System.out.println();
        list.parallelStream().distinct().forEach(System.out::print);

    }

}
