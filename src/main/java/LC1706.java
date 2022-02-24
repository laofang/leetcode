/**
 * Leetcode1706题，球会落在何处
 * 关键词：数组、二维数组
 * 主要思路：
 * 1. 模拟小球掉落
 * 2. 如果是'\'，且当前的右侧是'/'或右边界，就卡住，否则到达下一层后一个位置
 * 3. 同样，如果是'/'，且当前的右侧是'\'或左边界，就卡出，否则就到达下一层前一个位置
 *
 */
public class LC1706 {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] ans = new int[n];


        for(int j = 0; j < n; j++) {
            int k = j;
            int i = 0;
            for(; i < m; i++) {
                if(grid[i][k] == 1) {
                    if(k == n - 1 || grid[i][k+1] == -1) {
                        ans[j] = -1;
                        break;
                    }
                    k++;
                } else {
                    if(k == 0 || grid[i][k-1] == 1) {
                        ans[j] = -1;
                        break;
                    }
                    k--;
                }
            }
            if(i < m) continue;
            ans[j] = k;
        }
        return ans;
    }
}
