/**
 * Leetcode326题，3的幂
 * 关键字：数学、递归
 * 主要思路：
 * 1. 可以循环也可以递归
 */
public class LC326 {
    public boolean isPowerOfThree(int n) {
        if(n == 1) return true;
        return n >= 3 && n % 3 == 0 ? isPowerOfThree(n / 3) : false;
    }
}
