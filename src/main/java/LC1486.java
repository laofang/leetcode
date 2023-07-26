/**
 * Leetcode1486题，数组异或操作
 * 关键字：位运算、数学
 * 主要思路：
 * 1. 按规则异或操作即可
 */
public class LC1486 {
    public int xorOperation(int n, int start) {
        int ans = start;
        for(int i = 1; i < n; i++) {
            ans = ans ^ (start+2*i);
        }
        return ans;
    }
}
