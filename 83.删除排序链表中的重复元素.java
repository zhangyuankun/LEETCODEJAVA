/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode point = new ListNode(0);
        point.next=head;
        while(point.next.next!=null){
            if(point.next.val==point.next.next.val){
                point.next.next=point.next.next.next;
            }else{
                point.next=point.next.next;
            }
        }
        return head;
    }
}

