/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (57.34%)
 * Total Accepted:    16.1K
 * Total Submissions: 27.7K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例:
 * 
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * 
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
    public ListNode swapPairs(ListNode head) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode virtulhead = new ListNode(0);
        if(head==null||head.next==null) return head;
        virtulhead.next = head;
        a.next = virtulhead;
        b.next = virtulhead.next;
        while(true){
            a.next.next=b.next.next;
            b.next.next=a.next.next.next;
            a.next.next.next=b.next;
            if(b.next.next==null||b.next.next.next==null) break;
            a.next = a.next.next.next;
            b.next=b.next.next;
        }
        return virtulhead.next;
    }
}

