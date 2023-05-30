import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode1110题，删点成林
 * 关键字：树、深度优先搜索、数组、哈希表、二叉树
 * 主要思路：
 * 1. 通过后序遍历，删除获得子树
 */
public class LC1110 {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<Integer>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        List<TreeNode> roots = new ArrayList<TreeNode>();
        dfs(root, true, toDeleteSet, roots);
        return roots;
    }

    public TreeNode dfs(TreeNode node, boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> roots) {
        if (node == null) {
            return null;
        }
        boolean deleted = toDeleteSet.contains(node.val);
        node.left = dfs(node.left, deleted, toDeleteSet, roots);
        node.right = dfs(node.right, deleted, toDeleteSet, roots);
        if (deleted) {
            return null;
        } else {
            if (isRoot) {
                roots.add(node);
            }
            return node;
        }
    }
}
