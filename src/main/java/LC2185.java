/**
 * Leetcode2185题，统计包含给定前缀的字符串
 * 关键字：数组、字符串
 * 主要思路：
 * 1. 遍历字符串数组，如果当前字符串的前缀是pref，就更新记录
 */
public class LC2185 {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for(String str : words) {
            if(str.startsWith(pref)) ++ans;
        }
        return ans;
    }
}
