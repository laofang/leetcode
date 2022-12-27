/**
 * Leetcode2027题，转换字符串的最少操作次数
 * 关键字：贪心、字符串
 * 主要思路：
 * 1. 遍历字符串s，遇见'X'则结果统计+1，指针后移三位，否则后移一位
 */
public class LC2027 {
    public int minimumMoves(String s) {
        int ans = 0;
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == 'X') {
                ++ans;
                i += 3;
            } else {
                ++i;
            }
        }
        return ans;
    }
}
