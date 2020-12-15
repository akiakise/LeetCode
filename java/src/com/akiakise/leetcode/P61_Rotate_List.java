package com.akiakise.leetcode;

public class P61_Rotate_List {
    /*
    https://leetcode.com/problems/rotate-list/

    假设链表为 1->2->3->4->5，总数 n=5
             ⬆           ⬇
             ------------
    k = 1 时，head.prev = 4，从 head 移动到 head.prev 需要 3 步
    k = 2 时，head.prev = 3，从 head 移动到 head.prev 需要 2 步
    k = 3 时，head.prev = 2，从 head 移动到 head.prev 需要 1 步
    k = 4 时，head.prev = 1，从 head 移动到 head.prev 需要 0 步
    k = 5 时，head.prev = 5，从 head 移动到 head.prev 需要 4 步
    k = 6 时，head.prev = 4，从 head 移动到 head.prev 需要 3 步
    则，i = n - k % n，从 head 移动到 i 需要 i-1 步
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (k == 0) {
            return head;
        }
        ListNode _head = head;
        ListNode node = head;
        int n = 1;
        while (node.next != null) {
            node = node.next;
            n++;
        }
        node.next = _head;

        int i = n - k % n;
        while (i-- > 1) {
            _head = _head.next;
        }
        head = _head.next;
        _head.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        P61_Rotate_List p = new P61_Rotate_List();
        ListNode res_head = p.rotateRight(head, 2);
        System.out.println(res_head.val);
    }

    static class ListNode {
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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}