/**
 * Leetcode1759题，统计同构子字符串的数目
 * 关键字：数字、字符串
 * 主要思路：
 * 1. 统计每一个含有相同字符的子串长度n，它可提供的同构字符串的数目是(1+n) * n / n
 * 2. 将上面计算结果进行累加，得到答案，要注意一溢出问题
 */
public class LC1759 {
    public int countHomogenous(String s) {
        final int MOD = 1000000007;
        char[] chs = s.toCharArray();
        int l, r = 0;
        long ans = 0;
        while (r < chs.length) {
            l = r;
            while(r < chs.length && chs[l] == chs[r]) ++r;
            long cnt = r - l;
            ans += (1 + cnt) * cnt / 2 % MOD;
            ans %= MOD;
        }
        return (int)(ans % MOD);
    }
}
