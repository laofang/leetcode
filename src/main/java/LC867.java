/**
 * Leetcode867题，转置矩阵
 * 关键字：数组、矩阵、模拟
 * 主要思路：
 * 1. 行列反转
 */
public class LC867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] ans = new int[n][m];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }
}
