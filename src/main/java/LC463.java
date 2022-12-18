/**
 * Leetcode463题，岛屿的周长
 * 关键字：深度优先搜索、广度优先搜索、数组、矩阵
 * 主要思路：
 * 1. 如果当前位置是陆地，遍历四个方向，只要不是陆地就增加一个边长，进行累计
 */
public class LC463 {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int[] direction = {-1,0,1,0,-1};
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    for(int k = 0; k < direction.length - 1; k++) {
                        int x = i + direction[k];
                        int y = j + direction[k+1];
                        if(x < 0 || y < 0 || x >= grid.length || y >= grid[i].length) {
                            ans++;
                        } else if(grid[x][y] == 0) ans++;
                    }
                }
            }
        }
        return ans;
    }
}
