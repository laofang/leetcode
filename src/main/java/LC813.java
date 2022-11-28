/**
 * Leetcode813题，最大平均值和的分组
 * 关键字：数组、动态规划、前缀和
 * 主要思路：
 * 1. 动态规划dp[i][j]表示前i个数字，分为j组时，最大的平均值和是多少
 * 2. 当j==1时，dp[i][j] = sum(nums[0~i]) / i;
 * 3. 当j > 1时，需要遍历m在j~i之间的dp[m][j] + 后部分的平均值，最大的那个为dp[i][j]的值
 * 4. 最后返回dp[n][k]
 */
public class LC813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        int sum[] = new int[n];
        sum[0] = nums[0];
        double[][] dp = new double[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            if(i < n) sum[i] = sum[i-1] + nums[i];
            for(int j = 1; j <= i && j <= k; j++) {
                if(j == 1) {
                    dp[i][j] = (double)sum[i-1] / i;
                } else {
                    for(int m = 1; m < i && i-m > j-1; m++) {
                        dp[i][j] = Math.max(dp[i][j],dp[i-m][j-1] + (double)(sum[i-1] - sum[i-m-1]) / m);
                    }
                }
            }
        }
        return dp[n][k];
    }
}
//todo LC813，最大平均值和的分组，经典的数组动态规划题，同时融入了前缀和，值得回味