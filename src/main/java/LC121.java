/**
 * Leetcode121题，买卖股票的最佳时机
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 当前的值，减去前缀最小的数，如果差大于记录更新记录
 * 2. 如果当前值小于前缀最小值，更新前缀最小值
 */
public class LC121 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(prices[i] - min,ans);
            min = Math.min(prices[i],min);
        }
        return ans;
    }
}
