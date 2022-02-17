import structure.TreeNode;

/**
 * Leetcode104题，二叉树的最大深度
 * 关键字：二叉树、递归
 * 主要思路：
 * 1. 一棵树的深度，等于它左子树和右子树更深的一个 + 1（根结点所在的层）
 */
public class LC104 {
    public int maxDepth(TreeNode root) {
        if(root == null ) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
