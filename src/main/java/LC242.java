/**
 * Leetcode242题，有效的字母异位词
 * 关键字：哈希表、字符串、排序
 * 主要思路：
 * 1. s字符串每出现的每一个字符，对字符累计计数
 * 2. t字符串出现的每一个字符，对字符累计减少
 * 3. 如果最后记录都为0，返回true,否则返回false
 */
public class LC242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] target = new int[26];
        for(int i = 0; i < s.length();i++) {
            target[s.charAt(i) - 'a']++;
            target[t.charAt(i) - 'a']--;
        }
        for (int i : target) {
            if(i!=0) return false;
        }
        return true;
    }
}
