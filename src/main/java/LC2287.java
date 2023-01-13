/**
 * Leetcode2287题，重排字符形成目标字符串
 * 关键字：哈希表、字符串、计数
 * 主要思路：
 * 1. 统计s中每个字符出现的数量
 * 2. 再统计target字符串中，需要每个字符的数量
 * 3. 对应字符数量做商，最小的就是答案
 */
public class LC2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] map = new int[26];
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < s.length();i++) {
            map[s.charAt(i) - 'a']++;
        }
        int[] cnt = new int[26];
        for(int i = 0; i < target.length(); i++) {
            cnt[target.charAt(i) - 'a']++;
        }
        for(int i = 0; i < target.length(); i++) {
            ans = Math.min(ans,map[target.charAt(i) - 'a'] / cnt[target.charAt(i)-'a']);
        }
        return ans;
    }
}
