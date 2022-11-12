/**
 * Leetcode791题，自定义字符串排序
 * 关键字：哈希表、字符串、排序
 * 主要思路：
 * 1. 统计待排序字符串中，每个字符出现的次数
 * 2. 再遍历order中的字符，通过统计表，查到数量，进行按顺序增添
 * 3. 最后再对，为在order中的字符，进行填充
 */
public class LC791 {
    public String customSortString(String order, String s) {
        int[] stat = new int[26];
        for(char ch : s.toCharArray()) {
            stat[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : order.toCharArray()) {
            for(int i = 0;i < stat[ch - 'a'];i++) {
                sb.append(ch);
            }
            stat[ch - 'a'] = 0;
        }
        for(int i = 0; i < stat.length; i++) {
            for(int j = 0; j < stat[i]; j++) {
                sb.append((char)('a'+i));
            }
        }
        return sb.toString();
    }
}
