import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode637题，二叉树的层平均值
 * 关键字：树、深度优先搜索、广度优先搜索、二叉树
 * 主要思路：
 * 1. 深度优先搜索，记录每层的总和和数量，最后再依次求出平均值
 */
public class LC637 {
    Map<Integer,long[]> map = new HashMap<>();
    public List<Double> averageOfLevels(TreeNode root) {
        getVal(root,0);
        List<Double> ans = new ArrayList<>();
        for(long[] e : map.values()) {
            ans.add((double)e[0] / e[1]);
        }
        return ans;
    }
    public void getVal(TreeNode root, int layer) {
        if(root == null) return;
        long[] val = map.getOrDefault(layer,new long[2]);
        val[0] += root.val;
        val[1]++;
        map.put(layer,val);
        getVal(root.left,layer + 1);
        getVal(root.right,layer + 1);
    }
}
//todo,逃课 Leetcode1096题，花括号展开II，困难，栈