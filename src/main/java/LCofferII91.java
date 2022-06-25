/**
 * Leetcode offerII 91题，粉刷房子
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 使用动态规划 ，dp[i][j]表示，第i个房子，选择j颜色时，需要的最小花费
 * 2. 动态转移方程，dp[i][j] += Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3]
 */
public class LCofferII91 {
    public int minCost(int[][] costs) {
        int i = 1;
        for(; i < costs.length; i++) {
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }
        int ans = Math.min( Math.min(costs[i-1][0],costs[i-1][1]) ,costs[i-1][2]);
        return ans;
    }
}
