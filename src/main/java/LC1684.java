/**
 * Leetcode1684
 * 关键字：位运算、数组、哈希表、字符串
 * 主要思路：
 * 1. 哈希表，每个字符串的每个字符进行对比
 */
public class LC1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] array = new int[26];
        for(char ch : allowed.toCharArray()) {
            array[ch-'a'] = 1;
        }
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            int j = 0;
            for (; j < words[i].length(); j++) {
                if(array[words[i].charAt(j) - 'a'] != 1) break;
            }
            if(j == words[i].length()) ans++;
        }
        return ans;
    }
}
