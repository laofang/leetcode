import structure.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode429题，叉树的层序遍历
 * 关键字：树、广度优先搜索
 * 主要思路：
 * 1. 就是一个广度优先搜索，每一层有一个隔断的标致，如null
 */
public class LC429 {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return Collections.emptyList();
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty() && queue.size() > 1) {
            List<Integer> result = new ArrayList<>();
            while(queue.peek() != null) {
                Node temp = queue.poll();
                result.add(temp.val);
                queue.addAll(temp.children);
            }
            queue.poll();
            queue.offer(null);
            ans.add(result);
        }
        return ans;

    }
}
