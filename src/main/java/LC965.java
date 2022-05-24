import structure.TreeNode;

/**
 * Leetcode965题，单值二叉树
 * 关键字：树、深度优先搜索、广度优先搜索、二叉树
 * 主要思路：
 * 1. 递归实现，左子树是单值二叉树，且右子树是单值二叉树，且根的值与左子树和右子树的值相等
 */
public class LC965 {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        boolean flag;
        if(root.left != null && root.right != null) {
            flag = root.val == root.left.val && root.val == root.right.val;
        } else if(root.left != null) {
            flag = root.val == root.left.val;
        } else if(root.right != null) {
            flag = root.val == root.right.val;
        } else {
            return true;
        }
        return flag && isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}
