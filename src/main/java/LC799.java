/**
 * Leetcode799题，香槟塔
 * 关键字：动态规划
 * 主要思路：
 * 1. 采用动态规划，进行模拟
 * 2. 当前的酒杯g[i][j]最多能装1的容量的酒，剩余的酒g[i][j] - 1，会平分到下一层的相邻两个酒杯，g[i+1][j]和g[i+1][j+1]两个酒杯
 */
public class LC799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        int m = query_row;
        int n = query_glass;
        double[][] g = new double[m+1][m+1];
        g[0][0] = poured;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j <= i; j++) {
                if(g[i][j] > 1) {
                    g[i+1][j] += (g[i][j] - 1) / 2;
                    g[i+1][j+1] += (g[i][j] - 1) / 2;
                }
            }
        }
        return Math.min(g[m][n],1);
    }
}
