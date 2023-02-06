import structure.TreeNode;

/**
 * Leetcode2331题，计算布尔二叉树的值
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 递归出口就是遍历到叶子节点，根据val返回bool值
 * 2. 非叶子几点进行递归和逻辑运算
 */
public class LC2331 {
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 0) return false;
        if(root.val == 1) return true;
        if(root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}
