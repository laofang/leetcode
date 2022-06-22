import structure.TreeNode;

/**
 * Leetcode513题，找树左下角的值
 * 关键字：树、深度优先搜索、广度优先搜索、二叉树
 * 主要思路：
 * 1. 深度优先记忆化搜索，记录当前最大层次和当前答案，如果有更左更深层次则更新
 */
public class LC513 {
    int ans = 0;
    int maxLayer = 0;
    public int findBottomLeftValue(TreeNode root) {
        findBottomLeftValue(root,0);
        return ans;
    }

    public int findBottomLeftValue(TreeNode root, int layer) {
        if(root != null) {
            layer++;
            findBottomLeftValue(root.left,layer);
            if(layer > maxLayer) {
                ans = root.val;
                maxLayer = layer;
            }
            findBottomLeftValue(root.right,layer);
        }
        return 0;
    }
}
