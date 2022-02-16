import structure.TreeNode;

/**
 * Leetcode101题，对称二叉树
 * 关键字：二叉树、对称、递归、深度优先搜索、广度优先搜索
 * 主要思路：
 * 1. 如果一个二叉树轴对称，则左右两棵子树有如下特点
 * 2. 左子树的根结点与右子树根结点相等
 * 3. 左子树的左子树的根节点 == 右子树的右子树的根结点 && 左子树的右子树的根结点 == 右子树的左子树的根结点
 * 4. 递归下去
 */
public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        return leftEqualRight(root.left,root.right);
    }

    private boolean leftEqualRight(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if(left == null && right != null || left != null && right == null) {
            return false;
        } else if(left.val == right.val){
            return leftEqualRight(left.left,right.right) && leftEqualRight(left.right,right.left);
        } else {
            return false;
        }
    }
}
