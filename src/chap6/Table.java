package chap6;


import java.util.ArrayList;
import java.util.Map;

public class Table<K,V> {


    private ArrayList<Entry> list = new ArrayList<>();
    public Table(){

    }

    public V getValue(K k){
        V v=null;
            for(Entry entry : list){
                if(entry.getKey().equals(k)){
                    v=entry.getValue();
                }
            }
            return v;
    }

    public void put(K key ,V value ){
        Entry entry = new Entry(key,value);
        if (!list.contains(entry)){
            list.add(entry);
        }
    }

    public void remove(K key){
        int count=0;
        for(Entry entry : list){
            if(entry.getKey().equals(key)){
              break;
            }
            count++;
        }
        list.remove(count);
    }
    private class Entry{
        private K key;
        private V value;

        public Entry(K key,V value){
            this.key=key;
            this.value=value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
    }

}
