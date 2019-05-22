/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        else return(Math.max((root.left!=null)?maxDepth(root.left):0,(root.right!=null)?maxDepth(root.right):0)+1);
    }
}

