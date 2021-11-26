import structure.TreeNode;

/**
 * Leetcode700题，二叉搜索树中的搜索
 * 关键字：树、搜索树、二叉搜索树、递归
 * 主要思路：
 * 1. 递归搜索即可，比当前的小，走左子树，比当前的大，走右子树，相等放回即可，到了叶子也没有，返回null
 */
public class LC700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        } else if(val < root.val) {
            return searchBST(root.left,val);
        } else {
            return searchBST(root.right,val);
        }
    }
}
