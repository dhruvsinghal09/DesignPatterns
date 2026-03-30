package main.java.LLD.CustomHashMap;

public class MyHashMap<K,V>{

    private Entry<K,V>[] buckets;
    private int size;
    private int capacity;
    final static float loadFactor = 0.75f;

    public MyHashMap(int capacity){
        this.capacity=capacity;
        buckets=new Entry[capacity];
    }

    public V put(K key,V value){
        int index = hashFunction(key);
        Entry<K,V> entry = buckets[index];
        if(entry!=null){
            if(entry.key.equals(key)){
                entry.value=value;
            }
            entry=entry.next;
        }
        Entry<K,V> newEntry = new Entry<>(key,value);
        newEntry.next=buckets[index];
        buckets[index]=newEntry;
        size++;
        if((float)size/capacity>=loadFactor){
            resize();
        }
        return value;
    }

    public V get(K key){
        int index = hashFunction(key);
        Entry<K,V> entry = buckets[index];
        while(entry!=null){
            if(entry.key.equals(key))
                return entry.value;
            entry=entry.next;
        }
        return null;
    }

    private void resize(){
        capacity*=2;
        Entry<K,V>[] oldBuckets = buckets;
        buckets = new Entry[capacity];
        size=0;
        for(Entry<K,V> entry:oldBuckets){
            buckets[size++]=entry;
        }
    }

    private int hashFunction(K key){
        int hash = key.hashCode();
        return hash%capacity;
    }

    public boolean remove(K key){
        int index = hashFunction(key);
        Entry<K,V> entry = buckets[index];
        Entry<K,V> prev=null;
        while(entry!=null){
            if(entry.key.equals(key)){
                if(prev!=null){
                    prev.next=entry.next;
                }else{
                    buckets[index]=entry.next;
                }
                size--;
                return true;
            }
            prev=entry;
            entry=entry.next;
        }
        return false;
    }

    public boolean contains(K key){
        int index = hashFunction(key);
        Entry<K,V> entry = buckets[index];
        while(entry!=null){
            if(entry.key.equals(key))
                return true;
            entry=entry.next;
        }
        return false;
    }
}
