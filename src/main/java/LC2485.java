/**
 * Leetcode2485题，找出中枢整数
 * 关键字：数组、前缀和
 * 主要思路：
 * 1. x = sqrt(n * n + n) / 2，如果x是整数就是中枢数，否则返回-1
 */
public class LC2485 {
    public int pivotInteger(int n) {
        int val = (int)Math.sqrt((n*n + n) / 2);
        return val * val == ( (n*n + n) / 2) ? val : -1;
    }
}
