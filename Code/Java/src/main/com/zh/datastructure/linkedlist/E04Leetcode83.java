package main.com.zh.datastructure.linkedlist;

public class E04Leetcode83 {
    //方法1
    public ListNode deleteDuplicates1(ListNode head) {
        //节点数<2
        if (head==null||head.next==null){
            return head;
        }
        //节点数>2
        ListNode p1 = head;
        ListNode p2;
        while ((p2=p1.next)!=null) {
            if (p2.val==p1.val){
                //删除p2
                p1.next=p2.next;
            }else {
                //向后平移
                p1=p1.next;
                p2=p2.next;
            }
        }
        return head;
    }

    //方法2
    public ListNode deleteDuplicates2(ListNode p){
        if (p==null||p.next==null){
            return p;
        }
        if (p.val==p.next.val){
            return deleteDuplicates2(p.next);
        }else {
            p.next=deleteDuplicates2(p.next);
            return p;
        }
    }
}
