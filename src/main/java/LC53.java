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
            //遍历求和
            sum += num;
            //min是负数的时候，那么就有减的必要
            ans = Math.max(sum - min, ans);
            //前缀最小的
            min = Math.min(min,sum);
        }
        return ans;
    }
}
