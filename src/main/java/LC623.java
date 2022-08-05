import structure.TreeNode;

/**
 * Leetcode623题，在二叉树中增加一行
 * 关键字：树、二叉树、广度优先搜索、深度优先搜索
 * 主要思路：
 * 1. 深度优先搜索，查到n-1层的节点时，对当前节点增加新节点
 */
public class LC623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        search(root,depth,val,1);
        return root;
    }
    public void search(TreeNode root,int depth,int val,int curDepth) {
        if(root == null) return;
        if(curDepth == depth - 1) {
            TreeNode lNode = new TreeNode(val);
            TreeNode rNode = new TreeNode(val);
            lNode.left = root.left;
            rNode.right = root.right;
            root.left = lNode;
            root.right = rNode;
            return;
        }
        search(root.left,depth,val,curDepth + 1);
        search(root.right,depth,val,curDepth + 1);
        return;
    }
}
