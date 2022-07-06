/**
 * Leetcode338题，比特位计数
 * 关键字：位运算、动态规划
 * 主要思路：
 * 1. 每次数字是2^n的时候，只是对应0 多了一个高位，然后依次 2^n+1 比 1多一个高位1，2^n + 2 比2 多一个高位1……
 * 2. 直到2^(n+1)再次循环
 * 3.  00  01  10  11
 * 4. 100 101 110 111
 */
public class LC338 {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        if(n == 0) return ans;
        ans[1] = 1;
        int k = 2;
        int j = 0;
        for(int i = 2; i <= n;i++) {
            if(i % k == 0) {
                k *= 2;
                j = 0;
            }
            ans[i] = ans[j++] + 1;
        }
        return ans;
    }
}
