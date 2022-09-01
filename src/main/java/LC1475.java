/**
 * Leetcode1475题，商品折扣后的最终价格
 * 关键字：栈、数组、单调栈
 * 主要思路：
 * 1. 双重遍历
 */
public class LC1475 {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            for (; j < prices.length; j++) {
                if(prices[j] <= prices[i]) {
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
            if(j == prices.length) ans[i] = prices[i];
        }
        return ans;
    }
}
