package main.com.zh.datastructure.linkedlist;

/**
 * 检测链表是否有环
 */
public class E10Leetcode141 {
    public boolean hasCycle(ListNode head) {
        ListNode h = head; // 兔
        ListNode t = head; // 龟
        while (h != null && h.next != null) {
            t = t.next;
            h = h.next.next;
            if(h == t){
                return true;
            }
        }
        return false;
    }

}