import structure.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode590题，叉树的后序遍历
 * 关键字：树、叉树
 * 主要思路：
 * 1. 递归思想，先访问子树，再访问根
 * 2. 迭代思想，先进行压栈，然后逐一弹出访问即可
 */
public class LC590 {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return Collections.emptyList();
        }
        if(root.children != null) {
            for(Node node : root.children) {
                postorder(node);
            }
        }
        ans.add(root.val);
        return ans;
    }
}
