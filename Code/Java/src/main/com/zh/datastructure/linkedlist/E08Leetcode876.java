package main.com.zh.datastructure.linkedlist;

public class E08Leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        return p1;
    }
}
