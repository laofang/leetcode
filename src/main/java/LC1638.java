/**
 * Leetcode1638题，统计只差一个字符的子串数目
 * 关键字：哈希表、字符串、动态规划
 * 主要思路：
 * 1. 枚举s和t的起始位置，然后同时遍历，在只有一个字符不同的时候，增加结果，在不同字符大于1个的时候，跳出本次比较循环
 */
public class LC1638 {
    public int countSubstrings(String s, String t) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < t.length(); j++) {
                int dif = 0;
                for(int k = 0; i + k < s.length() && j + k < t.length() ;k++) {
                    if(s.charAt(i + k) != t.charAt(j + k)) {
                        dif += 1;
                    }
                    if(dif > 1 ) break;
                    if(dif == 1) ans++;
                }
            }
        }
        return ans;
    }
}
