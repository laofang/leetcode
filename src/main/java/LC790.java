/**
 * Leetcode790题，多米诺和托米诺平铺
 * 关键字：动态规划
 * 主要思路：
 * 1. 使用动态规划，要推出动态转移方程，尝试计算前五项总结规律
 * 2. 最后可以推出f(i) = 2 * f(n-1) + f(n-3)
 */
public class LC790 {
    public int numTilings(int n) {
        if(n == 1) return 1;
        final int MOD = 1000000007;
        long[] f = new long[n + 1];
        f[0] = 1;
        f[1] = 1;
        f[2] = 2;
        for(int i = 3; i <= n; i++) {
            f[i] = (2 * f[i-1] + f[i-3]) % MOD;
        }
        return (int)f[n];
    }
}
