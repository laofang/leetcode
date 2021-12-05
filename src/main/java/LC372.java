/**
 * Leetcode372题，超级次方
 * 关键字：快速幂、数学
 * 主要思路：
 * 1. 主要得知道几个数学公式
 *      1. (a*b) % m = (a % m ) * (b%m) % m
 *      2. a^x * a^y = a^(x+y)
 */
public class LC372 {
    private final int MOD = 1337;
    public int superPow(int a, int[] b) {
        int ans = 1;
        for(int i = b.length - 1; i >= 0; i--) {
            ans = (int)((long)ans * power(a,b[i]) % MOD);
            a = power(a,10);
        }
        return ans;
    }

    /**
     * 快速幂变形
     * @param x
     * @param n
     * @return
     */
    public int power(int x,int n) {
        int res = 1;
        while (n > 0) {
            if(n % 2 != 0) {
                res = (int) ((long) res * x % MOD);
            }
            x = (int) ((long)x * x % MOD);
            n /= 2;
        }
        return res;
    }
}
