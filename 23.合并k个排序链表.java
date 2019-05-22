/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = lists[0];
        ListNode head = new ListNode(0);
        head.next=result;
        ListNode next = new ListNode(-1);
        next.next=result;
        while(next.next!=null){
            int now = next.next.val;
            for(int i=1;i<lists.length;i++){
                if(lists[i]==null) continue;
                else if(lists[i].val>=now){
                    ListNode node = new ListNode(lists[i].val);
                    node.next=next.next.next;
                    next.next.next=node;
                    lists[i].next=lists[i].next.next;
                }else if(lists[i].val<now){
                    if(next.next==result){
                        ListNode node = new ListNode(lists[i].val);
                        node.next=result;
                        head.next=node;
                    }else{
                        ListNode headnext = new ListNode(-1);
                        headnext.next=head.next;
                        while(headnext.next.next.val<lists[i].val){
                            headnext.next=headnext.next.next;
                        }
                        ListNode node = new ListNode(lists[i].val);
                        node.next=headnext.next.next;
                        headnext.next.next=node;
                    }
                    
                }
            }
            next.next = next.next.next;
        }
        return head.next;
    }
}

