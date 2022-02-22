import structure.TreeNode;

/**
 * Leetcode110题，平衡二叉树
 * 关键字：树、二叉树、深度优先
 * 主要思路：
 * 1. 左右树的高度差小于1，且左右子树都是平衡树
 */
public class LC110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return  Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
