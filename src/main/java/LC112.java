import structure.TreeNode;

/**
 * Leetcode112题，路径总和
 * 关键字：树、二叉树、递归、深度优先搜索、广度优先搜索
 * 主要思路：
 * 1. root->leaf的总和 == target
 * 2. 查看是否存在 root.left -> leaf的总和==target - root.val或root.right ->leaf的总和==target - root.val
 * 3. 递归下去，直到leaf节点的值==target - allParents.val，返回true
 * 4. 若是null节点返回false
 */
public class LC112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(root.left,targetSum - root.val)||
                hasPathSum(root.right,targetSum - root.val);
    }
}
