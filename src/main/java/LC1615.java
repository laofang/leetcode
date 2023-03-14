/**
 * Leetcode1615题，最大网络秩
 * 关键字：图
 * 主要思路：
 * 1. 用数组矩阵来表示图
 * 2. 两个不同的城市相邻的道路数量，就是矩阵对应的行和列中1的数量，（如果这两个城市相邻，要减去1）
 * 3. 建立数组矩阵，同时统计每个城市相邻的道路数量，在遍历数组矩阵，更新最大值
 */
public class LC1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] graph = new int[n][n];
        int[] row = new int[n];
        int[] col = new int[n];
        for(int i = 0; i < roads.length;i++) {
            int x = roads[i][0];
            int y = roads[i][1];
            graph[x][y] = 1;
            row[x]++;
            col[y]++;
            graph[y][x] = 1;
            row[y]++;
            col[x]++;

        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                ans = Math.max(ans,row[i] + col[j] - graph[i][j]);
            }
        }
        return ans;
    }
}
