/**
 * Leetcode2373题，矩阵中的局部最大值
 * 关键字：数组、矩阵
 * 主要思路：
 * 1. 在(n-2,n-2)范围内，求出以每个元素为左上角元素的3*3矩阵中的最大值
 */
public class LC2373 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for(int i = 0; i < n-2; i++) {
            for(int j = 0; j < n-2; j++) {
                ans[i][j] = getMaxValue(i,j,grid);
            }
        }
        return ans;
    }
    public int getMaxValue(int i,int j,int[][] grid) {
        int result = 0;
        int in = i + 3;
        int jn = j + 3;
        for(; i < in; i++) {
            for(; j < jn; j++) {
                result = Math.max(result,grid[i][j]);
            }
            j = jn - 3;
        }
        return result;
    }
}
