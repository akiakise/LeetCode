package com.akiakise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P869_Reordered_Power_Of_2 {
    /*
    因为涉及数字重排，我们可以先将 n 中所有的数字转换为 map，即 46 转换为：{4->1, 6->1}
    转换后我们发现，它和 64 转换来的 map {6->1, 4->1} 是相同的。

    假设 n 为 1204，则转换的 map 为 {1->1, 2->1, 0->1, 4->1}，
    而 1024 转换的 map 为 {1->1, 0->1, 2->1, 4->1}，和上述 map 也是相同的。

    问题是，给定 N，我们如何知道它在 46 时与 64 匹配，在 1204 时与 1024 匹配。

    题目限制了 N 为 int，且最大值为 10^9，int 的最大值为 2^32 - 1 = 2147483647。
    因为重排的数字需要是 2 的次方，且小于 10^9，则最大的次方数是 30。
        0. 10^9 = 1000000000
        1. 2^32 = 2147483648
        2. 2^31 = 1073741824
    遍历应该可行
     */
    public boolean reorderedPowerOf2(int N) {
        Map<Integer, Integer> numMap = toNumberMap(N);
        for (int i = 0; i < 31; i++) {
            Map<Integer, Integer> powMap = toNumberMap(1 << i);
            if (numMap.equals(powMap)) {
                return true;
            }
        }
        return false;
    }

    // Map 可以被优化为数组
    public Map<Integer, Integer> toNumberMap(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        while (N > 0) {
            int num = N % 10;
            map.put(num, map.getOrDefault(num, 0) + 1);
            N /= 10;
        }
        return map;
    }

    public static void main(String[] args) {
        P869_Reordered_Power_Of_2 p = new P869_Reordered_Power_Of_2();
        System.out.println(p.reorderedPowerOf2(1402));
    }
}
