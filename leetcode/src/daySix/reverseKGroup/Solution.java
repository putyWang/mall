/*给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
k是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。*/


package daySix.reverseKGroup;

import base.ListNode;


public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(null == head.next){
            return head;
        }
        if(k == 1)
            return head;
        ListNode end = head.next;
        ListNode temp = new ListNode();
        head.next = null;
        int count = 0;
        ListNode head1 = head;
        for (int i = 0; i < k - 1; i++) {
            if(null != end.next){
                temp = end.next;
                end.next = head;
                head = end;
                end = temp;
                count ++;
            }
        }
        if(count == k - 1){
            head1.next = reverseKGroup(end,k);
        }else if(count == k - 2) {
            end.next = head;
            head = end;
        }else {
            while (null != head.next){
                temp = head.next;
                head.next = end;
                end = head;
                head = temp;
            }
            head.next = end;
        }
        return head;
    }
}
