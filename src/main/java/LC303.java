/**
 * Leetcode303题，区域和检索-数组不可变
 * 关键字：设计、数组、前缀和
 * 主要思路：
 * 1. 先记录前缀和，在获取区域和的时候dp[right] - dp[left-1]
 */
public class LC303 {
    int[] dp;
    public LC303(int[] nums) {
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] += dp[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return left == 0 ? dp[right] : dp[right] - dp[left - 1];
    }
}
