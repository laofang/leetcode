import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode543题，二叉树的直径
 * 关键字：树、深度优先搜索、二叉树
 * 主要思路：
 * 1. 验证每个节点的左侧最深路径和右侧最深路径的和 + 2，进行最大值更新
 */
public class LC543 {
    int ans = 0;
    Map<TreeNode,Integer> map = new HashMap<>();
    public int diameterOfBinaryTree(TreeNode root) {
        f(root);
        return ans;
    }
    public int f(TreeNode root) {
        if(root == null) return -1;
        if(root.left == null && root.right == null) return 0;

        Integer leftVal = map.get(root.left);
        if(leftVal == null) {
            leftVal = f(root.left);
            map.put(root.left,leftVal);
        }

        Integer rightVal = map.get(root.right);
        if(rightVal == null) {
            rightVal = f(root.right);
            map.put(root.right,rightVal);
        }
        int maxPath = Math.max(leftVal + 1,rightVal + 1) ;
        map.put(root,maxPath);
        int sum = leftVal + rightVal + 2;
        ans = Math.max(ans,sum);
        return maxPath;
    }
}
//todo，LC543题 二叉树的直径，简单题，当前解法效率低，应该有更高效的解法