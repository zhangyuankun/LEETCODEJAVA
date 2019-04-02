/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 *
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * algorithms
 * Medium (32.30%)
 * Total Accepted:    34.8K
 * Total Submissions: 106.3K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 
 * 示例：
 * 
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 
 * 
 * 说明：
 * 
 * 给定的 n 保证是有效的。
 * 
 * 进阶：
 * 
 * 你能尝试使用一趟扫描实现吗？
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode fakehead = new ListNode(2);
        fakehead.next = head;
        a.next=fakehead;
        if(a.next.next.next==null){
            fakehead.next=null;
            return fakehead.next;
        }
        for(int i=0;i<n;i++){
            a.next = a.next.next;
        }
        b.next = fakehead;
        while(a.next.next!=null){
            a.next = a.next.next;
            b.next = b.next.next;
        }
        if(b.next.next.next!=null)b.next.next = b.next.next.next;
        else b.next.next=null;
        return fakehead.next;
    }
}

