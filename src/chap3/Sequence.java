package chap3;

public interface Sequence {
//    boolean hasNext();
    int next();
    default boolean hasNext(){
        return true;
    }
}
