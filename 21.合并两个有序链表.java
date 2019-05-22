/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        else if(l2==null) return l1;
        ListNode head = new ListNode(0);
        ListNode point = new ListNode(0);
        ListNode headl1 = new ListNode(0);
        headl1.next=l1;
        ListNode headl2 = new ListNode(0);
        headl2.next=l2;
        if(headl1.next.val<=headl2.next.val){
            point.next = headl1.next;
            head.next=headl1.next;
            headl1.next=headl1.next.next;
            point = point.next;
        }else{
            point.next = headl2.next;
            head.next=headl2.next;
            headl2.next=headl2.next.next;
            point = point.next;
        }
        while(headl1.next!=null&&headl2.next!=null){
            if(headl1.next.val<=headl2.next.val){
                point.next=headl1.next;
                headl1.next=headl1.next.next;
                point=point.next;
            }else{
                point.next=headl2.next;
                headl2.next=headl2.next.next;
                point=point.next;
            }
        }
        if(headl1.next!=null){
            point.next=headl1.next;
        }else if(headl2.next!=null){
            point.next=headl2.next;
        }
        return head.next;
    }
}

