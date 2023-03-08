/**
 * Leetcode 剑指offer 47题，礼物的最大值
 * 关键字：数组、动态规划、矩阵
 * 主要思路：
 * 1. 基础动态规划题目，dp[i][j]为从[0][0]走到[i][j]可获得礼物的最大值
 * 2. 递推表达式dp[i][j] = max(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j])
 */
public class LCoffer47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 0; i < m; i++) {
            for(int j = 0 ; j < n; j++) {
                if(i != 0 || j!= 0) {
                    dp[i][j] = Math.max(i > 0 ? dp[i-1][j] + grid[i][j] : 0, j > 0 ? dp[i][j-1] + grid[i][j] : 0);
                }
            }
        }
        return dp[m-1][n-1];
    }
}
