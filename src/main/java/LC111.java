import structure.TreeNode;

/**
 * Leetcode111题，二叉树的最小深度
 * 关键字：树、二叉树、深度优先搜索、广度优先搜索
 * 主要思路：
 * 1. 左侧叶子最小深度和右侧叶子最小深度+1就是结果
 */
public class LC111 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0 && right != 0) return right + 1;
        if(left != 0 && right == 0) return left + 1;
        return Math.min(left,right) + 1;
    }
}
