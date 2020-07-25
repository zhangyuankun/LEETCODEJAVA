/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 */

// @lc code=start
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
    public List<List<Integer>> zigzagLevelOrder(final TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        final Deque<TreeNode> deque = new LinkedBlockingDeque<>();
        deque.add(root);
        boolean inorder = true;
        int countLastLevel = 1;
        while (!deque.isEmpty()) {
            int countNowLevel = 0;
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < countLastLevel; i++) {
                if (inorder == true) {
                    final TreeNode nodeNow = deque.pollFirst();
                    levelResult.add(nodeNow.val);
                    if (nodeNow.left != null) {
                        deque.addLast(nodeNow.left);
                        countNowLevel++;
                    }
                    if (nodeNow.right != null) {
                        deque.addLast(nodeNow.right);
                        countNowLevel++;
                    }
                } else {
                    final TreeNode nodeNow = deque.pollLast();
                    levelResult.add(nodeNow.val);
                    if(nodeNow.right!=null){
                        deque.addFirst(nodeNow.right);
                        countNowLevel++;
                    }
                    if(nodeNow.left!=null){
                        deque.addFirst(nodeNow.left);
                        countNowLevel++;
                    }
                }
            }
            result.add(levelResult);
            levelResult=new ArrayList<>();
            countLastLevel=countNowLevel;
            inorder = !inorder;
        }
        return result;
    }
}
// @lc code=end

