/**
 * Leetcode688题，骑士在棋盘上的概率
 * 关键字：二维数组、动态规划、记忆化搜索
 * 主要思路：
 * 1. 动态规划dp[i][j][k]表示，从(i,j)出发，走k步，在棋盘上的概率
 * 2. 状态转移方程：dp[i][j][k] += dp[i1][j1][k-1] / 8
 * 3. (i1,j1)从i,j出发的下一个点，只有在(i1,j1)在棋盘之中才会执行状态转移方程
 */
public class LC688 {
    public double knightProbability(int n, int k, int row, int column) {
        //下一步的八个方向
        int[][] dirs = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
        //动态规划dp[i][j][k]表示，从(i,j)出发，走k步，在棋盘上的概率
        double[][][] dp = new double[n][n][k+1];

        //初始化dp[i][j][0]=1
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j][0] = 1;
            }
        }

        for(int x = 1; x < k+1; x++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n ;j++) {
                    for(int[] pos : dirs) {
                        int nx = i + pos[0];
                        int ny = j + pos[1];
                        //（nx,ny)在棋盘之中
                        if(nx >= 0 && ny >=0 && nx < n && ny < n) {
                            dp[i][j][x] += dp[nx][ny][x-1] / 8;
                        }
                    }
                }
            }
        }

        return dp[row][column][k];
    }
}
