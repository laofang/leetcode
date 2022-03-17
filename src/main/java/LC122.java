/**
 * Leetcode122题，买卖股票的最佳时机
 * 关键字：贪心、数组、动态规划
 * 主要思路：
 * 1. 保持持有当前价格的股票，在以下的情况进行售卖
 *      1. 当前价格高于持有股票价格
 *      2. 后一日价格低于当前日价格
 * 2. 售卖后，后一日价格作为当前价格，继续遍历
 */
public class LC122 {
    public int maxProfit(int[] prices) {
        int cur = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > cur) {
                if( i == prices.length - 1 && prices[i] > cur) {
                    ans += prices[i] - cur;
                }
                if(i + 1 < prices.length && prices[i+1] < prices[i]) {
                    ans += prices[i] - cur;
                    cur = prices[i+1];
                    i = i + 1;
                }
            } else {
                cur = prices[i];
            }
        }
        return ans;
    }
}
