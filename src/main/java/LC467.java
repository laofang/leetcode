/**
 * Leetcode467题，环绕字符串中唯一的子字符串
 * 关键字: 字符串、动态规划
 * 主要思路：
 * 1. 求出以每个字母结尾的p的子串长度，然后相加
 */
public class LC467 {
    public int findSubstringInWraproundString(String p) {
        int[] log = new int[26];
        int count = 1;
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            if(i != 0 && index == (p.charAt(i-1) - 'a' + 1) % 26) {
                ++count;
            } else {
                count = 1;
            }

            log[index] = Math.max(log[index],count);
        }
        int ans = 0;
        for (int i = 0; i < log.length; i++) {
            ans += log[i];
        }
        return ans;
    }
}
