package com.akiakise.leetcode;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/
 */
public class P1262 {
    /*
    贪心算法，时间复杂度 O(n)。
    结果：耗时 3ms，比 99.48% 的 Java 解法快。

    1. 首先求出所有数字的和，在求和的过程中，记录下所有数字中模3余1的最小值和次小值，
    同时记录下所有数字中模3余2的最小值和次小值。
    2.1 求和结束后，如果总和模3余1，则去掉一个模3余1的数字或者两个模3余2的数字，即可得到最大可被3整除的和。
    2.2 求和结束后，如果总和模3余2，则去掉两个模3余1的数字或者一个模3余2的数字，即可得到最大可被3整除的和。
    2.3 求和结束后，如果总和可以被3整除，则直接返回。
     */
    public int maxSumDivThree(int[] nums) {
        int max = 100000;
        int sum = 0;
        int mod1_first = max, mod1_second = max;
        int mod2_first = max, mod2_second = max;

        for (int num : nums) {
            sum += num;

            int mod = num % 3;
            if (mod == 1) {
                if (num < mod1_second) {
                    mod1_first = mod1_second;
                    mod1_second = num;
                } else if (num < mod1_first) {
                    mod1_first = num;
                }
            } else if (mod == 2) {
                if (num < mod2_second) {
                    mod2_first = mod2_second;
                    mod2_second = num;
                } else if (num < mod2_first) {
                    mod2_first = num;
                }
            }
        }

        int mod = sum % 3;
        if (mod == 1) {
            return sum - Math.min(mod1_second, mod2_second + mod2_first);
        }
        if (mod == 2) {
            return sum - Math.min(mod1_first + mod1_second, mod2_second);
        }
        return sum;
    }

    public static void main(String[] args) {
        P1262 p = new P1262();
        System.out.println(p.maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(p.maxSumDivThree(new int[]{4}));
        System.out.println(p.maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }
}
