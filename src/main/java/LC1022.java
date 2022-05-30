import structure.TreeNode;

/**
 * Leetcode1022题，从根到叶的二进制之和
 * 关键字：树、深度优先搜素、二叉树
 * 主要思路：
 * 1. 递归，深度优先搜索，左子树右子树相加
 * 2. 记录上一层的值，每下一层上一层*2 + 当前层的值
 */
public class LC1022 {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root, int val) {
        if(root == null) {
            return 0;
        }
        val = (val << 1) | root.val;
        if(root.left == null && root.right == null) {
            return val;
        } else{
            return dfs(root.left,val) + dfs(root.right,val);
        }
    }
}
