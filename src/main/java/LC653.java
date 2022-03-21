import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode653题，两数之和IV-输入BST
 * 关键字：树、二叉树、二叉搜索树、深度优先搜索、广度优先搜索、哈希表、双指针
 * 主要思路：
 * 1. 遍历树，按leetcode第一题的方法来做
 */
public class LC653 {
    Map<Integer,Integer> map = new HashMap<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return false;
        }
        Integer temp = map.get(k - root.val);
        if(temp != null) {
            return true;
        } else {
            map.put(root.val,root.val);
            return findTarget(root.left,k) || findTarget(root.right,k);
        }
    }
}
