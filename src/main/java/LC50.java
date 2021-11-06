/**
 * Leetcode50题，Pow(x,n)
 * 关键字：快速幂算法
 * 主要思路：
 * 1. 第一种是递归方法，同样是快速幂算法，y = f(x,n / 2)，如果n % 2 == 0，f(x,n) = y * y，如果 n % 2 == 1, f(x,n) == y*y*x;
 * 2. 第二种是迭代法，也是快速幂算法，主要观察n，速幂的时候，指数部分是2的平方增长的方式，所以可以看n的二进制组成
 */
public class LC50 {
    public double myPow(double x, int n) {
        //n不用long，如果Integer.MIN_VALUE 相反数会溢出
        return (long)n > 0? quickMul(x,(long)n) : 1 / quickMul(x, -(long)n);
    }

    public double quickMul(double x, long n) {
        double ans = 1;
        double k = x;
        while (n > 0) {
            //二进制，为1的位置，就是可以指数可以相加的位置
            if( n % 2 == 1) {
                ans *= k;
            }
            k *= k;
            n /= 2;
        }
        return ans;
    }
}
