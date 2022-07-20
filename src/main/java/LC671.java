import structure.TreeNode;

/**
 * Leetcode671题，二叉树中第二小的节点
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 中序遍历，两个变量一个存最小值，一个存次小值
 */
public class LC671 {
    int min = -1;
    int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if(root != null) {
            if(root.val < min || min == -1) {
                ans = min;
                min = root.val;
            }
            else if(root.val > min && (root.val < ans || ans == -1)) {
                ans = root.val;
            }
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
            return ans;
        }
        return -1;
    }
}
