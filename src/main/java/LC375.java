/**
 * Leetcode375题，猜数字大小II
 * 关键字：动态规划
 * 主要思路：
 * 1. 状态转移方程真的很难想到
 * 2. f(i,j) = Math.min(k + Math.max(f(i,k-1),f(k+1,j))
 * 3. 只要想到上面这个状态转移方程就可以做出来
 */
public class LC375 {
    public int getMoneyAmount(int n) {
        int dp[][] = new int[n+1][n+1];
        //(j,j + i)
        //i是间隔
        for(int i = 0; i <= n - 1;i++) {
            //j是左侧端点
            for(int j = 1; i + j <= n; j++) {
                //间隔为0时，即dp[x][x] = 0；
                if( i == 0 && j < n) {
                    dp[j][j+i] = 0;
                } else if(i == 1) {
                    //间隔为1时，就是Math.max(i,i+1)
                    dp[j][j+i] = j;
                } else  {
//                    System.out.println(i + " " +j);
                    //遍历k,在左右端点之间
                    for(int k = j + 1 ; k < i + j; k++) {
                        if(k == j+1) {
                            dp[j][j+i] = k + Math.max(dp[j][k-1],dp[k+1][i+j]);
                        }
                        dp[j][j+i] = Math.min(k + Math.max(dp[j][k-1],dp[k+1][i+j]),dp[j][j+i]);
                    }

                }

            }
        }
        return dp[1][n];
    }
}
