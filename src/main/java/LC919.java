import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Leetcode919题，完全二叉树插入器
 * 关键字：树、二叉树、广度优先搜索、设计
 * 主要思路：
 * 1. 使用队列，初始化的时候，遍历给定的树，找到未满的根，作为队首
 * 2. 向未满的队首添加子节点，同时加入队列
 * 3. 如果加入节点后队首满了，将队首出列
 */
public class LC919 {
    TreeNode root;
    Queue<TreeNode> queue;
    public LC919(TreeNode root) {
        this.root = root;
        queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
            if(node.left == null || node.right == null) break;
            queue.poll();
        }
    }

    public int insert(int val) {
        TreeNode top = queue.peek();
        TreeNode newNode = new TreeNode(val);
        queue.offer(newNode);
        if(top.left == null) {
            top.left = newNode;
            return top.val;
        } else {
            top.right = newNode;
            queue.poll();
            return top.val;
        }
    }

    public TreeNode get_root() {
        return root;
    }
}
