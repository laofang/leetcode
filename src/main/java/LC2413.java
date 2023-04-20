/**
 * Leetcode2413题，最小偶倍数
 * 关键字：数学、数论
 * 主要思路：
 * 1. 如果n是偶数，n >= 1，n就是n和2的最小公倍数
 * 2. 如哦n是计数，2 * n，就是n和2的最小公倍数
 * 3. 最简单的题之一了
 */
public class LC2413 {
    public int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : 2 * n;
    }
}
