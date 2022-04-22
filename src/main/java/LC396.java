/**
 * Leetcode396题，旋转函数
 * 关键字：数学、数组、动态规划
 * 主要思路：
 * 1. 滑动窗口，sumRate - sum + nums.length * nums[i]
 */
public class LC396 {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int sumRate = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumRate += nums[i] * i;
        }
        ans = Math.max(sumRate,ans);
        for(int i = 0; i < nums.length-1; i++) {
            sumRate = sumRate - sum + nums.length * nums[i];
            ans = Math.max(ans, sumRate);
        }
        return ans;
    }
}
