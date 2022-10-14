import java.util.Arrays;

/**
 * Leetcode940题，不同的子序列II
 * 关键字：字符串、动态规划
 * 主要思路：
 * 1. dp[i]表示以s[i]结尾的子串的数量， 则有dp[i] = dp[0] + dp[1] + ... + dp[i-1] + 1， 但这是会出现重复的
 * 2. 所以只要求每个字符最后出现位置为结尾的子串的数量和 + 1，就是dp[i]的值
 * 3. 最后再求一次以所有最后一次出现字符为结尾的子串数量和，就是答案
 * 复盘：
 * 1. 这道题是困难题，难在思路上，想到这种动态规划比较难，代码实践上没有什么难度
 */
public class LC940 {
    public int distinctSubseqII(String s) {
        int[] last = new int[26];
        int[] dp = new int[s.length()];
        Arrays.fill(last,-1);
        Arrays.fill(dp,1);
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < 26; j++) {
                if(last[j] != -1) {
                    dp[i] = (dp[i] + last[j]) % 1000000007;
                }
            }
            last[s.charAt(i) - 'a'] = dp[i];
        }
        int ans = 0;
        for(int i = 0; i < last.length; i++) {
            if(last[i] != -1) {
                ans = (ans + last[i]) % 1000000007;
            }
        }
        return ans;
    }
}
