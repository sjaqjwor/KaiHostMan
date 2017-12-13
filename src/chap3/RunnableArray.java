package chap3;

public class RunnableArray {

    public static Runnable runnableArrayTest(Runnable...runnables){
        return ()->{
            for(Runnable runnable : runnables){
                runnable.run();
            }
        };

    }
}
