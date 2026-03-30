package main.java.LLD.CustomHashMap;

public class Main {

    public static void main(String[] args){
        MyHashMap<Integer,String> hm = new MyHashMap<>(12);
        hm.put(1,"Dhruv");
        hm.put(2,"Mayank");
        hm.put(3,"Singhal");
        hm.put(4,"Pratap");
        System.out.println(hm.get(1));
        System.out.println(hm.get(2));
        System.out.println(hm.get(4));
        System.out.println(hm.remove(4));
        System.out.println(hm.get(4));
    }
}
