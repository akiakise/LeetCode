package com.akiakise.leetcode;

import java.util.Arrays;

public class P1362_ClosestDivisors {
    /*
    给定一个n，我们先求出 t=sqrt(n+2)，假设返回结果数组为 [a, b]，
    则这个关系一定成立： a <= t <= b。

    因为：
        1. a * b = n
        2. t * t = n
    则我们可以从 t 开始，向前或者向后进行搜索。

    结果：
        - 向前搜索 5ms，37.1MB
        - 向后搜索 1300ms，36.9MB
    出现这样的结果是因为 t 与 0 非常接近，与 n+2 非常远，向后搜索多了非常多无用的判断。

    比如，n=99，则 n+2=101，t≈10.05，从 t 到 0 只需要检测 10 个数字，从 t 到 101
    需要检测 90 个数字，数量多了 9 倍。
     */
    public int[] closestDivisors(int num) {
        int n1 = num + 1;
        int n2 = num + 2;
        int floor = (int) Math.floor(Math.sqrt(num + 2));
        int[] res = {0, 0};
        while (floor > 0) {
            if (n1 % floor == 0) {
                return new int[]{floor, n1 / floor};
            }
            if (n2 % floor == 0) {
                return new int[]{floor, n2 / floor};
            }

            floor--;
        }
        return res;
    }

    public static void main(String[] args) {
        P1362_ClosestDivisors p = new P1362_ClosestDivisors();
        System.out.println(Arrays.toString(p.closestDivisors(2)));
        System.out.println(Arrays.toString(p.closestDivisors(8)));
        System.out.println(Arrays.toString(p.closestDivisors(123)));
        System.out.println(Arrays.toString(p.closestDivisors(999)));
    }
}
