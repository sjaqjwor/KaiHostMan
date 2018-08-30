package chap10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Chap10Example3 {
   static int a=0;
    public static void main(String arg[]){
        List<String> list = new ArrayList<>();
        list.add("test.txt");
        list.add("test2.txt");
        long k = System.currentTimeMillis();
        for(int a1=0;a1<list.size();a1++){
            try(BufferedReader bu =new BufferedReader(new FileReader(new File(list.get(a1))))){
                String read=null;
                while((read=bu.readLine())!=null){
                    if(read.equals("j")){
                        add();
                    }
                }
            }catch(Exception e1){

            }
        }
        long k1 = System.currentTimeMillis();
        System.out.println("종료");
        System.out.println(k1-k);
        System.out.println(a);
        System.out.println();
        a=0;
        Runnable r = () ->{
            try(BufferedReader bu =new BufferedReader(new FileReader(new File("test.txt")))) {
                String read=null;
                while((read=bu.readLine())!=null){
                    if(read.equals("j")){
                      add();
                    }
                }

            }catch (Exception e){
                System.out.println("s");
            }
        };
        Runnable r1 = () ->{
            try(BufferedReader bu =new BufferedReader(new FileReader(new File("test2.txt")))) {
                String read=null;
                while((read=bu.readLine())!=null){
                    if(read.equals("j")){
                        add();
                    }
                }

            }catch (Exception e){
                System.out.println("s1");

            }
        };
        Thread t = new Thread(r);
        Thread t1 = new Thread(r1);
        long s = System.currentTimeMillis();
        long s1=0;
        t.start();
        t1.start();
        try {
            t.join();
            t1.join();
            s1= System.currentTimeMillis();
        }catch (Exception e){

        }
        System.out.println(s1-s);
        System.out.println(a);
    }
    synchronized static void add(){
        a++;
    }
}

