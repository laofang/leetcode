/**
 * Leetcode1624题，两个相同字符之间的最长子字符串
 * 关键字：哈希表、字符串
 * 主要思路：
 * 1. 遍历记录每一个新出现字符的索引（实际+1）
 * 2. 如果当前字符已经出现过，就计算两个相同字符的索引之差，根据差的大小更新结果
 */
public class LC1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] logs = new int[26];
        int ans = -1;
        for(int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if(logs[j] == 0) logs[j] = i + 1;
            else ans = Math.max(ans,i - logs[j]);
        }
        return ans;
    }
}
