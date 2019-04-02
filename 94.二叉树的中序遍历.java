/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (64.08%)
 * Total Accepted:    24K
 * Total Submissions: 37.2K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
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
    public List<Integer> inorderTraversal(TreeNode root) {
        // List<Integer> result = new ArrayList<Integer>();
        // if(root==null) return result;
        // if(root.left!=null) result.addAll(inorderTraversal(root.left));
        // result.add(root.val);
        // if(root.right!=null) result.addAll(inorderTraversal(root.right));
        // return result;
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> resultStack = new Stack<>();
        TreeNode flag = root;
        while(flag!=null||!resultStack.isEmpty()){
            if(flag!=null){
                resultStack.push(flag);
                flag = flag.left;
            }
            else{
                TreeNode nood = resultStack.pop();
                result.add(nood.val);
                flag=nood.right;
            }
        }
        return result;
    }
}

