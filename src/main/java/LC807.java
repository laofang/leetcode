/**
 * Leetcode807题，保持城市天际线
 * 关键字：数组
 * 主要思路：
 * 1. [i][j]元素 = Math.max(row[i],col[j])
 */
public class LC807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rows = new int[n];
        int[] cols = new int[n];
        //计算每行每列的最大值
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rows[i] = Math.max(rows[i],grid[i][j]);
                cols[j] = Math.max(cols[j],grid[i][j]);
            }
        }
        int ans = 0;
        //每个元素最终高度，取决于，元素所在行中最大值，和列中较小值的较小一个
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans += Math.min(rows[i],cols[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
