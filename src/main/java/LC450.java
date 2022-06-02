import structure.TreeNode;

/**
 * Leetcode450题，删除二叉搜索树中的节点
 * 关键字：树、二叉树、二叉搜索树
 * 主要思路：
 *
 */
public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode t = root.right;
            while (t.left != null) t = t.left;
            t.left = root.left;
            return root.right;
        } else if (root.val < key) root.right = deleteNode(root.right, key);
        else root.left = deleteNode(root.left, key);
        return root;
    }
}
