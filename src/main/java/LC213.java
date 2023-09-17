/**
 * Leetcode213题，打家劫舍II
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 就是“打家劫舍”题目分两种情况讨论：
 *      1. 包含第一家，不包括最后一家
 *      2. 包含最后一家，不包括第一家
 */
public class LC213 {
    public int rob(int[] nums) {
        return Math.max(getResult(nums,0,nums.length - 1),getResult(nums,1,nums.length));
    }
    public int getResult(int[] nums, int start , int end) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        if(start + 1 == end) return dp[end-1];
        dp[start + 1] = Math.max(nums[start],nums[start + 1]);
        for(int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[end - 1];
    }
}
