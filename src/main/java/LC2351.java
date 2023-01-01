/**
 * Leetcode2351题，第一个出现两次的字母
 * 关键字：哈希表、字符串、计数
 * 主要思路：
 * 1. 出现过的字符，用哈希表记录，记录过的再次出现，就将其返回
 */
public class LC2351 {
    public char repeatedCharacter(String s) {
        int[] table = new int[26];
        for(char ch : s.toCharArray()) {
            if(table[ch - 'a'] == 1) return ch;
            table[ch - 'a'] = 1;
        }
        return ' ';
    }
}
