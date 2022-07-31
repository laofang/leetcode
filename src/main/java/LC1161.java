import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode1161题，最大层内元素和
 * 关键字：树、二叉树、广度优先搜索，深度优先搜索
 * 主要思路：
 * 1. 先深度优先搜索，计算出每一层的和，存入hash
 * 2. 再从hash中选出值最大值的层
 */
public class LC1161 {
    Map<Integer,Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int ans = Integer.MAX_VALUE;
    public int maxLevelSum(TreeNode root) {
        maxSum(root,1);
        for(int key : map.keySet()) {
            int value = map.get(key);

            if(value > max || value == max && key < ans) {
                max = value;
                ans = key;
            }
        }
        return ans;
    }
    public void maxSum(TreeNode root,int layer) {
        if(root == null) return;
        int value = map.getOrDefault(layer,0);
        value += root.val;
        map.put(layer,value);
        maxSum(root.left,layer+1);
        maxSum(root.right, layer + 1);
    }
}
