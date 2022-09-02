import structure.TreeNode;

/**
 * Leetcode687题，最长同值路径
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 使用递归方法
 * 2. 每次方法算出当前根节点的单分支最长路径，和当前同值路径
 */
public class LC687 {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        f(root);
        return max;
    }
    public int f(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        int cnt = 0;
        int left = f(root.left);
        int right = f(root.right);
        if(root.left != null && root.val == root.left.val) {
            ans = left + 1;
            cnt += left+1;
        }
        if(root.right != null && root.val == root.right.val) {
            ans = Math.max(ans,right + 1);
            cnt += right+1;
        }
        max = Math.max(max,cnt);
        return ans;
    }
}
