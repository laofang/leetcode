/**
 * Leetcode883题，三维形体投影面积
 * 关键字：几何、数学、数组、矩阵
 * 主要思路：
 * 1. 遍历二维数组，找出每一行和每一列的最大值，和就是正面和侧面的面积
 * 2. 每一个位置的正方体数量如果 > 0，就说明此处俯视图面积有1，累计即可
 */
public class LC883 {
    public int projectionArea(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        int top = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                cols[j] = Math.max(cols[j],grid[i][j]);
                rows[i] = Math.max(rows[i],grid[i][j]);
                if(grid[i][j] > 0) top++;
            }
        }
        int ans = 0;
        for (int col : cols) {
            ans += col;
        }
        for (int row : rows) {
            ans += row;
        }
        ans += top;
        return ans;
    }
}
