package chap10;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Chap10Example2 {
    static volatile boolean done =false;
    public static void main(String arg[]){
        Runnable r = () ->{
            for(int i=0;i<=100;i++){
                System.out.println("hello"+i);
            };
            done=true;
        };
        Runnable r1 = ()->{
            int i=1;

            while(!done) i++;
            System.out.println("goodbye"+i);
        };
        Executor executor = Executors.newCachedThreadPool();
        executor.execute(r);
        executor.execute(r1);
    }
}
