import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层次遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue = new LinkedBlockingQueue();
        queue.add(root);
        while(queue.size()!=0){
            List<Integer> resultm = new ArrayList<>();
            Integer size = queue.size();
            for(int i=0;i<size;i++){ 
                TreeNode node = queue.poll();
                resultm.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            result.add(resultm);
        }
        return result;
    }
}

