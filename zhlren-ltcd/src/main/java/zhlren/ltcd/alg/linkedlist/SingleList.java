package zhlren.ltcd.alg.linkedlist;

/**
 * Created by bjrenzhili on 17/4/10.
 */
public class SingleList {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    public ListNode reverse(ListNode head){
        if (null == head || null == head.next){
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = pre;

            pre =cur;
            cur=next;
        }
        head.next = null;
        head=pre;
        return head;
    }

}
