/**
 * Leetcode878题，第N个神奇的数字
 * 关键字：数学、二分查找
 * 主要思路：
 * 1. 最小公倍数可以用辗转相除法求得
 * 2. 设a,b最小公倍数为z，那么a,b的最大公约数是 a * b / z
 * 3. 一个数x，从1到x有多少个以a,b为约数的数，可以用 x / a + x / b - x / 最小公倍数 来计算
 * 4. 有了上面三条规律，再使用二分法进行查找，就可以得到答案
 */
public class LC878 {
    public int nthMagicalNumber(int n, int a, int b) {
        final int MOD = 1000000007;
        long zxgb = a * b / gcd(a,b);
        long left = 1;
        long right = (long)n * Math.max(a,b);
        while(left <= right) {
            long half = (left + right) / 2;
            long cnt = half / a + half / b - half / zxgb;
            if(cnt >= n) {
                right = half - 1;
            } else {
                left = half + 1;
            }
        }
        return (int) (left % MOD);
    }
    public int gcd(int a,int b) {
        return b == 0 ? a : gcd(b,a % b);
    }
}
