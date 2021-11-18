/**
 * Leetcode53题，最大子序和
 * 关键字：动态规划、分治法、数组
 * 主要思路：
 * 1. 遍历求和
 */
public class LC53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            ans = Math.max(sum - min, ans);
            min = Math.min(min,sum);
        }
        return ans;
    }
}
