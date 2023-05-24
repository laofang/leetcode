import structure.TreeNode;

/**
 * Leetcode993题，二叉树堂兄弟节点
 * 关键字：树、深度优先搜索、广度优先搜索
 * 主要思路：
 * 1. 找到两个指定节点的父节点
 * 2. 父节点的深度相同，但彼此的父节点不相同
 */
public class LC993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xNode = search(root,x);
        TreeNode yNode = search(root,y);
        return xNode != null && yNode != null && xNode != yNode && xNode.val == yNode.val;

    }
    public TreeNode search(TreeNode root,int val) {
        if(root == null) return null;
        if(root.left != null && root.left.val == val) {
            root.val = 0;
            return root;
        }
        if(root.right != null && root.right.val == val) {
            root.val = 0;
            return root;
        }
        TreeNode l = null;
        TreeNode r = null;

        l = search(root.left,val);

        r = search(root.right,val);

        if(l == null && r == null) return null;
        if(l != null) {
            l.val += 1;
            return l;
        }
        if(r != null) {
            r.val += 1;
            return r;
        }
        return null;
    }
}
