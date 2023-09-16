/**
 * Leetcode198题，打家劫舍
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 比较简单的动态规划题
 * 2. dp[i] = max(dp[i-2] + nums[i],dp[i-1])
 */
public class LC198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        if(dp.length == 1) return dp[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[dp.length - 1];
    }
}
