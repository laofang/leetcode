/**
 * Leetcode1672题，最富有客户的资产总量
 * 关键字：数组、矩阵
 * 主要思路：
 * 1. 行相加，取最大
 */
public class LC1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
}
