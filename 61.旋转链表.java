/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 *
 * https://leetcode-cn.com/problems/rotate-list/description/
 *
 * algorithms
 * Medium (37.30%)
 * Total Accepted:    10.2K
 * Total Submissions: 27.2K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 
 * 示例 1:
 * 
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 
 * 
 * 示例 2:
 * 
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;
        ListNode flag = new ListNode(-1);
        flag.next = head;
        ListNode virtul = new ListNode(1);
        ListNode til = new ListNode(0);
        til.next=head;
        int count=1;
        while(til.next.next!=null) {
            til.next=til.next.next;
            count++;
        }
        if(k%count==0) return head;
        for(int i=0;i<count-k%count-1;i++){
            if(flag.next.next!=null) flag.next=flag.next.next;
            else flag.next = head;
        }
        virtul.next = flag.next.next;
        til.next.next = head;
        flag.next.next = null;
        return virtul.next;
    }
}

