import java.util.Arrays;

/**
 * Leetcode2679题，矩阵中的和
 * 关键字：数组、矩阵、排序、模拟、堆
 * 主要思路：
 * 1. 对每一行排序
 * 2. 排序后的矩阵，每列最大值累加
 */
public class LC2679 {
    public int matrixSum(int[][] nums) {
        for(int i = 0; i < nums.length; i++) {
            Arrays.sort(nums[i]);
        }
        int m = nums[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++) {
            int max = 0;
            for(int j = 0; j < nums.length; j++) {
                max = Math.max(max,nums[j][i]);
            }
            ans += max;
        }
        return ans;
    }
}
