import structure.TreeNode;

/**
 * Leetcode669题，修剪二叉搜索树
 * 关键字：树、深度优先搜索、二叉搜索树、二叉树
 * 主要思路：
 * 1. 使用递归方法
 * 2. 如果当前节点的值，在限制之间，分别获取剪枝后的左子树，剪枝后的右子树
 * 3. 如果当前节点的值在限制之外
 *      1. root.val < low，剪掉左子树，并获取剪枝后的右子树
 *      2. root.val > high，剪掉右子树，并获取剪枝后的左子树
 */
public class LC669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(low <= root.val && root.val <= high) {
            root.left = trimBST(root.left,low,high);
            root.right = trimBST(root.right,low,high);
            return root;
        } else if(root.val < low) {
            return trimBST(root.right,low,high);
        } else {
            return trimBST(root.left,low,high);
        }
    }
}
