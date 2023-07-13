/**
 * Leetcode931题，下降路径最小和
 * 关键字: 数组、动态规划、矩阵
 * 主要思路：
 * 1. 动态规划，dp[i][j] = matrix + max(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1])
 */
public class LC931 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return matrix[0][0];
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int min;
                if(j == 0) {
                    min = dp[i-1][j+1];
                } else if(j == n-1) {
                    min = dp[i-1][j-1];
                } else {
                    min = Math.min(dp[i-1][j-1],dp[i-1][j+1]);
                }
                dp[i][j] = matrix[i][j] + Math.min(min,dp[i-1][j]);
                if(i == n-1) ans = Math.min(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
