/**
 * Leetcode2319题，判断矩阵是否是一个X矩阵
 * 关键字：数组、矩阵
 * 主要思路：
 * 1. 对角线元素下标特点，从左上到右下i == j，从右上到左下 i + j = len - 1
 * 2. 对角线上的元素，和非对角线上的元素进行判断
 */
public class LC2319 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for(int i = 0;i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(i == j || i + j == n - 1) {
                    if(grid[i][j] == 0) return false;
                } else {
                    if(grid[i][j] != 0) return false;
                }
            }
        }
        return true;
    }
}
