/**
 * Leetcode1605题，·
 * 关键字：贪心、数组、矩阵
 * 主要思路：
 * 1. 这里的贪心，就是每次遍历，满足当前列或当前行的和的最小值（也就是行和或列和，最小的那个）
 */
public class LC1605 {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }
        return ans;
    }
}
