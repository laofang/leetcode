import structure.TreeNode;

/**
 * Leetcode617题，合并二叉树
 * 关键字：树、深度优先搜索、广度优先搜索、二叉树
 * 主要思路：
 * 1. 递归，首先根节点合并，根结点再连接合并后的左子树，和合并后的右子树
 */
public class LC617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 != null && root2 != null) {
            TreeNode root = new TreeNode();
            root.val = root1.val + root2.val;
            root.left = mergeTrees(root1.left,root2.left);
            root.right = mergeTrees(root1.right,root2.right);
            return root;
        } else if(root1 != null) {
            return root1;
        } else {
            return root2;
        }
    }
}

//TODO 逃课 LC1617题，统计子树中城市之间最大距离，困难,图结构的题，暂时先不做