package com.akiakise.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 */
public class P1481 {
    /*
    因为需要统计移除
     */
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (k == 0) {
            return map.size();
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().parallelStream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        int size = map.size();
        int i = 0;
        while (k-- > 0) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            if (entry.getValue() == 1) {
                ++i;
                --size;
            } else {
                entry.setValue(entry.getValue() - 1);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        P1481 p = new P1481();
        System.out.println(p.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(p.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));
        System.out.println(p.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 2));
        System.out.println(p.findLeastNumOfUniqueInts(new int[]{1}, 1));
        System.out.println(p.findLeastNumOfUniqueInts(new int[]{3, 3, 3, 4, 4, 4, 4}, 3));
    }
}
