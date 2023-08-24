/**
 * Leetcode1267题，统计参与通信的服务器
 * 关键字：深度优先搜索、广度优先搜索、并查集、数组、计数、矩阵
 * 主要思路：
 * 1. 分别记录行列的计算机数量
 * 2. 再进行遍历，如果当前位置有计算机，且行计算机或列计算机的数量大于等于2，就说明当前计算机可以和其他计算机通信累加计数
 */
public class LC1267 {
    public int countServers(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    if(rows[i] >= 2 || cols[j] >= 2) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
