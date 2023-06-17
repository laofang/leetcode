/**
 * Leetcode2481题，分割圆的最少切割次数
 * 关键字：几何、数学
 * 主要思路：
 * 1. n == 1时，不用切割返回0
 * 2. n > 1时，n是奇数，那就切割n次；如果是偶数，切割n/2次
 */
public class LC2481 {
    public int numberOfCuts(int n) {
        return n == 1 ? 0 : n % 2 == 1 ? n : n / 2;
    }
}
