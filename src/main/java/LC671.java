import structure.TreeNode;

/**
 * Leetcode671题，二叉树中第二小的节点
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1.
 */
public class LC671 {
    int min = Integer.MAX_VALUE;
    int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if(root != null) {
            if(root.val < min) {
                ans = min;
                min = root.val;
            }
            else if(root.val < ans && root.val > min) {
                ans = root.val;
            }
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
            return ans == Integer.MAX_VALUE? -1: ans;
        }
        return -1;
    }
}
