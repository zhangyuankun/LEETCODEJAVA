/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (32.77%)
 * Total Accepted:    90K
 * Total Submissions: 273.8K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }-----------------------------------------------------------------------------------
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1==null) {
            if(l2!=null)return l2;
            else return null;
        }
        if(l2==null) return l1;
        ListNode result = new ListNode(0);
        ListNode head = new ListNode(0);
        ListNode l1n = new ListNode(0);
        l1n.next = l1;
        ListNode l2n = new ListNode(0);
        l2n.next = l2;
        head.next=result;
        while(l1n.next!=null&&l2n.next!=null){
            ListNode next = new ListNode(0);
            head.next.val+=l1n.next.val+l2n.next.val;
            if(head.next.val>=10){
                head.next.val-=10;
                next.val++;
            }
            if(l1n.next.next!=null&&l2n.next.next!=null){
                head.next.next = next;
                head.next=head.next.next;
            }
            if(l1n.next.next==null&&l2n.next.next==null&&next.val!=0){
                head.next.next = next;
                head.next=head.next.next;
            }
            if(l1n.next.next==null&&l2n.next.next!=null){
                head.next.next=l2n.next.next;
                if(next.val!=0){head.next.next.val++;}
                while(head.next.next.val>=10){
                    head.next.next.val-=10;
                    if(head.next.next.next!=null){
                        head.next.next.next.val++;
                        head.next=head.next.next;
                    }else{
                        ListNode newNext = new ListNode(1);
                        head.next.next.next = newNext;
                    }
                }
            }else if(l1n.next.next!=null&&l2n.next.next==null){
                head.next.next=l1n.next.next;
                if(next.val!=0){head.next.next.val++;}
                while(head.next.next.val>=10){
                    head.next.next.val-=10;
                    if(head.next.next.next!=null){
                        head.next.next.next.val++;
                        head.next=head.next.next;
                    }else{
                        ListNode newNext = new ListNode(1);
                        head.next.next.next = newNext;
                    }
                }
            }
            l1n.next = l1n.next.next;
            l2n.next = l2n.next.next;
        }
        return result;
    }
}

