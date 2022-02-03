/**
 * Leetcode1414题，和为k的最少斐波那契额数字数目
 * 关键字：贪心、二分法
 * 主要思路：
 * 1. 贪心，每次找到最大的不小于k的值v
 * 2. 每次k - v，直到k-v==0
 * 3. 记录次数即可
 */
public class LC1414 {
    public int findMinFibonacciNumbers(int k) {
        int[] dp = new int[51];
        int ans = 0;
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < 51;i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        while(k > 0) {
            ans++;
            int left = 0;
            int right = 45;
            while(left <= right) {
                int half = (left + right) / 2;
                if(dp[half] <= k) {
                    left = half + 1;
                } else {
                    right = half - 1;
                }
            }
            k -= dp[right];
        }
        return ans;
    }
}
