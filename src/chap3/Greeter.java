package chap3;

public class Greeter implements Runnable{

    private int n;
    private int target;

    public Greeter(int n, int target){
        this.n=n;
        this.target=target;
    }
    @Override
    public void run(){
        System.out.print("hello"+this.n+" "+this.target );
    }

    public static void runTogeter(Runnable...runnables){
        for(Runnable runnable : runnables){
            new Thread(runnable).start();
        }
    }

    public static void runInOrder(Runnable... runnables){
        for(Runnable runnable : runnables){
            runnable.run();
        }
    }


}
