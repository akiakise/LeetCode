package com.akiakise.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-list/
 */
public class P148_Sort_List {
    /*
    暴力解法，先将链表转为ArrayList，然后调 sort 方法，然后转回链表，非常暴力。。。
     */
    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while (tmp != null) {
            list.add(tmp.val);
            tmp = tmp.next;
        }
        list.sort(Comparator.naturalOrder());
        tmp = head;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                tmp.val = list.get(i);
                tmp.next = null;
            } else {
                tmp.val = list.get(i);
                tmp.next = new ListNode();
                tmp = tmp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        P148_Sort_List p = new P148_Sort_List();
        ListNode list1 = new ListNode(4);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(1);
        list1.next.next.next = new ListNode(3);
        ListNode h = p.sortList(list1);
        System.out.println(h);

        list1.val = -1;
        list1.next = new ListNode(5);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        list1.next.next.next.next = new ListNode(0);
        h = p.sortList(list1);
        System.out.println(h);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


