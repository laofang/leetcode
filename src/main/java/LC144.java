import structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode144题，二叉树的前序遍历
 * 关键字：栈、树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 根、左、右 的顺序，递归遍历即可
 */
public class LC144 {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return ans;
        }
        ans.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return ans;
    }
}
