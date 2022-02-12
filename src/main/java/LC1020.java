/**
 * Leetcode1020题，飞地的数量
 * 关键字：二维数组、矩阵、回溯
 * 主要思路：
 * 1. 遍历四个边缘，如果是1，进行回溯
 * 2. 回溯过程就是将相邻的1点置为0
 * 3. 最后统计二维数组中1的数量即可
 */
public class LC1020 {
    private int[] directs = new int[]{-1,0,1,0,-1};
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int j = 0; j < n; j++) {
            if(grid[0][j] == 1) {
                traceBack(0,j,grid);
            }
            if(grid[m-1][j] == 1) {
                traceBack(m-1,j,grid);
            }
        }

        for(int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                traceBack(i, 0, grid);
            }
            if (grid[i][n - 1] == 1) {
                traceBack(i, n - 1, grid);
            }
        }

        int num = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    num++;
                }
            }
        }
        return num;
    }

    public void traceBack(int i ,int j,int[][] grid) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        for(int k = 0; k < directs.length - 1;k++) {
            grid[i][j] = 0;

            i += directs[k];
            j += directs[k+1];

            traceBack(i,j,grid);

            i -= directs[k];
            j -= directs[k+1];
        }
    }
}
