package chap7;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache extends LinkedHashMap{
    public int number;

    public Cache(int number){
//        super(number);
        this.number=number;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > number;
    }
}
