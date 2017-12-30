package chap6;


import java.util.ArrayList;
import java.util.Map;

public class Table<K,V> {


    private ArrayList<Entry> list = new ArrayList<>();
    public Table(){

    }

    public V getValue(K k){
            for(Entry entry : list){
                if(entry.getKey().equals(k)){
                    return entry.getValue();
                }
            }
            return null;
    }

    public void put(K key ,V value ){
        for(Entry e : list){
            if(e.getKey().equals(key)){
                e.setValue(value);
                return;
            }
        }
        list.add(new Entry(key,value));
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
        public void setValue(V v){
           this.value=v;
        }
        public void setKey(K k){
            this.key=k;
        }
    }

}
