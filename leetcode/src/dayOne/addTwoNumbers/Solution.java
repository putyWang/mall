/*
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * */

package dayOne.addTwoNumbers;

import base.linkList.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode l3 = l2;
        while(l1.next != null && l2.next != null){
            sum = l1.val + l2.val + sum;
            l2.val = sum % 10;
            if(sum / 10 != 0){
                sum = sum/10;
            }else
                sum = 0;
            l2 = l2.next;
            l1 = l1.next;
        }
        sum = l1.val + l2.val + sum;
        l2.val = sum % 10;
        if(sum / 10 != 0){
            sum = sum/10;
        }else
            sum = 0;
        while(l2.next != null){
            sum = sum + l2.next.val;
            l2.next.val = sum % 10;
            if(sum / 10 != 0){
                sum = sum/10;
            }
            l2 = l2.next;
        }
        while(l1.next != null){
            sum = sum + l1.next.val;
            l2.next = new ListNode(sum % 10);
            if(sum / 10 != 0){
                sum = sum/10;
            }else
                sum = 0;
            l2 =l2.next;
            l1 = l1.next;
        }
        if(sum != 0)
            l2.next = new ListNode(sum);
        return l3;
    }

}
