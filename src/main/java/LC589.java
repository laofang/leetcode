import structure.Node;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode589题，叉树的前序遍历
 * 关键字：树、深度优先、广度优先
 * 主要思路：
 * 1. 可以用栈模拟迭代过程
 * 2. 递归只要深度优先搜索即可
 */
public class LC589 {
    public List<Integer> preorder(Node root) {

        if(root == null) return Collections.emptyList();

        List<Integer> ans = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.poll();
            ans.add(cur.val);
            if(cur.children != null ) {
                for(int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.push(cur.children.get(i));
                }
            }
        }
        return ans;
    }
}
