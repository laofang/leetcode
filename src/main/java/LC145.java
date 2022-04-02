import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode145题，二叉树的后序遍历
 * 关键字：栈、树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 左、右、根 的顺序，递归遍历即可
 */
public class LC145 {
    List list = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return list;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }
}
