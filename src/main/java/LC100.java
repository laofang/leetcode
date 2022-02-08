import structure.TreeNode;

/**
 * Leetcode100题，相同的树
 * 关键字：树、二叉树、广度优先搜索、深度优先搜索
 * 主要思想：
 * 1. 深度优先搜索，如果两个树的根结点相等，左子树相等，右子树相等，那么两棵树相等
 * 2. 广度优先搜索，如果两棵树的每层相等，则两棵树相等
 */
public class LC100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //如果两个结点都空，那么就相等了
        if( p == null && q == null) {
            return true;
            //如果不空，且值相等，就再比较左子树和右子树，都相等就相等
        } else if(p != null && q != null && p.val == q.val) {
            return (isSameTree(p.left,q.left) && isSameTree(p.right,q.right));
            //其他情况都不等
        } else {
            return false;
        }
    }
}
