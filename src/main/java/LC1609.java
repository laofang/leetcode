import structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode1609题，奇偶树
 * 关键字：二叉树、广度优先搜索、队列
 * 主要思路：
 * 1. 用广度优先搜索，遍历每一层
 * 2. 偶数层严格递增，每个元素要是奇数
 * 3. 奇数层严格递减，每个元素要是偶数
 */
public class LC1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<TreeNode> l = new LinkedList<>();
        l.add(root);
        int layer = 0;

        while(l.size() > 0) {
            layer = layer == 0 ? 1 : 0;
            int pre = layer == 1 ? 0 : Integer.MAX_VALUE;
            q.addAll(l);
            l.clear();
            while(!q.isEmpty()) {
                TreeNode t = q.poll();
                if(t.val % 2 == layer) {
                    if(layer == 1) {
                        if(t.val <= pre) return false;
                    } else {
                        if(t.val >= pre) return false;
                    }
                } else {
                    return false;
                }
                pre = t.val;
                if(t.left != null)
                    l.add(t.left);
                if(t.right != null)
                    l.add(t.right);
            }

        }
        return true;
    }
}
