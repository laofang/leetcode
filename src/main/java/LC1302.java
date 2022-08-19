import structure.TreeNode;

/**
 * Leetcode1302题，层数最深叶子节点的和
 * 关键字：树、深度优先搜索、广度优先搜索、二叉树
 * 主要思路：
 * 1. 采用深度优先搜索，使用带层次的前序遍历
 * 2. 使用hash存储同层次叶子节点的和，同时更新最深层次
 * 3. 最后从hash获取最深层次叶子节点的和
 */
public class LC1302 {
    int maxLayer = 0;
    int[] sum = new int[10000];
    public int deepestLeavesSum(TreeNode root) {
        leafSum(root,1);
        return sum[maxLayer];
    }
    public void leafSum(TreeNode root, int layer) {
        if(root == null) return;
        if(root. left == null && root.right == null) {
            sum[layer] += root.val;
            maxLayer = Math.max(maxLayer,layer);
        }
        leafSum(root.left,layer+1);
        leafSum(root.right,layer+1);
    }
}
