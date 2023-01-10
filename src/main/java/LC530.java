import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode530题，二叉搜索树的最小绝对差
 * 关键字：树、深度优先搜索、广度优先搜索、二叉搜索树、二叉树
 * 主要思路：
 * 1. 二叉搜索树，中序遍历，自然有序
 * 2. 再从有序列表中，找到最小两个数之间的差，只可能出现在相邻的两个数中
 */
public class LC530 {
    List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        searchTree(root);
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++) {
            ans = Math.min(ans,list.get(i) - list.get(i-1));
        }
        return ans;
    }
    public void searchTree(TreeNode root) {
        if(root == null) return;
        searchTree(root.left);
        list.add(root.val);
        searchTree(root.right);
    }
}
