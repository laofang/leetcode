/**
 * Leetcode1837题，K进制表示下的个位数字总和
 * 关键字：数学
 * 主要思路：
 * 1. 按进制规则求出每位，并求和
 */
public class LC1837 {
    public int sumBase(int n, int k) {
        int sum = 0;
        while(n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }
}
