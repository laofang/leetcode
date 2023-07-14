import structure.TreeNode;

/**
 * Leetcode979题，在二叉树中分配硬币
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 后序遍历，求出当前节点的子节点数量和当前硬币总量
 * 2. 如果硬币比节点数多，要把多的给父节点，如果比子节点少，要向父节点申请更多硬币
 */
public class LC979 {
    private int ans;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int[] dfs(TreeNode node) {
        if (node == null)
            return new int[]{0,0};
        int[] left = dfs(node.left);
        int[] right = dfs(node.left);
        int coins = left[0] + right[0] + node.val;
        int cnt = left[1] + right[1] + 1;
        ans += Math.abs(cnt - coins);
        return new int[]{coins,cnt};
    }
}
