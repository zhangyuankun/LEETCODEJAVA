/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (58.20%)
 * Total Accepted:    43.8K
 * Total Submissions: 73.8K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
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
    public ListNode reverseList(ListNode head) {
        ListNode flag = new ListNode(1);
        ListNode virtul = new ListNode(2);
        ListNode virtulhead = new ListNode(3);
        virtulhead.next=head;
        if(head==null||head.next==null) return head;
        virtul.next=virtulhead;
        flag.next=head.next;
        while(virtul.next.next!=null){
            virtul.next.next.next=flag.next.next;
            flag.next.next=virtul.next.next;
            virtul.next.next=flag.next;
            if(virtul.next.next.next!=null||flag.next.next.next!=null){
                virtul.next=virtul.next.next.next;
                flag.next=flag.next.next.next;
            }
            else break;
        }
        return virtulhead.next;
    }
}

