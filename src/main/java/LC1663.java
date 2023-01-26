import java.util.Arrays;

/**
 * Leetcode1663题，具有给定数值的最小字符串
 * 关键字：贪心、字符串
 * 主要思路：
 * 1. 主要是采用贪心，先全部初始化为'a'，再从后往前尽量补'z'
 * 2. 补不上，就一次向前尝试
 */
public class LC1663 {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');
        int i = n - 1, d = k - n;
        for (; d > 25; d -= 25) {
            ans[i--] = 'z';
        }
        ans[i] = (char) ('a' + d);
        return String.valueOf(ans);
    }
}
