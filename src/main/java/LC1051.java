import java.util.Arrays;

/**
 * Leetcode1051题，高度检查器
 * 关键字：数组、计数排序、排序
 * 主要思路：
 * 1. 排序，两数组对应位置进行对比，不同则增加统计
 */
public class LC1051 {
    public int heightChecker(int[] heights) {
        int[] sortArray = heights.clone();
        Arrays.sort(sortArray);
        int ans = 0;
        for(int i = 0; i < heights.length; i++) {
            if(sortArray[i] != heights[i]) ++ans;
        }
        return ans;
    }
}
