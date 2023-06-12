/**
 * Leetcode1137题，第N个泰波那契数
 * 关键字：记忆化搜索、数学、动态规划
 * 主要思路：
 * 1. 就是简单的动态规划，递归也行
 */
public class LC1137 {
    public int tribonacci(int n) {
        int[] array = new int[38];
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        array[3] = 2;
        for(int i = 4; i <= n; i++) {
            array[i] = array[i-1] + array[i-2] + array[i-3];
        }
        return array[n];
    }
}
