import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        if(root.left==null||root.right==null){
            if(root.left==null&&root.right==null) return true;
            else return false;
        }else{
            if(root.left.val==root.right.val);
            else return false;
        }
        queue.add(root.left);
        queue.add(root.right);
        while(queue.size()!=0){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if(left.left==null||right.right==null){
                if(left.left==null&&right.right==null);
                else return false;
            }else{
                if(left.left.val==right.right.val){
                    queue.add(left.left);
                    queue.add(right.right);
                }
                else return false;
            }
            if(left.right==null||right.left==null){
                if(left.right==null&&right.left==null);
                else return false;
            }else{
                if(left.right.val==right.left.val){
                    queue.add(left.right);
                    queue.add(right.left);
                }
                else return false;
            }
        }
        return true;
    }
}

