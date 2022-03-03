/**
 * Leetcode258题，各位相加
 * 关键字：数学
 * 主要思路：
 * 1. (x*100+y*10+z) % 9 == ((x * 99 + y * 9) + (x + y + z)) %9 == (x + y + z) % 9
 */
public class LC258 {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
