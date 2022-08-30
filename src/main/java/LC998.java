import structure.TreeNode;

/**
 * Leetcode998题，最大二叉树II
 * 关键字：树、二叉树
 * 主要思路：
 * 1. 可以递归，也可以迭代，我选择递归的方式
 * 2. 始终走右子树，直到找到一个比给定值小的当前节点，或者走到末尾，添加新节点
 */
public class LC998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        TreeNode cur = new TreeNode(val);
        if(root == null) return cur;
        if(root.val < cur.val) {
            cur.left = root;
            return cur;
        }
        root.right = insertIntoMaxTree(root.right,val);
        return root;
    }
}
