package chap5;

import java.util.concurrent.locks.ReentrantLock;

public class HelperClass implements AutoCloseable{

    ReentrantLock reentrantLock;

    @Override
    public void close(){
        reentrantLock.unlock();
    }

    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }
}
