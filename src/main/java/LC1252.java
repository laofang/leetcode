/**
 * Leetcode1252题，奇数值单元格的数目
 * 关键字：数组、数学、模拟
 * 主要思路：
 * 1. 分别统计每行增量和每列增量
 * 2. 假设需要加奇数值的行有a个，加奇数值的列有b个
 * 3. 根据2可以得出最终奇数单元格的数量为 a * (n - b) + (m - a) * b
 */
public class LC1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int i = 0; i < indices.length; i++) {
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }
        int oddx = 0;
        for (int row : rows) {
            if(row % 2 == 1) oddx++;
        }
        int oddy = 0;
        for (int col : cols) {
            if(col % 2 == 1) oddy++;
        }
        return oddx * (n - oddy) + (m - oddx) * oddy;
    }
}
