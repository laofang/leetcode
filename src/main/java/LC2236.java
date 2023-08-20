import structure.TreeNode;

/**
 * Leetcode2236题，判断根节点是否等于子节点之和
 * 关键字：树、二叉树
 * 主要思路：
 * 1. 也是相当简单的题目了
 */
public class LC2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
