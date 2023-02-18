import structure.CustomFunction;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode1237题，找出给定方程的正整数解
 * 关键字：数学、双指针、二分查找、交互
 * 主要思路：
 * 1. 可以二分，也可以全部遍历，我选择全部遍历
 * 2. 遍历范围内，可能的每一数对，符合标准的就放入答案列表
 */
public class LC1237 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i < 1001; i++) {
            for(int j = 1; j < 1001; j++) {
                List<Integer> temp = new ArrayList<>();
                if(customfunction.f(i,j) == z) {
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
