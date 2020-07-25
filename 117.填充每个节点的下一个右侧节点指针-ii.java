/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    //遍历二叉树的第k层，相当于遍历二叉树根节点左右子节点的第k-1层
    //这个是常数空间复杂度层次遍历的思路
    //我们假设遍历的时候，左右节点内部会把next节点安排好
    //则遍历完唯一需要操作的就是该层左边最右边的节点和右边最左边的节点的连起来
    //connect函数返回的是根节点，我们需要创建一个按层遍历的connect函数connectByLevel
    public Node connect(Node root) {
        int deepth = countDeepth(root);
        if(deepth==0||deepth==1) return root;
        for (int i = 2; i <= deepth; i++) {
            Node leftNode = connectByLevel(root.left, true, i-1);
            Node rightNode = connectByLevel(root.right, false, i-1);
            if(leftNode!=null&&rightNode!=null) leftNode.next=rightNode;
        }
        return root;
    }

    public int countDeepth(Node root){
        if(root==null) return 0;
        else return 1+Math.max(countDeepth(root.left), countDeepth(root.right));
    }

    public Node connectByLevel(Node root,boolean isLeft,int level){
        if(root==null||level<=0) return null;
        if(level==1) return root;
        Node leftNode = connectByLevel(root.left, true, level-1);
        Node rightNode = connectByLevel(root.right, false, level-1);
        if(leftNode!=null&&rightNode!=null) leftNode.next=rightNode;
        //如果为左子树，返回最右侧节点，如果为右子树，返回最左侧节点
        return isLeft==true?findRightNode(root, level):findLeftNode(root, level);
    }

    public Node findLeftNode(Node root,int level){
        if(root==null) return null;
        else if(level==1) return root;
        else if(root.left==null&&root.right==null) return null;
        Node now = findLeftNode(root.left, level-1);
        return now!=null?now:findLeftNode(root.right, level-1);
    }

    public Node findRightNode(Node root,int level){
        if(root==null) return null;
        else if(level==1) return root;
        else if(root.left==null&&root.right==null) return null;
        Node now = findRightNode(root.right, level-1);
        return now!=null?now:findRightNode(root.left, level-1);
    }
}
// @lc code=end

