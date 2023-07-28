import java.util.Arrays;

/**
 * Leetcode2500题，删除每行中的最大值
 * 关键字：数组、矩阵、排序
 * 主要思路：
 * 1. 排每行排序，然后按列遍历，选择每列最大的加入答案
 */
public class LC2500 {
    public int deleteGreatestValue(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int ans = 0;
        for(int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for(int j = 0; j < grid.length; j++) {
                max = Math.max(grid[j][i],max);
            }
            ans += max;
        }
        return ans;
    }
}
