import structure.TreeNode;

/**
 * Leetcode1026题，节点与其祖先之间的最大差值
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 一条从根到叶子节点的路径，最大差的绝对值，就是这条路径最大值节点和最小值节点的差
 * 2. 在遍历过程中保持一条路径的最大值和最小值，直到叶子节点时做差，根据大小更新结果
 */
public class LC1026 {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root,0,Integer.MAX_VALUE);
        return ans;
    }
    public void dfs(TreeNode root,int max,int min) {
        if(root == null) {
            ans = Math.max(ans,max-min);
        }
        if(root != null) {
            max = Math.max(max,root.val);
            min = Math.min(min,root.val);
            dfs(root.left,max,min);
            dfs(root.right,max,min);
        }
    }
}
