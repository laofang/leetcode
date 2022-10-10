import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode409题，最长回文串
 * 关键字：贪心、哈希表、字符串
 * 主要思路：
 * 1. 偶数数量的字符，都可以用来构成回文字符串
 * 2. 所有偶数字符的数量相加小于原字符串长度，还可以取一个作为中央字符
 */
public class LC409 {
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            int cnt = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),++cnt);
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 0) {
                ans += entry.getValue();
            } else {
                ans += (entry.getValue() - 1);
            }
        }
        return ans < s.length() ? ans + 1 : ans;
    }
}

//todo 逃课  801使序列递增的最小交换次数，困难