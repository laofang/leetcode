import java.util.Arrays;

/**
 * Leetcode2389题，和有限的最长子序列
 * 关键字：贪心、数组、二分查找、前缀和、排序
 * 主要思路：
 * 1. 贪心 + 排序 + 二分 + 前缀和
 * 2. 先对nums排序，并求出前缀和
 * 3. 在[0,nums.length-1]的范围内进行二分，使得满足dp[i] <= queries[j]时，的i值最大，记录i值
 */
public class LC2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        int[] dp = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i] = sum;
        }
        int[] ans = new int[m];
        for(int i = 0; i < m; i++) {
            int target = queries[i];
            int l = 0;
            int r = n - 1;
            while( l <= r) {
                int half = (l + r) >> 1;
                if(dp[half] > target) {
                    r = half - 1;
                } else {
                    l = half + 1;
                }
            }
            ans[i] = r + 1;
        }
        return ans;
    }
}
