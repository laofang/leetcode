/**
 * Leetcode629题，K个逆序对数组
 * 关键字：动态规划、数学
 * 主要思路：
 * 1. 今天的题，真的有点儿难
 * 2. dp[i][j]代表1~i的序列，j个逆序对的序列有几个
 * 3. 我们可以想一下，第i个数字，分别放在1~i-1的每一个位置，此时，i与其后的都会产生新的逆序对
 * 4. f[i][j] = ∑f[i-1][j-k]
 * 5. 优化: f[i][j] = f[i][j-1] - f[i-1][j-i] + f[i-1][j]
 */
public class LC629 {
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        int[][] dp = new int[n+1][k+1];
        if(n != 0 && k == 0) {
            return 1;
        }
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n ; i++ ) {
            for(int j = 1; j <= k; j++) {
                dp[i][j] = dp[i][j-1]  - (j<i ? 0 : dp[i-1][j-i])  + dp[i-1][j];
                //如果答案特别大就mod 1e9+7
                if (dp[i][j] >= mod) {
                    dp[i][j] -= mod;
                } else if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                }
            }
        }
        return dp[n][k];
    }
}
