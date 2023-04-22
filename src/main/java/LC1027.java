/**
 * Leetcode1027题，最长等差数列
 * 关键字：数组、哈希表、二分查找、动态规划
 * 主要思路：
 * 1. 采用动态规划，设dp[i][k]表示以第i个元素为尾元素，k为公差的等差数列的长度
 * 2. 对于每个dp[i][k]，遍历dp[j][k](0 <= j < i)，dp[i][k] = max(dp[j][k] + 1，0 <= j < i)
 */
public class LC1027 {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][1001];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                int k = nums[i] - nums[j];
                k += 500;
                if (dp[j][k] + 1 > dp[i][k]) {
                    dp[i][k] = dp[j][k] + 1;
                }
                ans = Math.max(ans, dp[i][k]);
            }
        }
        return ans+1;
    }
}
