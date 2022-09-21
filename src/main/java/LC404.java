import structure.TreeNode;

/**
 * Leetcode404题，左叶子之和
 * 关键字：树、深度优先搜索、广度优先搜索、二叉树
 * 主要思路：
 * 1. 树的遍历，如果是做叶子，则对节点的值进行累加。
 * 2. 遍历时，要传入当前节点是左节点，或是右节点，同时当前节点没有字节点。
 */
public class LC404 {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        search(root,false);
        return ans;
    }
    public void search(TreeNode root,boolean isLeft) {
        if(root == null) return;
        if(root.left == null && root.right == null && isLeft) ans += root.val;
        search(root.left,true);
        search(root.right, false);
    }
}
