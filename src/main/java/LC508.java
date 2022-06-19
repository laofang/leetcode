import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode508题，出现次数最多的子树元素和
 * 关键字：树、深度优先搜索、二叉树、哈希表
 * 主要思路：
 * 1. 递归+记忆化搜索
 * 2. 记忆化搜索包括map<节点，树和>，map<树和，当前和出现的次数>，max记录出现的最大次数
 */
public class LC508 {
    private int max = Integer.MIN_VALUE;
    private Map<TreeNode,Integer> mapToSum = new HashMap<>();
    private Map<Integer,Integer> mapToCnt = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        getSum(root);
        List<Integer> list = new ArrayList<>();
        for(Integer key : mapToCnt.keySet()) {
            if(mapToCnt.get(key) == max) {
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
    public int getSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(mapToSum.get(root) != null) return mapToSum.get(root);
        int value = root.val + getSum(root.left) + getSum(root.right);
        mapToSum.put(root,value);
        int count = mapToCnt.getOrDefault(value,0);
        mapToCnt.put(value,++count);
        max = Math.max(max,count);
        return value;
    }
}
