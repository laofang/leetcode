import structure.TreeNode;

/**
 * Leetcode979题，在二叉树中分配硬币
 * 关键字：
 * 主要思路：
 * 1.
 */
public class LC979 {
    private int ans;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode node) {
        if (node == null)
            return 0;
        int d = dfs(node.left) + dfs(node.right) + node.val - 1;
        ans += Math.abs(d);
        return d;
    }
}
