/**
 * Leetcode1015题，可被K整除的最小整数
 * 关键字：哈希表、数字
 * 主要思路：
 * 1. 要了解余数的一些相关性质
 */
public class LC1015 {
    public int smallestRepunitDivByK(int k) {
        int m = 0;

        for(int i =1; i <= k; i++) {
            m = (m * 10 + 1) % k;
            if(m == 0) return i;
        }
        return -1;
    }
}
