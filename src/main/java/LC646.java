import java.util.Arrays;

/**
 * Leetcode646题，最长数对链
 * 关键字：贪心、数组、动态规划、排序
 * 主要思路：
 * 1. 动态规划
 * 2. 先按pairs[i][0]排序，dp[i]定义以pairs[i]为终点，最长数对链的数量
 * 3. 从所有小于pairs[i][0]的pairs[j][1]中，找到最大的dp[j]
 */
public class LC646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(e1, e2) -> e1[0] - e2[0]);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp,1);
        for(int i = 0; i < pairs.length; i++) {
            for(int j = 0; j < i; j++) {
                if(pairs[i][0] > pairs[j][1])
                    dp[i] = Math.max(dp[j]+1,dp[i]);
            }
        }
        return dp[pairs.length-1];
    }
}
