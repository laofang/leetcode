/**
 * Leetcode1139题，最大以1为边界的正方形
 * 关键字：数组、动态规划、矩阵
 * 主要思路：
 * 1. 先计算每个位置，上和左最多连续1的数量
 * 2. 再以每个位置，作为待检测正方形的右下点
 * 3. 计算每个位置作为右下点的正方形的边长，遇到更大的就更新
 */
public class LC1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0)
                    continue;
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
                if (curSide <= maxSide)
                    continue;
                for (; curSide > maxSide; curSide--) {
                    if (dp[i][j - curSide + 1][1] >= curSide && dp[i - curSide + 1][j][0] >= curSide) {
                        maxSide = curSide;
                        break;
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}
