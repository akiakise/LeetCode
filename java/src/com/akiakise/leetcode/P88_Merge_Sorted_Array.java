package com.akiakise.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class P88_Merge_Sorted_Array {
    /*
    两个有序列表的合并，需要将 nums2 合并到 nums1 中，直接往 nums1 中插入会涉及到列表元素迁移，
    是耗时操作。我们可以考虑用空间换时间，新建一个临时列表用于合并，合并完成后再将临时列表的内容回写到 nums1。

    结果：0ms，比 100% 的 Java 解法快。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        if (n == 0) {
            return;
        }
        int[] res = new int[nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                res[k++] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                res[k++] = nums2[j++];
            } else {
                res[k++] = nums1[i++];
            }
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];
        }

        System.arraycopy(res, 0, nums1, 0, res.length);
    }

    public static void main(String[] args) {
        P88_Merge_Sorted_Array p = new P88_Merge_Sorted_Array();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        p.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{1};
        p.merge(nums1, 1, new int[]{}, 0);
        System.out.println(Arrays.toString(nums1));

        nums1 = new int[]{0};
        p.merge(nums1, 0, new int[]{1}, 1);
        System.out.println(Arrays.toString(nums1));
    }
}
