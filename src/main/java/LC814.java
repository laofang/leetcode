import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode814题，二叉树剪枝
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 如果当前根的左子树和为0，则左子树为null，右子树同理
 * 2. 计算每个子树的和，可以用map进行记忆化遍历
 */
public class LC814 {
    public TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        if(sum(root.left) == 0){
            root.left = null;
        } else {
            pruneTree(root.left);
        }
        if(sum(root.right) == 0){
            root.right = null;
        } else {
            pruneTree(root.right);
        }
        if(root.left == null && root.right == null && root.val == 0) {
            return null;
        }
        return root;

    }
    Map<TreeNode,Integer> map = new HashMap<>();
    public int sum(TreeNode root) {
        if(root == null) return 0;
        if(map.get(root) != null) return map.get(root);
        Integer sum = root.val + sum(root.left) + sum(root.right);
        if(map.get(root) == null) map.put(root,sum);
        return sum;
    }
}
