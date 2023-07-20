/**
 * Leetcode918题，环形数组的最大和
 * 关键字：队列、数组、分治、动态规划、单调队列
 * 主要思路：
 * 1. 求整个数组的和，最大子数组和，最小子数组和
 */
public class LC918 {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum =0;
        int curMax = 0;
        int curMin = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax,0) + nums[i];
            maxSum = Math.max(maxSum, curMax);

            curMin = Math.min(curMin,0) + nums[i];
            minSum = Math.min(minSum,curMin);

            sum += nums[i];
        }
        return minSum == sum ? maxSum : Math.max(sum - minSum,maxSum);
    }
}
