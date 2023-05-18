import structure.TreeNode;

/**
 * Leetcode938题，二叉搜索树的范围和
 * 关键字：树、深度优先搜索、二叉搜索树、二叉树
 * 主要思路：
 * 1. 树的遍历，顺便求和
 */
public class LC938 {
    int ans = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return ans;
        if(root.val >= low && root.val <= high) {
            ans += root.val;
        }
        rangeSumBST(root.left,low,high);
        rangeSumBST(root.right,low,high);
        return ans;
    }
}
