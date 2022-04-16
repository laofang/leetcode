/**
 * Leetcode479题，最大回文数乘积
 * 关键字：数学
 * 主要思路：
 * 1. n位数相乘，结果是2n-1或2n位数
 * 2. 以2n来计算，枚举左侧部分，然后生成一个回文数字p
 * 3. 枚举每一个n位数字x，测试 p % x == 0
 */
public class LC479 {
    public int largestPalindrome(int n) {
        if(n == 1) return 9;
        int upper = (int)Math.pow(10,n) - 1;
        int ans = 0;
        int left = upper;
        while(left > (int)Math.pow(10,n-1)) {
            long p = left;
            long x = (int) p;
            while(x != 0) {
                p = p * 10 + x % 10;
                x /= 10;
            }
            x = upper;

            while(x * x >= p) {
                if(p % x == 0) {
                    System.out.println(x + " " +p);
                    if( p / x < (int)Math.pow(10,n) && p / x > (int)Math.pow(10,n-1)) {
                        ans = (int) (p % 1337);
                        break;
                    }
                }
                x--;
            }
            if(ans > 0) break;
            left--;
        }
        return ans;
    }
}
