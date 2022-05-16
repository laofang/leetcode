import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 面试题 04.06
 * 关键字：树、深度优先搜索、二叉搜索树、二叉树
 * 主要思路：
 * 1. 先中序遍历，插入数组
 * 2. 再找到指定节点的后一个
 * 优化：
 * 1. 根据BST的特点，使用递归方法优化
 */
public class LCInterview0406 {
    List<TreeNode> list = new ArrayList<>();
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        generateMiddleSequence(root);
        for(int i = 1; i < list.size();i++) {
            if(p.equals(list.get(i-1))) {
                return list.get(i);
            }
        }
        return null;
    }
    public void generateMiddleSequence(TreeNode root) {
        if(root != null) {
            generateMiddleSequence(root.left);
            list.add(root);
            generateMiddleSequence(root.right);
        }
    }
}
