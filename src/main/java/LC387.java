/**
 * Leetcode387题，字符串种的第一个唯一字符
 * 关键字：队列、哈希表、字符串、计数
 * 主要思路：
 * 1. 遍历第一遍，记录每个字符出现的次数
 * 2. 再按原顺序遍历，如果当前字符只出现一次，返回当前字符的索引，如果遍历到结束，返回-1
 */
public class LC387 {
    public int firstUniqChar(String s) {
        int[] logs = new int[26];
        char[] chs = s.toCharArray();
        s.chars().forEach(e->logs[e-'a']++);
        for (int i = 0; i < chs.length; i++) {
            if(logs[chs[i]-'a'] == 1) return i;
        }
        return -1;
    }
}
