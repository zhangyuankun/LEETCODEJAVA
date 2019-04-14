package com.zyk;

/**
 * Hello world!
 *
 */
public class App 
{
    static class Solution {
        static public ListNode addTwoNumbers(ListNode l1, ListNode l2){
            if(l1==null) return l2;
            if(l2==null) return l1;
            ListNode result = new ListNode(l1.val+l2.val);
            result.next = addTwoNumbers(l1.next, l2.next);
            if(result.next.val>10){
                result.next.val-=10;
                result.val++;
            }
            return result;
        }
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        a.next=b;
        b.next=c;
        d.next=e;
        e.next=f;
        System.out.println(Solution.addTwoNumbers(a,d));
    }
    
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}