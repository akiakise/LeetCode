package com.akiakise.leetcode;


import java.util.HashMap;
import java.util.Map;

class MyHashMap {
    private Map<Integer, Integer> map;

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        map = new HashMap<>();
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        map.put(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        map.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
public class P706_Design_HashMap {
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.remove(27);
        map.put(65, 65);
        map.remove(19);
        map.remove(0);
        System.out.println(map.get(18));
        ;
        map.remove(3);
        map.put(42, 0);
        System.out.println(map.get(19));
        ;
        map.remove(42);
        map.put(17, 90);
        map.put(31, 76);
        map.put(48, 71);
        map.put(5, 50);
        map.put(7, 68);
        map.put(73, 74);
        map.put(85, 18);
        map.put(74, 95);
        map.put(84, 82);
        map.put(59, 29);
        map.put(71, 71);
        map.remove(42);
        map.put(51, 40);
        map.put(33, 76);
        System.out.println(map.get(17));
        ;
        map.put(89, 95);
        System.out.println(map.get(95));
        ;
        map.put(30, 31);
        map.put(37, 99);
        System.out.println(map.get(51));
        ;
        map.put(95, 35);
        map.remove(65);
        map.remove(81);
        map.put(61, 46);
        map.put(53, 33);
        System.out.println(map.get(59));
        map.remove(5);
    }
}
