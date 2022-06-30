/**
 * Leetcode1175，质数排列
 * 关键字：数学
 * 主要思路：
 * 1. 先求出[0,n]的质数数量m,则非质数数量为n-m
 * 2. 最后的结果是  (m! * (n-m)!) % (1e9+7)
 * 注意事项：
 * 1. 开始把10的9次方写成了10e9，注意10的9次方是1e9
 */
public class LC1175 {
    final int k = (int)1e9 + 7;
    public int numPrimeArrangements(int n) {
        int primeCnt = primeCount(n);
        return (int)(f(primeCnt,primeCnt) * f(n - primeCnt,n - primeCnt) % k);
    }

    /**
     * [1,n]的质数数量
     * @param n
     * @return
     */
    public int primeCount(int n) {
        int count = 0;
        for(int v = 2; v <= n; v++) {
            int i = 2;
            for(; i * i < v;i++) {
                if(v % i == 0) break;
            }
            if(i * i > v) {
                count++;
            }
        }
        return count;
    }

    /**
     * 排列数
     * @param m
     * @param n
     * @return
     */
    public long f(int m,int n) {
        int w = n - m;
        long ans = 1;
        while(n > w) {
            ans %= k;
            ans *= n--;
        }
        return ans;
    }
}
