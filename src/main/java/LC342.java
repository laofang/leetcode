/**
 * Leetcode342题，4的幂
 * 关键字：位运算、递归、数学
 * 主要思路：
 * 1. 2的幂具有(n & n-1) == 0的性质，而且4的幂必然是2的幂
 * 2. 4的幂2进制下只有一个1，而且在偶数位位置上
 * 3. n > 0 && (n & n-1) == 0 && n & 0xaaaaaaaa == 0
 */
public class LC342 {
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n&n-1) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
