import structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode94题，二叉树的中序遍历
 * 关键字：树、遍历、中序遍历
 * 主要思路：
 * 1. 就是树的中序遍历，左 中 右的顺序
 */
public class LC94 {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null) {
            inorderTraversal(root.left);
            ans.add(root.val);
            inorderTraversal(root.right);
        }
        return ans;
    }
}
