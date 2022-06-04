import structure.TreeNode;

/**
 * Leetcode450题，删除二叉搜索树中的节点
 * 关键字：树、二叉树、二叉搜索树
 * 主要思路：
 * 1. 当前节点为null，返回null即可
 * 2. 当前节点非空时，与key相比存在三种情况
 *      1. root.val > key 说明删除的节点在root的左子树
 *      2. root.val < Key 说明删除的节点在root的右子树
 *      3. root.val == key 分为三种情况
 *          1. root的左子树为空，返回右子树
 *          2. root的右子树为空，返回左子树
 *          3. root的两个子树都存在，可以选左子树的根节点，代替当前节点位置，遍历左子树根节点，获取最右节点，将当前根节点的左子树接在最右节点的右侧；也可以选择右子树根节点替代当前根节点；
 */
public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        if(root.val > key) {
            root.left = deleteNode(root.left,key);
            return root;
        } else if(root.val < key) {
            root.right = deleteNode(root.right,key);
            return root;
        } else {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode temp = root.left;
            while(temp.right != null) {
                temp = temp.right;
            }
            temp.right = root.right;
            return root.left;
        }
    }
}
