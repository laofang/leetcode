/**
 * Leetcode764题，最大加号标志
 * 关键字：数组、动态规划
 * 主要思路：
 * 1. 进行预处理，求上下左右四个方向的前缀和
 * 2. 有了前缀和，就可以知道每个坐标的上下左右的延长距离，求最短，再用最短更新最大加号的记录
 */
public class LC764 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] board = new int[n+2][n+2];
        for (int[] mine : mines) {
            board[mine[0] + 1][mine[1] + 1] = 1;
        }
        int[][] t1 = new int[n + 2 ][n + 2];
        int[][] t2 = new int[n + 2][n + 2];
        int[][] t3 = new int[n + 2][n + 2];
        int[][] t4 = new int[n + 2][n + 2];
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(board[i][j] == 0) {
                    t1[i][j] = t1[i-1][j] + 1;
                    t2[i][j] = t2[i][j - 1] + 1;
                }
                if(board[n + 1 - i][n + 1 - j] == 0) {
                    t3[n + 1 - i][n + 1 - j] = t3[n + 2 - i][n + 1 - j] + 1;
                    t4[n + 1 - i][n + 1 - j] = t4[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }
        int ans = 0;
        for ( int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int min = Math.min(t1[i][j],Math.min(t2[i][j],Math.min(t3[i][j],t4[i][j])));
                ans = Math.max(ans,min);
            }
        }
        return ans;
    }
}
